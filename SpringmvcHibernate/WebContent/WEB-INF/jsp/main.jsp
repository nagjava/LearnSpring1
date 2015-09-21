<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
</head>
<body>
	username: ${user.username }
	<br>
	<div>
	<table style="
    border-spacing: 10px;
    border-collapse: separate;">
			<tr>
    		<td>username</td>
    		<td>userid</td>
    		<td>authority</td>
    		<td>delete</td>
		</tr>
		<c:forEach items="${list}" var="var">
			<tr>
				<td>${ var.username}</td>
				<td>${var.id}</td>
				<td>${var.authority }</td>
				<td><a href="${pageContext.request.contextPath }/delete.do?id=${var.id}&username=${ var.username}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>

</html>