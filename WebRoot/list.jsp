<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>浏览视频</title>
</head>
<%
	// 获取请求的上下文
	String context = request.getContextPath();
%>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="css/reset.css" />
<link href="css/pagination.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<script type="text/javascript">

// 点击分页按钮以后触发的动作
function handlePaginationClick(new_page_index, pagination_container) {
    $("#stuForm").attr("action", "<%=context%>/ListServlet.do?pageNum="+ (new_page_index + 1));
		$("#stuForm").submit();
		return false;
	}

	$(function() {
		$("#News-Pagination").pagination(${result.totalRecord}, {
			items_per_page : ${result.pageSize}, // 每页显示多少条记录
			current_page : ${result.currentPage} - 1, // 当前显示第几页数据
			num_display_entries : 8, // 分页显示的条目数
			next_text : "下一页",
			prev_text : "上一页",
			num_edge_entries : 2, // 连接分页主体，显示的条目数
			callback : handlePaginationClick
		});

		// 设置学生默认性别
		//$("#gender").val("${gender}");
	});
</script>
<body>


<header>  <!--头部-->
			<div class="page-container" id="nav">
				 <div id="logo" class="logo">
				 	 <a href="index.html" target="_self" title="首页">
				 	 	<img title="趣盒" src="img/logo.png"  />
				 	 </a>
				 </div>
				 <div class="login-area">
				 	<ul class="header-unlogin clearfix">
				 		<li class="header-signin">
				 			<a href="me.html"  target="_self">我的信息</a> 
				 			<a href="index2.html"  target="_self">首页</a> 
				 		</li>
				 	</ul>
				 </div>
			</div>
		</header> 
		
		<div style="margin-left: 100px; margin-top: 10px;">
		<div>
			<font color="red">${errorMsg }</font>
		</div>
		<div>
			<form action="<%=context%>/ListServlet.do" id="stuForm"
				method="post">
				视频名称 <input type="text" name="video_name" id="stu_name"
					style="width:120px" value="${video_name }"> &nbsp;&nbsp;&nbsp; 
					<input type="submit" value="查询">
			</form>
		</div>
		<br> 视频列表：<br> <br>
		<!-- 后台返回结果为空 -->
		<c:if test="${fn:length(result.dataList) eq 0 }">
			<span>查询的结果不存在</span>
		</c:if>

		<!-- 后台返回结果不为空 -->
		<c:if test="${fn:length(result.dataList) gt 0 }">
			<!--  
			<table border="1px" cellspacing="0px"
				style="border-collapse: collapse">
				<thead>
					<tr height="30">
						<th width="130">视频名称</th>
						<th width="200">视频播放地址</th>
						<th width="200">视频上传时间</th>
						<th width="200">视频审核状态</th>
					</tr>
				</thead>
				<c:forEach items="${result.dataList }" var="video">
					<tr>
						<td><c:out value="${video.video_name }"></c:out></td>
						<td><a href='<c:out value="${video.video_address }"></c:out>'>播放</a></td>
						<td><c:out value="${video.release_time }"></c:out></td>
						<td>
							<c:if test="${ video.check_status eq 1}">审核通过</c:if>
							<c:if test="${ video.check_status eq 2}">审核未通过</c:if>
						</td>
					</tr>

				</c:forEach>
			</table>
			
			-->

			<c:forEach items="${result.dataList }" var="video">
				<div>
					<div>
						<a href='/quhe/BoFangServlet.do?id=<c:out value="${video.video_id }"></c:out>'><c:out value="${video.video_name }"></c:out></a>
					</div>
					
					<hr>
				</div>

			</c:forEach>

			<br>
			<div>
				<br> 共${result.totalRecord }条记录共${result.totalPage }页&nbsp;&nbsp;当前第${result.currentPage }页&nbsp;&nbsp;
			</div>
			<br>
			<div id="News-Pagination"></div>

		</c:if>
	</div>
	

		
		









	
</body>
</html>