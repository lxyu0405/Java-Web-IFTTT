<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Gmail</title>
</head>
<base   target="_self">
<script>
	function return_action(){
		var id = document.getElementById("gmailID").value;
		var pwd = document.getElementById("gmailPWD").value;
		if(id == "" || id == null || pwd =="" || pwd == null)
			alert("输入信息不能为空");
		else{
			window.returnValue = id+"|"+pwd;
			window.close();
		}
	}
</script>
<body>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div align="center">
  <table width="512" height="180">
    <tr>
      <td width="184"><img src="img/gmail.jpg" width="161" height="138" /></td>
      <td width="385"><table width="335" height="108">
        <tr>
          <td width="112" align="center">ID:</td>
          <td width="196"><form id="form1" name="form1" method="post" action="">
            <label for="gmailID2"></label>
            <input name="gmailID" type="text" id="gmailID" />
          </form></td>
        </tr>
        <tr>
          <td align="center">Password:</td>
          <td><form id="form2" name="form2" method="post" action="">
            <label for="gmailPWD"></label>
            <input type="password" name="gmailPWD" id="gmailPWD" />
          </form></td>
        </tr>
      </table></td>
    </tr>
  </table>
  <p><a href="#" onclick="return_action()"><img src="img/continue_button.jpg" width="160" height="66"/></a></p>
</div>
<p align="center">&nbsp;</p>
</body>
</html>