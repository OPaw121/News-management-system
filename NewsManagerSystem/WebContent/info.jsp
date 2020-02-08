<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>新闻详情</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/common.css" />
		<link rel="stylesheet" href="css/detail.css" />
</head>
<body class="main">
	<jsp:include page="head.jsp" />
	
	<div class="main">
			<div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="${pageContext.request.contextPath }/index.jsp">首页</a>
						&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath }/showNewsByPage?category">全部新闻</a>
						&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;${p.title}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</div>
					<br/>
			<div class="mainBd w">
				<h1>${p.title}</h1>
				<br/>
				<div class="content">
					<div class="sideBar">
					<div class="time">
						新闻类型:	${p.category}
						</div>
					<br/>
						<div class="time">
						 发布时间： 	${p.time}
						</div>
						<br/>
						<div class="author">
						 作者：	${p.author}
						</div>
					</div>
					<div class="inner">
						<p> ${p.content}</p>
					</div>
					
				</div>
			</div>
			<br/>
		</div>
	
	
	
	
	<footer>
			<div class="footerBd w">
				<div class="copyright">
					<ul>
						<li><a href="">关于我们</a></li>
						<li class="spacer"></li>
						<li><a href="">联系我们</a></li>
						<li class="spacer"></li>
						<li><a href="">联系客服</a></li>
					</ul>
					<ul>
						<li>Copyright © 2019 - 2020 新闻网版权所有</li>
						<li class="spacer"></li>
						<li>(京)新闻平台备字(2019)第00001号</li>
					</ul>
					<ul>
						<li>友情链接</li>
						<li class="spacer"></li>
						<li><a href="">腾讯新闻</a></li>
						<li class="spacer"></li>
						<li><a href="">网易新闻</a></li>
						<li class="spacer"></li>
						<li><a href="">新浪微博</a></li>
					</ul>
				</div>
			</div>
	</footer>
	<script src="js/bootstrap.min.js"></script>
	
</body>
</html>
