<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.qimo.domain.User"%>
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
		<link rel="stylesheet" href="../css/bootstrap.min.css" />
		<link rel="stylesheet" href="../css/common.css" />
		<link rel="stylesheet" href="../css/index.css" />
		<header>
	<div class="headerBd w">
			<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="${pageContext.request.contextPath}">新闻管理系统</a>
					</div>
					
					<ul class="nav navbar-nav pull-right" id="nav">
						<li><a href="${pageContext.request.contextPath}">进入首页</a></li>
						<li><a href="${pageContext.request.contextPath}/listNews">新闻管理</a></li>
						<li><% 
				User user = (User) request.getSession().getAttribute("user");
				%>
				<a href="${pageContext.request.contextPath}/logout" onclick="javascript:return confirm_logout()">退出管理员登录</a>
					</li>
					</ul>
				</div>
			</nav>
	</div>
</header>
		
		
		
