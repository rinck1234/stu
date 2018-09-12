<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新学生</title>
</head>
<body>
<form method="post" action="StudentUpdateServlet">
<input type="hidden" name="id" value="${stu.id }">
<table border="1" width="600">
<tr>
<td>姓名</td>
<td><input type="text" name="name" value="${stu.name }"></td>
</tr>
<tr>
<td>性别</td>
<td><input type="radio" name="sex" value="男" 
	<c:if test="${stu.sex == '男' }" >checked</c:if>>男
<input type="radio" name="sex" value="女"
<c:if test="${stu.sex == '女' }">checked</c:if>>女
</td>
</tr>
<tr>
<td>电话</td>
<td><input type="text" name="phone" value="${stu.phone }"></td>
</tr>
<tr>
<td>生日</td>
<td><input type="text" name="birthday" value="${stu.birthday }"></td>
</tr>
<tr>
<td>爱好</td>
<td>

	<input type="checkbox" name="hobby" value="游泳"<c:if test="${fn:contains(stu.hobby,'游泳') }">checked</c:if>>游泳
	<input type="checkbox" name="hobby" value="篮球"<c:if test="${fn:contains(stu.hobby,'篮球') }">checked</c:if>>篮球
	<input type="checkbox" name="hobby" value="足球"<c:if test="${fn:contains(stu.hobby,'足球') }">checked</c:if>>足球
	<input type="checkbox" name="hobby" value="阅读"<c:if test="${fn:contains(stu.hobby,'阅读') }">checked</c:if>>阅读
</td>
</tr>
<tr>
<td>简介</td>
<td><textarea rows="3" cols="20" name="info">${stu.info }</textarea></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="更新"></td>
</tr>

</table>
</form>
</body>
</html>