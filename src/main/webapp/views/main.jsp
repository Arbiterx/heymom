<%@ page language="java" import="java.util.*" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="/static/js/jquery.js" type="text/javascript"></script>
    <script src="/static/js/prefixfree.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="/static/css/button.css" />
    <link rel="stylesheet" type="text/css" href="/static/css/demo.css" />
    <script type="text/javascript">
        $(function(){
        	$(".bt").css("opacity","1");
        });
    </script>

  </head>
  
  <body>
    <div class="container1">
        <br><br><br>
        <header>
            <h1>河马村 <span>管理后台</span></h1>
			<br>
        </header>
        <div class="bt">
            <div class="button" onclick="Link(0)"></div>
            <div class="button1" onclick="Link(1)"></div>
            <div class="button2" onclick="Link(2)"></div>
            <div style="clear:both"> </div> 
        </div>
    </div>
    <script>
    	function Link(num){
    		switch(num){
    			case 0:location.href="/backend/activity/list";
    				break;
   				case 1:location.href="/backend/resource/list";
   					break;
				case 2:location.href="/backend/coupon/list";
					break;
				default:location.href="/backend/choose/menu";
    		}
    		
    	}
    </script>
  </body>
</html>
