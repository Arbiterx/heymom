<%@ page language="java" import="java.util.*" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ResourceManage.jsp' starting page</title>
    
	<script src="/static/js/jquery.js" type="text/javascript"></script>
        <script type="text/javascript" src="/static/js/jquery-1.5.1.js"></script>
        <script type="text/javascript" src="/static/js/ui.tab.js"></script>
        <link rel="stylesheet" type="text/css" href="/static/css/demo.css" />     
        <link rel="stylesheet" type="text/css" href="/static/css/activitylist.css"/>  
        <script type="text/javascript">
            $(document).ready(function(){
                document.getElementById("content").style.height = document.documentElement.clientHeight-185+"px";

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

  </head>
  
  <body>
    <div class="container">
            <br><br><br>
            <header>
                <h1>����� <span>�����̨</span></h1>
				<br>
            </header>
            <div id="container">
                <div class="shell">
                    <div id="main">
                        <div class="cl">&nbsp;</div>
                        <div id="content">
                            <div class="box">
                                <div class="box-head">
                                    <h2 class="left">��Դλ����</h2>
                                </div>
                                <div class="table" id="OddTable">
                                    <table id="StoreTable" width="100%" border="0" cellspacing="0" cellpadding="0">
                                        <tr>
                                            <th style="width: 1%"></th>
                                            <th style="width: 35% ; text-align:center">�����</th>
                                            <th style="width: 24% ; text-align:center">��Դλ��</th>
                                            <th style="width: 20% ; text-align:center">�༭</th>
                                            <th style="width: 20% ; text-align:center" class="ac">ɾ��</th>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox" class="checkbox" /></td>
                                            <td ><h3><a class="station" style="text-decoration: underline;cursor:pointer;" onclick="ShowStore(1)">�������С���ѵ�ע����</a></h3></td>
                                            <td>��ҳ������Դλ1</td>
                                            <td ><a class="ico edit" onclick="ShowStore(2)" style="cursor: pointer;">�༭</a></td>
                                            <td ><a class="ico del" style="cursor: pointer;">ɾ��</a></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td  style="text-align:left"><img src="/static/images/add.png"><a onclick="ShowStore(3)" style="cursor: pointer;">������Դλ</a></td>
                                            <td ></td>
                                            <td></td>
                                            <td ></td>
                                        </tr>
                                        <tr>
                                            <td><input type="checkbox" class="checkbox" onclick="SetAllChecked()"/></td>
                                            <td style="text-align:left"><h3>ȫѡ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="ico del" style="cursor: pointer;">ɾ��</a></h3></td>
                                            <td ></td>
                                            <td></td>
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
            <div style="text-align:center;width:988px;background-color: #F5F5F5; margin: 10px auto;">copyright:���ݺ������Ϣ�������޹�˾</div>
        </div>
        <div class="overlay" id="spm" style="display: none;"></div>
        <div id="ShowStore2"  class="Popup2" style="display: none;">
            <div class="Popup_top">
                <h2 id="EditNum1" style="font-family:Georgia, Times, Times New Roman, serif;margin:0;display: inline;font-size:18px;font-weight:bold">��̨��Դλ�༭</h2>
                <a class="Close" onclick="Close(this,'Popup2')" style="cursor: pointer;"><img alt="�ر�" src="/static/images/gif-0992.gif" /></a>
            </div>
            <div class="Popup_cen1">
                <form >
                    <div style="margin-left:25px;">
                        <div style="float:left;font-size:18px;margin-top:20px;">��ԴλͼƬ��</div>
                        <input type="text" style="width:200px;hight:25px;float:left;margin-left:2px;margin-top:20px;"> 
                    </div>
                    <div style="float:left;margin-left:25px;">
                        <div style="font-size:18px;float:left;margin-top:20px;">��ת���ӣ�</div>
                        <input type="text" style="width:200px;hight:25px;margin-left:20px;float:left;margin-top:20px;"> 
                    </div><br/>
                    <!-- <div style="text-align:center;"><input type="submit" value="����" style="margin-top:40px;"></div> -->
                </form>
            </div>
        </div>
        <div id="ShowStore1"  class="Popup1" style="display: none;">
            <div class="Popup_top">
                <h2 id="EditNum1" style="font-family:Georgia, Times, Times New Roman, serif;margin:0;display: inline;"></h2>
                <a class="Close" onclick="Close(this,'Popup1')" style="cursor: pointer;"><img alt="�ر�" src="/static/images/gif-0992.gif" /></a>
            </div>
            <div class="Popup_cen">
                
            </div>
        </div>
        <div id="ShowStore3"  class="Popup3" style="display: none;">
            <div class="Popup_top">
                <h2 id="EditNum1" style="font-family:Georgia, Times, Times New Roman, serif;margin:0;display: inline;font-size:18px;font-weight:bold">��̨��Դλ�༭</h2>
                <a class="Close" onclick="Close(this,'Popup3')" style="cursor: pointer;"><img alt="�ر�" src="/static/images/gif-0992.gif" /></a>
            </div>
            <div class="Popup_cen1">
                <div style="margin-left:25px;">
                    <div style="float:left;font-size:18px;margin-top:20px;">��ԴλͼƬ��</div>
                    <input type="text" style="width:200px;hight:25px;float:left;margin-left:2px;margin-top:20px;"> 
                </div>
                <div style="float:left;margin-left:25px;">
                    <div style="font-size:18px;float:left;margin-top:20px;">��ת���ӣ�</div>
                    <input type="text" style="width:200px;hight:25px;margin-left:20px;float:left;margin-top:20px;"> 
                </div>
                <div style="float:left;margin-left:25px;">
                    <div style="font-size:18px;float:left;margin-top:20px;">��Դλ�ã�</div>
                    <select type="text" style="width:200px;hight:25px;margin-left:20px;float:left;margin-top:20px;"><option>��ҳ������Դλ2</option><option>��ҳ������Դλ3</option></select> 
                </div>
            </div>
        </div>
        <script type="text/javascript">
            function ShowStore(e){
                
                switch(e){
                    case 1:$('#ShowStore1').css('display','block');
                            var target=$('.Popup1');
                        break;
                    case 2:$('#ShowStore2').css('display','block');
                            var target=$('.Popup2');
                        break;
                    case 3:$('#ShowStore3').css('display','block');
                        var target=$('.Popup3');
                        break;
                }
                
                $("#spm").show();
                
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
