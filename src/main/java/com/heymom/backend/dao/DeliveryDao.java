package com.heymom.backend.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.heymom.backend.entity.Delivery;

public interface DeliveryDao extends BaseDao<Delivery, Integer> {
	@Query("from Delivery d where d.status>=0")
	public Page<Delivery> listAll(Pageable pageRequest);

	@Query("from Delivery where status>=0 and id in :ids")
	public List<Delivery> listByIds(@Param("ids") Iterable<Integer> ids);
}
