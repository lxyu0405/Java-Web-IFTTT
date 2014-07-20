<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>
<base   target="_self">
<script>
	function return_action(){
		var weiboID = document.getElementById("weiboID").value;
		var weiboPWD = document.getElementById("weiboPWD").value;
		if(weiboID == "" || weiboID == null || weiboPWD =="" || weiboPWD == null)
			alert("输入信息不能为空");
		else{
			window.returnValue = weiboID+"|"+weiboPWD;
			window.close();
		}
	}
</script>
<body>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div align="center">
  <table width="600" height="189">
    <tr>
      <td width="216"><img src="img/sina.png" width="184" height="180" /></td>
      <td width="372"><table width="374" height="118">
        <tr>
          <td width="82">ID:</td>
          <td width="278"><form id="form1" name="form1" method="post" action="">
            <label for="weiboID"></label>
            <input type="text" name="weiboID" id="weiboID" />
          </form></td>
        </tr>
        <tr>
          <td>Password:</td>
          <td><form id="form2" name="form2" method="post" action="">
            <label for="weiboPWD"></label>
            <input type="password" name="weiboPWD" id="weiboPWD" />
          </form></td>
        </tr>
      </table></td>
    </tr>
  </table>
  <p><a href="#" onclick="return_action()"><img src="img/continue_button.jpg" width="202" height="73" /></a></p>
</div>
<p>&nbsp;</p>
</body>
</html>