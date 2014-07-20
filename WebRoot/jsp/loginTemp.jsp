<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>IFTTT login</title>
<style type="text/css">
body {
	background-color: #FFFFFF;
	background-image: url(img/sexy.jpg);
}
#form1 div table tr td {
	color: #B4DFEF;
}
</style>
</head>

<body>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div align="center">
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
</div>
<form id="form1" name="form1" method="post" action="LoginServlet">
  <div align="center">
    <table width="200" >
      <tr>
        <td>User:</td>
        <td><label for="username"></label>
        <input type="text" name="username" id="username" /></td>
      </tr>
      <tr>
        <td height="51">Password:</td>
        <td><label for="password"></label>
        <input type="password" name="password" id="password" /></td>
      </tr>
    </table>
  </div>
  <p align="center">
    <input type="submit" name="submit" id="submit" value="Log In" />
    &nbsp;&nbsp;
    <input type="button" name="signup" id="button" value="Sign Up" onClick="window.location.href='signup.jsp'"/>
  </p>
  
</form>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p align="right"><a href="contactus.jsp">Copyright @ FlamesTeam (Contact Flames)</a></p>
</body>
</html>

<script>
var errori='<%=request.getParameter("error")%>';
if(errori == 'yes'){
	alert("用户名或密码错误");
}
else if(errori == 'false'){
	alert("注册成功");
}
</script>