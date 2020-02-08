<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>搜索列表</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/common.css" />
		<link rel="stylesheet" href="css/index.css" />
</head>
<body class="main">
	<jsp:include page="head.jsp" />
	<br/>
	<div class="main w">
			<table class="table table-condensed table-bordered">
				<thead>
					<tr>
						<td>新闻标题</td>
						<td>新闻作者</td>
						<td>新闻类型</td>
						<td>发布时间</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bean.pn}" var="p" varStatus="vs">
								<tr>
									<td>
										<a href="${pageContext.request.contextPath}/findNewsById?id=${p.id}">
									 		${p.title}
										</a>
									</td>
									<td>${p.category}</td>
									<td>${p.author}</td>
									<td>${p.time}</td>
								</tr>
								</c:forEach>
				</tbody>
			</table>
			<ul class="pagination">
			<c:if test="${bean.currentPage!=1}">
								<li>
									<a href="${pageContext.request.contextPath}/SearchSerlvet?currentPage=${bean.currentPage-1}&category">&laquo;</a>
								</li>
							</c:if>
							<c:if test="${bean.currentPage==1}">
								<li>&laquo;</li>
							</c:if>
							<c:forEach begin="1" end="${bean.totalPage}" var="pageNum">
									<c:if test="${pageNum==bean.currentPage}">
										<li>${pageNum }</li>
									</c:if>
									<c:if test="${pageNum!=bean.currentPage}">
										<li>
										<a href="${pageContext.request.contextPath}/SearchSerlvet?currentPage=${pageNum}&textfield=${bean.searchfield}">${pageNum}</a>
									
										</li>
									</c:if>
							</c:forEach>
			<!-- 如果当前页不是最后一页，则显示下一页 -->
					<c:if test="${bean.currentPage==bean.totalPage||bean.totalPage==0}">
						<li >&raquo;</li>
					</c:if>
					<c:if test="${bean.currentPage!=bean.totalPage&&bean.totalPage!=0}">
						<li>	
							<a href="${pageContext.request.contextPath}/SearchSerlvet?currentPage=${bean.currentPage+1}&textfield=${bean.searchfield}">&raquo;</a>
						</li>
					</c:if>
			</ul>
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
