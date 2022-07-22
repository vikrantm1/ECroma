<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<h1>Hello ${requestScope.user.name}
			</h1>
			<p>Select Operation to perform </p>
			<a href="ready_food">Buy Ready To Eat Food</a><BR>
			<a href="vegetables">Buy Vegetables</a><BR>
			
			<a href="grocery">Buy Grocery</a><BR>
			
			
			
			



</body>
</html>