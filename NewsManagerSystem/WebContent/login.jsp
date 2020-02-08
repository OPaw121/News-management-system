<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" />
	<link rel="stylesheet" href="css/common.css" />
	<link rel="stylesheet" href="css/login.css" />
</head>
<body>
<%@include file="head.jsp"%>
<div id="divcontent">
	
<div class="main">
			<div class="mainBd w">
				<form class="modal-dialog" action="${pageContext.request.contextPath}/login" method="post">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title text-center" id="myModalLabel">用户登录</h4>
						</div>
						<div class="modal-body" id="model-body">
							<div class="form-group">
								<input name="username" type="text" class="form-control" placeholder="用户名" autocomplete="off">
							</div>
							<div class="form-group">
								<input name="password" type="password" class="form-control" placeholder="密码" autocomplete="off">
							</div>
						</div>
						<div class="modal-footer">
							<div class="form-group">
								<button name="submit" type="submit" type="button" class="btn btn-primary form-control">登录</button>
								
							</div>
						</div>
					</div>
				</form>
			</div>
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