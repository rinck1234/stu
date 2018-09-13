<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生列表页面</title>

<script type="text/javascript">
	function doDelete(id){
		var flag = confirm("是否确定删除？");
		if(flag){
			window.location.href="StudentDeleteServlet?id="+id;
		}
	}
	function doPageChange(cur){
		var  Sel=document.getElementById("listPerPage");
		var index=Sel.selectedIndex ;             // selectedIndex是所选中的项的index
		 var text=Sel.options[index].value;
		window.location.href="StudentPageListServlet?currentpage="+cur+"&listperpage="+text;
	}
</script>

</head>
<body>
<table border="1" width="700">
	<form action="StudentSearchServlet" method="post">
	<tr>
		<td colspan="8">
		按姓名查询：<input type="text" name="search_name">
		按性别查询：<select name="search_sex">
		<option value="">--请选择--
		<option value="男">男
		<option value="女">女
		</select>
		<input type="submit" value="查询">
			<a href="add.jsp">添加</a>
		</td>
	</tr>
	</form>
		<tr align="center">
			<td>编号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>电话</td>
			<td>生日</td>
			<td>爱好</td>
			<td>简介</td>
			<td>操作</td>
		</tr>
		
		<c:forEach items="${beanpage.list }" var="stu">
		<tr align="center">
			<td>${stu.id }</td>
			<td>${stu.name }</td>
			<td>${stu.sex }</td>
			<td>${stu.phone }</td>
			<td>${stu.birthday }</td>
			<td>${stu.hobby }</td>
			<td>${stu.info }</td>
			<td><a href="StudentEditServlet?id=${stu.id }">更新</a>	<a href="#" onclick="doDelete(${stu.id})">删除</a></td>
		</tr>
		</c:forEach>
		
		<tr>
			<td colspan="8">
				第${beanpage.currentpage }/${beanpage.totalpage }页&nbsp;&nbsp;
				每页显示${beanpage.listperpage }条&nbsp;&nbsp;
				总计${beanpage.totalList }条&nbsp;&nbsp;
				<c:if test="${beanpage.currentpage!=1 }">
				<a href="#" onclick="doPage(1)">[首页]</a>&nbsp;
				<a href="#" onclick="doPageChange(${beanpage.currentpage-1 })">上一页</a>
				</c:if>
				<c:forEach begin="1" end="${beanpage.totalpage }" var="i">
					<c:if test="${beanpage.currentpage==i }">${i }&nbsp;</c:if>
					<c:if test="${beanpage.currentpage!=i }"><a href="#" onclick="doPageChange(${i})">${i }</a>&nbsp;</c:if>
				</c:forEach>
				<c:if test="${beanpage.currentpage!=beanpage.totalpage }">
				<a href="#" onclick="doPageChange(${beanpage.currentpage+1 })">下一页</a>&nbsp;
				<a href="#" onclick="doPageChange(${beanpage.totalpage })"> [尾页]</a>
				</c:if>
				&nbsp;&nbsp;
				每页显示：<select id="listPerPage">
						<option value="10" <c:if test="${beanpage.listperpage }==10">selected</c:if>>10
						<option value="20" <c:if test="${beanpage.listperpage }==20">selected</c:if>>20
						<option value="30" <c:if test="${beanpage.listperpage }==30">selected</c:if>>30
						</select>
			</td>
	</table>
</body>
</html>