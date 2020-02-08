<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.qimo.domain.User"%>
<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/common.css" />
		<link rel="stylesheet" href="css/index.css" />
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
		<div class="banner"></div>
	</div>
</header>
