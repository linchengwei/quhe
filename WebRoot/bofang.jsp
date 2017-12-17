<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>播放视频界面</title>
</head>
<%
	// 获取请求的上下文
	String context = request.getContextPath();
%>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="css/reset.css" />


<body>


	<header> <!--头部-->
	<div class="page-container" id="nav">
		<div id="logo" class="logo">
			<a href="index.html" target="_self" title="首页"> <img title="趣盒"
				src="img/logo.png" />
			</a>
		</div>
		<div class="login-area">
			<ul class="header-unlogin clearfix">
				<li class="header-signin"><a href="me.html" target="_self">我的信息</a>
					<a href="index2.html" target="_self">首页</a></li>
			</ul>
		</div>
	</div>
	</header>



	<div class="BoFangcontent">
		<!--内容区-->
		<div class="BoFangcontent-box">
			<c:forEach items="${result.dataList }" var="video">
				<div class="BiaoTi">${video.video_name }</div>
				<div class="inbox">
					

						<iframe height="550px" width="100%" src='${video.video_address }'
							frameborder=0'allowfullscreen'></iframe>

					
				</div>
			</c:forEach>
		</div>
		<div class="PingLun">
			<input class="PLbutton" type="button" value="评论" />
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