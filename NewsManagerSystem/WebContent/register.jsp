<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/common.css" />
		<link rel="stylesheet" href="css/register.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/form.js"></script>
</head>
<body>


<%@include file="head.jsp"%> 

<div class="main">
			<div class="mainBd w">
				<form action="register" method="post" class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title text-center" id="myModalLabel">用户注册</h4>
						</div>
						<div class="modal-body" id="model-body">
							<div class="form-group">

								<input type="text" class="form-control" id="username" name="username" placeholder="用户名" onkeyup="checkUsername(); autocomplete="off">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" placeholder="密码" id="password" name="password" autocomplete="off">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" placeholder="确认密码" id="repassword" name="repassword" autocomplete="off">
							</div>
						</div>
						<div class="modal-footer">
							<div class="form-group">
								<button name="submit" type="submit" class="btn btn-primary form-control">注册</button>
							</div>
							<div class="form-group">
								<button type="reset" class="btn btn-default form-control">重置</button>
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