<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login Page of Heymom</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
	<meta name="description" content="Login Form with HTML5 and CSS3" />
	
	<link rel="stylesheet" type="text/css" href="/static/css/demo.css" />
	<link rel="stylesheet" type="text/css" href="/static/css/style.css" />
	<link rel="stylesheet" type="text/css" href="/static/css/animate-custom.css" />
</head>
<body>
	<div class="container">
       <br><br><br>
       <header>
      		<h1>河马村 <span>管理后台</span></h1>
			<br>
       </header>
       <section>				
           <div id="container_demo" >
              <a class="hiddenanchor" id="toregister"></a>
              <a class="hiddenanchor" id="tologin"></a>
              <div id="wrapper">
                   <div id="login" class="animate form">
                       <form  action="mysuperscript.php" method="post"> 
                           <h1>登 录</h1> 
                           <p> 
                               <label for="username" class="uname" data-icon="u" > Your username </label>
                               <input id="username" name="username" required="required" type="text" placeholder="Administrator Of Heymom"/>
                           </p>
                           <p> 
                               <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                               <input id="password" name="password" required="required" type="password" placeholder="********" /> 
                           </p>
                           <p class="keeplogin"> 
								<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
								<label for="loginkeeping">Keep me logged in</label>
							</p>
                           <p class="login button"> 
                               <input type="submit" value="Login" /> 
							</p>
                           <p class="change_link">
				
							</p>
                       </form>
                   </div>
	
               </div>
           </div>  
       </section>
    </div>
</body>
</html>