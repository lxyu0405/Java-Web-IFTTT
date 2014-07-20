<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">
body,td,th {
	font-family: Verdana, Geneva, sans-serif;
	font-size: 16px;
	color: #000;
}
body {
	background-color: #CFC;
	margin-left: 10px;
	margin-top: 10px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
</head>

<body>
<table width="150" border="0">
  <tr>
    <td><div align="center"><a href="clientinfo.jsp" target="mainFrame" id="userInfo">个人信息</a></div></td>
  </tr>
  <tr>
    <td><div align="center"><a href="transactioninfo.jsp" target="mainFrame" id="transactions">交易记录</a></div></td>
  </tr>
  <tr>
    <td><div align="center"><a href="taskinfo.jsp" target="mainFrame" id="tasks">任务信息</a></div></td>
  </tr>
  <tr>
    <td><div align="center">站内信</div></td>
  </tr>
  <tr>
    <td><div align="center">公告</div></td>
  </tr>
</table>
</body>
</html>
