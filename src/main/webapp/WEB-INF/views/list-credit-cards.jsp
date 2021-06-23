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
	<c:url var="addCreditCardURL"
		value="${pageContext.request.contextPath }/credit-cards/credit-card-form">
		<c:param name="personId" value="${personId }"></c:param>
	</c:url>
	<a href="${addCreditCardURL }">add new Credit Card</a>
	<table>
		<tr>
			<th>type</th>
		</tr>
		<c:forEach var="creditCard" items="${creditCards }">
		
			<c:url var="deleteURL" value="delete">
				<c:param name="id" value="${creditCard.id }"></c:param>
			</c:url>
			
			<c:url var="updateURL" value="update">
				<c:param name="id" value="${creditCard.id }"></c:param>
				<c:param name="personId" value="${personId }"></c:param>
			</c:url>

			<tr>
				<td>${creditCard.type }</td>
				<td><a href="${updateURL }">update</a></td>
				<td><a href="${deleteURL }">delete</a></td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>