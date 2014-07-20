<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Time</title>
</head>
<base   target="_self">
<script>
	function return_action(){
		var datei = document.getElementById("date").value;
		var timei = document.getElementById("time").value;
		if(datei == "" || datei == null || timei =="" || timei == null)
			alert("输入信息不能为空");
		else{
			window.returnValue = datei+"|"+timei;
			window.close();
		}
	}
</script>
<body>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div align="center">
  <table width="612" height="211">
    <tr>
      <td width="237"><img src="img/time.jpg" width="203" height="194" /></td>
      <td width="263"><table width="341" height="146">
        <tr>
          <td width="137">Date:(yyyy-MM-dd)</td>
          <td width="192"><form id="form1" name="form1" method="post" action="">
            <label for="date"></label>
            <input type="text" name="date" id="date" />
          </form></td>
        </tr>
        <tr>
          <td>Time:(hh:mm:ss)</td>
          <td><form id="form2" name="form2" method="post" action="">
            <label for="time"></label>
            <input type="text" name="time" id="time" />
          </form></td>
        </tr>
      </table></td>
    </tr>
  </table>
  <p><a href="#" onclick="return_action()"><img src="img/continue_button.jpg" width="173" height="63" /></a></p>
</div>
<p>&nbsp;</p>
</body>
</html>