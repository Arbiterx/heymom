
<%@ page language="java" import="java.util.*" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ActivityManage.jsp' starting page</title>
    
	<script src="/static/js/jquery.js" type="text/javascript"></script>
    <script type="text/javascript" src="/static/js/jquery-1.5.1.js"></script>
    <link rel="stylesheet" type="text/css" href="/static/css/demo.css" />     
    <link rel="stylesheet" type="text/css" href="/static/css/activitylist.css"/>  
    <script type="text/javascript">
        $(document).ready(function(){
            document.getElementById("content").style.height = document.documentElement.clientHeight-155+"px";

        });
    </script>
    <script type="text/javascript">
        $(document).ready(function(){
            var tab = new $.fn.tab({
                tabList:"#demo1 .ui-tab-container .ui-tab-list li",
                contentList:"#demo1 .ui-tab-container .ui-tab-content"
            });  
        }); 
    </script>
    <script type="text/javascript">
    $(document).ready(function(e) {
        $("#selectList").find(".more").toggle(function(){
            $(this).addClass("more_bg");
            $(".more-none").show()
        },function(){
            $(this).removeClass("more_bg");
            $(".more-none").hide()
          });
    });
    </script>
  </head>
  
  <body>
    <div class="container">
            <br><br><br>
            <header style="padding: 0px 30px 0px 30px;">
                <h1>河马村 <span>管理后台</span></h1>
				<br>
            </header>
            <div id="container">
                <div class="shell">
                    <div id="main">
                        <div class="cl">&nbsp;</div>
                        <div id="content">
                            <div class="box">
                                <div class="box-head">
                                    <h2 class="left">活动管理</h2>
                                    <div class="right">
                                        <label>搜索活动</label>
                                        <input type="text" class="field small-field" />
                                        <input type="submit" class="button" value="搜索" />
                                    </div>
                                </div>
                                <div class="w1200">
                                  <div class="list-screen">
                                    <div class="screen-term">
                                      <div class="selectNumberScreen">
                                        <div id="selectList" class="screenBox screenBackground">
                                          <dl class="listIndex" attr="city">
                                            <dt>城市</dt>
                                            <dd>
                                              <label><a href="javascript:;" value="all" attrval="all">不限</a></label>
                                              <label>
                                                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                                <a href="javascript:;" value="beijing" attrval="beijing">北京</a></label>
                                              <label>
                                                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                                <a href="javascript:;" value="shanghai" attrval="shanghai">上海</a></label>
                                              <label>
                                                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                                <a href="javascript:;" value="hangzhou" attrval="hangzhou">杭州</a></label>
                                              <label>
                                                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                                <a href="javascript:;" value="nanjing" attrval="nanjing">南京</a></label>
                                            </dd>
                                          </dl>
                                          <dl class=" listIndex" attr="child">
                                            <dt>年龄段</dt>
                                            <dd>
                                              <label><a href="javascript:;" values2="" values1="" attrval="all">不限</a> </label>
                                              <label>
                                                <input name="radio2" type="radio" value="" />
                                                <a href="javascript:;" values2="3" values1="2" attrval="2-3"> 2-3岁</a> </label>
                                              <label>
                                                <input name="radio2" type="radio" value="" />
                                                <a href="javascript:;" values2="6" values1="4" attrval="4-6">4-6岁</a></label>
                                              <label>
                                                <input name="radio2" type="radio" value="" />
                                                <a href="javascript:;" values2="12" values1="7" attrval="7-12">7-12岁</a></label>
                                            </dd>
                                          </dl>
                                          <dl class="listIndex" attr="kind">
                                            <dt>活动类型</dt>
                                            <dd data-more=true>
                                              <label><a href="javascript:;" values2="" values1="" attrval="all">不限</a></label>
                                              <label>
                                                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                                <a href="javascript:;" values2="" values1="" attrval="interest">兴趣班</a></label>
                                              <label>
                                                <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                                <a href="javascript:;" values2="" values1="" attrval="playgame">亲子活动</a> </label>
                                              <label>
                                            </dd> 
                                          </dl>
                                        </div>
                                      </div>   
                                    </div>
                                  </div>
                                    
                                  <div class="hasBeenSelected clearfix" style="height: 30px;">
                                    <div style="float:right;" class="eliminateCriteria">【清空全部】 </div>
                                    <dl>
                                      <dt>已选条件：</dt>
                                      <dd style="DISPLAY: none" class=clearDd>
                                        <div class=clearList></div>
                                    </dl>
                                  </div>
                                  <script type="text/javascript" src="/static/js/shaixuan.js"></script> 
                                </div>
                                <div class="table" id="OddTable">
                                    <table id="StoreTable" width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <th style="width: 1%"></th>
                                            <th style="width: 35% ; text-align:center">活动主题</th>
                                            <th style="width: 10% ; text-align:center">活动状态</th>
                                            <th style="width: 15% ; text-align:center">报名情况</th>
                                            <th style="width: 19% ; text-align:center">编辑</th>
                                            <th style="width: 20% ; text-align:center" class="ac">删除</th>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox" class="checkbox" /></td>
                                            <td ><h3><a class="station" style="text-decoration: underline;cursor: pointer;" onclick="ShowStore(1)">如何培养小朋友的注意力</a></h3></td>
                                            <td >进行中</td>
                                            <td>5人报名/30</td>
                                            <td ><a class="ico edit" onclick="ShowStore(1)" style="cursor: pointer;">编辑</a></td>
                                            <td ><a class="ico del"style="cursor: pointer;">删除</a></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td  style="text-align:left"><img src="/static/images/add.png"><a onclick="ShowStore(1)" style="cursor: pointer;">新增活动</a></td>
                                            <td ></td>
                                            <td></td>
                                            <td ></td>
                                            <td ></td>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox" class="checkbox" onclick="SetAllChecked()"/></td>
                                            <td style="text-align:left"><h3>全选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="ico del"style="cursor: pointer;">删除</a></h3></td>
                                            <td ></td>
                                            <td></td>
                                            <td ></td>
                                            <td ></td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                </div>
            </div>
            <div style="text-align:center;width:988px;background-color: #F5F5F5; margin: 10px auto;">copyright:杭州菏马村信息技术有限公司</div>
        </div>
        <div class="overlay" id="spm" style="display: none;"></div>
        <div id="ShowStore"  class="Popup1" style="display: none;">
            <div class="Popup_top">
                <h2 id="EditNum1" style="font-family:Georgia, Times, Times New Roman, serif;margin:0;display: inline;"></h2>
                <a class="Close" onclick="Close(this,'Popup1')" style="cursor: pointer;"><img alt="关闭" src="/static/images/gif-0992.gif" /></a>
            </div>
            <div class="Popup_cen">
          
            </div>
        </div>
        <script type="text/javascript">
            function ShowStore(e){
                $('#ShowStore').css('display','block');
                $("#spm").show();
                var target=$('.Popup1');
                var targetWidth=target.outerWidth();
                var targetHeight=target.outerHeight();
                target.css({"margin-top":-parseInt(targetHeight/2)+"px","margin-left":-parseInt(targetWidth/2)+"px"});
                target.show();
                return false;
            }

            function Close(e,classname){
                $(e).parents("."+classname).hide();
                $("#spm").hide();
            }

            function SetAllChecked(){
                if ($('.checkbox').attr('checked')==true) 
                {
                    $(".checkbox").removeAttr('checked');
                }
                
                else
                {
                    $(".checkbox").attr("checked",'true');
                }
                
            }
        </script>
  </body>
</html>
