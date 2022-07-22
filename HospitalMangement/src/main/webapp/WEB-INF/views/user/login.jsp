<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>Welcome to Hospital Management System @ ${requestScope.ts}</h5>
<h5 style="color: red;">${requestScope.mesg}</h5>
<spring:url var="url" value="/user/login" />
	<form action="${url}"  method="post">
	<!--  When action is missing  same URl sends-->
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>User Name</td>
				<td><input type="text" name="name" required /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pass" required /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" /></td>
				<td><button><a href="<spring:url value='/user/register'/>">Register</a></button></td>
			</tr>
			
			
		</table>
	</form>
	
</body>
</html>