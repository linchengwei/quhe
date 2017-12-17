<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>首页</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="css/reset.css" />
<script type="text/javascript" src="js/lunbotu.js"></script>
</head>

<body>
	<header > <!--头部-->
	<div class="page-container" id="nav">
		<div id="logo" class="logo">
			<a href="index.jsp" target="_self" title="首页"> <img title="趣盒"
				src="img/logo.png" />
			</a>
		</div>

		<div class="login-area">
			<ul class="header-unlogin clearfix">
				<li class="header-signin">
					<%
						String userid = (String) session.getAttribute("userid");
						if (userid != null && !userid.equals("")) {
					%> <a href="me.html" target="_self"><%=userid %>的信息</a> <a
					href="VideoUpdate.html" target="_self">视频上传</a> <%
 	} else {
 %> <a href="login.html" target="_self">登录</a> <a
					href="register.html" target="_self">注册</a> <%
 	}
 %>

				</li>
			</ul>
		</div>

		<div class="search-warp">
			<input class="search-box" type="text" placeholder="请输入你想了解的技能" "/>
			<button class="button" value="搜索">GO</button>
		</div>

	</div>
	</header>
	<div class="content">
		<!--内容区-->
		<div class="content-box">
			<div class="left-area">
				<div class="main-list">
					<div class="list-name">
						<a href="/quhe/ListServlet.do" target="_blank">计算机</a>
					</div>
				</div>
				<div class="main-list">
					<div class="list-name">
						<a href="/quhe/ListServlet.do" target="_blank">音乐</a>
					</div>
				</div>
				<div class="main-list">
					<div class="list-name">
						<a href="/quhe/ListServlet.do" target="_blank">美术</a>
					</div>
				</div>
				<div class="main-list">
					<div class="list-name">
						<a href="/quhe/ListServlet.do" target="_blank">语言</a>
					</div>
				</div>
				<div class="main-list">
					<div class="list-name">
						<a href="/quhe/ListServlet.do" target="_blank">其它</a>
					</div>
				</div>
			</div>
			<div class="right-area">
				<div id="container">
					<div id="list" style="left: -900px;">
						<img src="img/list4.png" alt="1"> <img src="img/list1.png"
							alt="1"> <img src="img/list2.png" alt="2"> <img
							src="img/list3.png" alt="3"> <img src="img/list4.png"
							alt="4"> <img src="img/list1.png" alt="4">
					</div>
					<div id="buttons">
						<span index="1" class="on"></span> <span index="2"></span> <span
							index="3"></span> <span index="4"></span>
					</div>
					<a href="javascript:;" id="prev" class="arrow">&lt;</a> <a
						href="javascript:;" id="next" class="arrow">&gt;</a>
				</div>
			</div>
		</div>
	</div>
	<footer><!--脚注-->
	<ul class="share-group">
		<li><a href="https://weibo.com/" target="_blank"><img
				src="img/新浪微博.png" /></a></li>
		<li><a href="https://www.baidu.com/" target="_blank"><img
				src="img/百度.png" /></a></li>
		<li><a href="http://www.qq.com/" target="_blank"><img
				src="img/腾讯.png" /></a></li>
		<li><a href="https://qzone.qq.com/" target="_blank"><img
				src="img/空间.png" /></a></li>
	</ul>
	<div class="copy">
		<p>
			<a href="#">趣盒简介</a><i>|</i><a href="#">趣盒公告</a><i>|</i><a href="#">招贤纳士</a><i>|</i><a
				href="#">联系我们</a>
		</p>
		&copy; 趣盒 2017年（1.0版本）闽ICP备 xxxxxxxx号

	</div>
	</footer>

	<button class="back-to-top">返回顶部</button>
	<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
	<script type="text/javascript" src="js/main.js"></script>



</body>
</html>
