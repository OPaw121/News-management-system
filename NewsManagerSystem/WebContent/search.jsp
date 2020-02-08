<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.qimo.domain.User"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>搜索新闻</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/common.css" />
		<link rel="stylesheet" href="css/search.css" />
		<script type="text/javascript">
//退出确认框
function confirm_logout() {   
    var msg = "您确定要退出登录吗？";   
    if (confirm(msg)==true){   
    return true;   
    }else{   
    return false;   
    }   
} 
</script>
</head>
<body>
	<header>
	<div class="headerBd w">
			<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="${pageContext.request.contextPath}">新闻网</a>
					</div>
					<div class="user">
						<% 
							User user = (User) request.getSession().getAttribute("user");
							if(null == user){
						%>
						<ul>
							<li><a href="${pageContext.request.contextPath}/login.jsp">登录</a></li>
							<li class="spacer"></li>
							<li><a href="${pageContext.request.contextPath}/register.jsp">注册</a></li>
						</ul>
						<% 	
							}else{
						%>
						<ul>
							<li>欢迎您： ${user.username}&nbsp;&nbsp;&nbsp;</li>
							<li class="spacer"></li>
							<li><a href="${pageContext.request.contextPath}/logout" onclick="javascript:return confirm_logout()">用户退出</a></li>
						</ul>
						<% 	
						}
						%>
						</div>
					<ul class="nav navbar-nav pull-right" id="nav">
							<li><a href="${pageContext.request.contextPath}/showNewsByPage?category">所有新闻</a></li>
							<li><a href="${pageContext.request.contextPath}/search.jsp">搜索新闻</a></li>
							<li><a href="#">后台管理</a></li>
						</ul>
					</div>
				</nav>
				<br/><br/>
				<div class="main">
					<div class="mainBd w">
						<div class="search">
							<form action="${pageContext.request.contextPath}/SearchServlet" class="bs-example bs-example-form" role="form">
								<div class="input-group">
									<input name="textfield" placeholder="请输入新闻标题" type="text" class="form-control">
									<span class="input-group-btn">
										<button name="submit" class="btn btn-default" type="submit">
											搜索
										</button>
									</span>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</header>
<br/><br/>
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



</div>
</body>
</html>