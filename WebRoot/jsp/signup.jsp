<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*"%>
<html>
  <head>
    <title>IFTTT Sign Up page</title>
  </head>
  <p align="center"><img src="img/signup.png" width="329" height="265"></p>

  <form name="form1" method="post" action="SignupServlet">
    <div align="center">
      <table width="354">
        <tr>
          <td width="80"><div align="left">User:</div></td>
          
          <td width="144"><input name="signupname" type="text" id="signupname2"></td>
          
          <td width="114">*(数字或字母)</td>
        </tr>
        <tr>
          <td><div align="left">Password:</div></td>
          <td><input name="signuppwd" type="password" id="signuppwd"></td>
          <td width="114">*(数字或字母)</td>
        </tr>
        <tr>
          <td><div align="left">Confirm:</div></td>
          <td><input name="signupconfirm" type="password" id="signupconfirm"></td>
          <td><label for="signupconfirm"></label></td>
        </tr>
      </table>
      <p>
        <input type="submit" name="submit" id="submit" value="Confirm">&nbsp;&nbsp;
        <input type="reset" name="reset" id="reset" value="Reset">
      </p>
    </div>
  </form>
  <p align="right">&nbsp;</p>
  <p align="right">&nbsp;</p>
  <p align="right">&nbsp;</p>
  <p align="right"><a href="contactus.jsp">Copyright @ FlamesTeam (Contact Flames)</a></p>
  <p>&nbsp;</p>
  </body>
</html>


<script>
var errori='<%=request.getParameter("errortype")%>';
if(errori == 'pwderror'){
	alert("输入密码不一致！");
}
else if(errori == 'usrerror'){
	alert("用户名已存在");
}
else if(errori == 'formaterror'){
	alert("用户名密码格式不正确！");
}
</script>