<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
#container{
	background-color: #FFFFFF;
	width: auto;
	margin: 0;
	padding: 0;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 30pt;
}
#block0, #block1, #block2, #block3, #block4, #block5 {
	border-top:1;
	margin: 1;
	padding: 1px;
}
.active {
background-color: #fff;
}
.visited {
	background-color: #FFFFFF;
}
#block0, #block0.active, #block0.visited {
	text-align: center;
	background-color: #FFFFFF;
	border-top: none;
	border-bottom: 0;
}
.color1 {
	color: #355FCA;
}
body {
	background-color: #FFFFFF;
}
</style>
<script>
var ScrollWin = {
w3c : document.getElementById,
iex : document.all,
scrollLoop : false,
scrollInterval : null, // setInterval id
currentBlock : null,   // object reference
getWindowHeight : function(){
if(this.iex) return (document.documentElement.clientHeight) ?
document.documentElement.clientHeight : document.body.clientHeight;
else return window.innerHeight;
},
getScrollLeft : function(){
if(this.iex) return (document.documentElement.scrollLeft) ?
document.documentElement.scrollLeft : document.body.scrollLeft;
else return window.pageXOffset;
},
getScrollTop : function(){
if(this.iex) return (document.documentElement.scrollTop) ?
document.documentElement.scrollTop : document.body.scrollTop;
else return window.pageYOffset;
},
getElementYpos : function(el){
var y = 0;
while(el.offsetParent){
y += el.offsetTop
el = el.offsetParent;
}
return y;
},
scroll : function(num){
if(!this.w3c){
location.href = "#"+this.anchorName+num;
return;
}
if(this.scrollLoop){
clearInterval(this.scrollInterval);
this.scrollLoop = false;
this.scrollInterval = null;
}
if(this.currentBlock != null) this.currentBlock.className = this.offClassName;
this.currentBlock = document.getElementById(this.blockName+num);
this.currentBlock.className = this.onClassName;
var doc = document.getElementById(this.containerName);
var documentHeight = this.getElementYpos(doc) + doc.offsetHeight;
var windowHeight = this.getWindowHeight();
var ypos = this.getElementYpos(this.currentBlock);
if(ypos > documentHeight - windowHeight) ypos = documentHeight - windowHeight;
this.scrollTo(0,ypos);
},
scrollTo : function(x,y){
if(this.scrollLoop){
var left = this.getScrollLeft();
var top = this.getScrollTop();
if(Math.abs(left-x) <= 1 && Math.abs(top-y) <= 1){
window.scrollTo(x,y);
clearInterval(this.scrollInterval);
this.scrollLoop = false;
this.scrollInterval = null;
}else{
window.scrollTo(left+(x-left)/10, top+(y-top)/10);
}
}else{
this.scrollInterval = setInterval("ScrollWin.scrollTo("+x+","+y+")",20);
this.scrollLoop = true;
}
}
};
ScrollWin.containerName = "container";
ScrollWin.anchorName    = "anchor";
ScrollWin.blockName     = "block";
ScrollWin.onClassName   = "active";
ScrollWin.offClassName  = "visited";
function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}

var thistype,this_date,this_time,this_gmailID,this_gmailPWD,this_weiboID,thattype,weiboID,weiboPWD,gmailDesID;
function this_time(){
	var feedback = window.showModalDialog("main_ifttt_this_time.jsp",null,"dialogHeight:500px,dialogWidth:600px");
	//document.getElementById("test").value = tempi;
	var temp = feedback.split('|');
	this_date = temp[0];
	this_time = temp[1];
	thistype = 'time';
	ScrollWin.scroll('3');
	//document.getElementById("test1").value = date+"%%%"+time;
}
function this_gmail(){
	var feedback = window.showModalDialog("main_ifttt_this_gmail.jsp",null,"dialogHeight:500px,dialogWidth:600px");
	var temp = feedback.split('|');
	this_gmailID = temp[0];
	this_gmailPWD = temp[1];
	thistype = 'gmail';
	ScrollWin.scroll('3');
	//document.getElementById("test2").value = gmailID+"%%%"+gmailPWD;
}
function this_weibo(){
	var feedback = window.showModalDialog("main_ifttt_this_sina.jsp",null,"dialogHeight:500px,dialogWidth:600px");
	this_weiboID = feedback;
	thistype = 'sina';
	ScrollWin.scroll('3');	
}
function that_weibo(){
	var feedback = window.showModalDialog("main_ifttt_that_sina.jsp",null,"dialogHeight:500px,dialogWidth:600px");
	var temp = feedback.split('|');
	weiboID = temp[0];
	weiboPWD = temp[1];	
	thattype = 'weibo';
	ScrollWin.scroll('4');
	//document.getElementById("test3").value = weiboID+"%%%"+weiboPWD;
}
function that_gmail(){
	var feedback = window.showModalDialog("main_ifttt_that_gmail.jsp",null,"dialogHeight:500px,dialogWidth:600px");
	gmailDesID = feedback;	
	//document.getElementById("test4").value = gmailDesID;
	thattype = 'gmail';
	ScrollWin.scroll('4');
}
function submit_request(){
	
	request.setAttribute("thistype",thistype);
	
	
	window.location.href="login.jsp";
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<%	String usr = request.getParameter("usr"); 
	if(usr == null)
		usr = "Home";
%>
<div align="center">
  <div id="container">
<div id="block1">
  <h6 align="right"><span class="color1"><a href="clientInfo/Home.html?"><img src="img/home.png" width="40" height="35" /><%=usr %></a> | <a href="contactus.jsp">Contact us</a></span></h6>
  <h1><img src="img/login.png" width="435" height="225" /></h1>
  <h1>IF <a href="#" onclick="javascript:ScrollWin.scroll('2'); return false;">THIS</a> THEN THAT</h1>
<p>&nbsp;</p>

<p>&nbsp;</p>
</div>
<p><a name="anchor2"></a></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp; </p>
<div id="block2">
  <p align="right"><a href="#" onclick="javascript:ScrollWin.scroll('1'); return false;"><img src="img/button-back.png" width="100" height="100" /></a></p>
  <h2>THIS:</h2>
  <!--input type="text" id="test1"--/>
  <input type="text" id="test2"/-->
  <p align="center"><a href="#"><img src="img/time.jpg" width="157" height="151" onclick="this_time()"/></a>&nbsp;&nbsp;<a href="#"><img src="img/gmail.jpg" width="153" height="149" onclick="this_gmail()" /></a>&nbsp;&nbsp;<a href="#"><img src="img/sina.png" width="150" height="150" onclick="this_weibo()"/></a></p>
  
</div>
<p><a name="anchor3"></a></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp; </p>
<div id="block3">
  <p align="right"><a href="#" onclick="javascript:ScrollWin.scroll('2'); return false;"><img src="img/button-back.png" width="100" height="100" /></a></p>
<h2>THAT:</h2>
 <!--input type="text" id="test3"/>
  <input type="text" id="test4"/-->
<p><a href="#"><img src="img/sina.png" width="150" height="154" onclick="that_weibo()" /></a>&nbsp;&nbsp;<a href="#"><img src="img/gmail.jpg" width="161" height="160" onclick="that_gmail()" /></a></p>

</div>
<div id="block4">
  <h6 align="right">&nbsp;</h6>
  <p align="right">&nbsp;</p>
  <p align="right">&nbsp;</p>
  <h1>IF THEN</h1>
<p>&nbsp;</p>
<p>&nbsp;</p>

<p>&nbsp;</p>
</div>
</div>
</div>
</body>

</html>