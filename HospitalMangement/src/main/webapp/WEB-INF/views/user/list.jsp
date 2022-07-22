<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h5 style="color: red;">Welcome  ${requestScope.user.email} </h5>
<h5>List of Patients</h5>
<p>
</p>
<c:forEach var="p" items="${requestScope.patients}">
			<tr>
				<td>  &emsp; ${p.id} </td>
				<td>  &emsp; ${p.name} </td>
				<td>  &emsp; ${p.email} </td>
				<td>  &emsp; ${p.dob} </td>
				
			</tr><BR>
		</c:forEach>

<h5>  <a href="logout">Logout</a>  </h5>
	
</body>
</html>