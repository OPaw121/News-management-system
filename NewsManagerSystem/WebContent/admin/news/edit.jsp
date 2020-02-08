<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/common.css" />
		<link rel="stylesheet" href="css/index.css" />
		
	<script type="text/javascript">
		//设置类别的默认值
		function setNewsCategory(t) {
			var category = document.getElementById("category");
			var ops = category.options;
			for ( var i = 0; i < ops.length; i++) {
				if (ops[i].value == t) {
					ops[i].selected = true;
					return;
				}
			}
		};
	</script>
</HEAD>
<body onload="setNewsCategory('${p.category}')">
<%@include file="/admin/head.jsp"%>
<br/>
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/editNews" method="post">
		<input type="hidden" name="id" value="${p.id}" /> &nbsp;
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4" height="26">
					<strong>编辑新闻信息</strong>
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">新闻标题：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="title" class="bg" value="${p.title}" />
				</td>
				<td align="center" bgColor="#f5fafe" class="ta_01">新闻作者：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="author" class="bg" value="${p.author}" />
				</td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">新闻类型：</td>
				<td class="ta_01" bgColor="#ffffff">
					<input type="text" name="category" class="bg" value="${p.category}" />
				</td>
			</tr>
			<TR>
				<TD class="ta_01" align="center" bgColor="#f5fafe">新闻内容：</TD>
				<TD class="ta_01" bgColor="#ffffff" colSpan="3">
					<textarea name="content" cols="30" rows="3" style="WIDTH: 96%">${p.content}</textarea>
				</TD>
			</TR>
			
			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center" bgColor="#f5fafe" colSpan="4">
					<input type="submit" class="button_ok" value="确定"> 
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<input type="reset" value="重置" class="button_cancel" /> 
					<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> 
					<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>