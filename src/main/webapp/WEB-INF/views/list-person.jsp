<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath }/persons/person-form">add
		new person</a>
	<table>
		<tr>
			<th>name</th>
			<th>email</th>

		</tr>
		<c:forEach var="person" items="${persons }">
			<c:url var="updateURL" value="update">
				<c:param name="id" value="${person.id }"></c:param>
			</c:url>
			<c:url var="deleteURL" value="delete">
				<c:param name="id" value="${person.id }"></c:param>
			</c:url>
			<c:url var="viewCreditCards" value="/credit-cards/">
				<c:param name="id" value="${person.id }"></c:param>
			</c:url>
			<tr>
				<td>${person.name }</td>
				<td>${person.email }</td>
				<td><a href="${updateURL }">update</a></td>
				<td><a href="${deleteURL }">delete</a></td>
				<td> <a href="${viewCreditCards }">view Credit Cards</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>