<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="login.do" method="post">
				username:<input name="username"><br/>
				password:<input type="password"  name="password"><br/>
				验证码：<input name=checkCode>
				<img id="img" alt=""  src="${pageContext.request.contextPath}/certificate.do">
				<input type="submit" ><br/>
		</form>
</body>
</html>