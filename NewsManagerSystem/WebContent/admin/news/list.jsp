<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/common.css" />
		<link rel="stylesheet" href="css/index.css" />
	<script type="text/javascript">
	    //添加新闻
		function addNews() {
			window.location.href = "${pageContext.request.contextPath}/admin/news/add.jsp";
		}
		//删除新闻
		function p_del() {   
			var msg = "您确定要删除该条新闻吗？";   
			if (confirm(msg)==true){   
			return true;   
			}else{   
			return false;   
			}   
		}   
		
	</script>
	
</head>
<body>
<%@include file="/admin/head.jsp"%>
<hr/>
	<br />
	<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/findProductByManyCondition" method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>新 闻 信 息 列 表</strong>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="right">
						<button type="button" id="add" name="add" value="添加新闻" class="button_add" onclick="addNews()">
							添加新闻
						</button>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								
								<td align="center" width="18%">新闻标题</td>
								<td align="center" width="9%">新闻作者</td>
								<td align="center" width="9%">新闻类型</td>
								<td align="center" width="9%">发布时间</td>
								<td width="8%" align="center">编辑</td>
								<td width="8%" align="center">删除</td>
							</tr>
                            <!--  循环输出所有商品 -->
							<c:forEach items="${pn}" var="p">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">${p.title }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">${p.author }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${p.category }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${p.time }</td>
									<td align="center" style="HEIGHT: 22px" width="7%">
									    <a href="${pageContext.request.contextPath}/findNewsById?id=${p.id}&role=1">
											编辑 
										</a>
									</td>
									<td align="center" style="HEIGHT: 22px" width="7%">
										<a href="${pageContext.request.contextPath}/deleteNews?id=${p.id}" onclick="javascript:return p_del()">
												删除
										</a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
			</TBODY>
		</table>
	</form>
</body>
</HTML>