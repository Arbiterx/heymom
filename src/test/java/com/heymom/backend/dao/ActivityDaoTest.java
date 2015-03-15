package com.heymom.backend.dao;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heymom.backend.dto.activity.ActivityDto;
import com.heymom.backend.entity.activity.Activity;
import com.heymom.backend.utils.DtoUtils;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-context.xml" })
public class ActivityDaoTest {
	@Autowired
	private ActivityDao activityDao;

	@Before
	public void setUp() throws Exception {
		Activity a1 = new Activity();
		a1.setName("test1");
		a1.setType(1);
		activityDao.save(a1);
		Activity a2 = new Activity();
		a2.setName("test1");
		a2.setType(1);
		activityDao.save(a2);
	}

	@After
	public void tearDown() throws Exception {
		activityDao.deleteAll();
	}

	@Test
	public void testListByAvaliable() {
		Pageable pageRequest = new PageRequest(0, 10, new Sort(Sort.Direction.ASC, "createTime"));
		Page<Activity> p = activityDao.listAvaliableActivities(pageRequest);
		Page<ActivityDto> pDto = DtoUtils.activityDtoUtil.toDTO(p);
		Assert.assertNotNull(p);
		Assert.assertEquals(1, p.getTotalPages());
		Assert.assertEquals(2, p.getTotalElements());
		Assert.assertEquals(p.getNumber(), pDto.getNumber());
		Assert.assertEquals(p.getTotalElements(), pDto.getTotalElements());
		Assert.assertEquals(p.getTotalPages(), pDto.getTotalPages());
		Assert.assertEquals(p.getContent().size(), pDto.getContent().size());
	}
}
