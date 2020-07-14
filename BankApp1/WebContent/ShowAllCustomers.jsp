<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
		<table>
		<tr><th>AccountNo</th><th>Name</th><th>Balance</th><th>Password</th></tr>
		<c:forEach var="tran" items="${list}">
			<tr><td><c:out value="${tran.getAccno()}"></c:out></td>
				<td><c:out value="${tran.getName()}"></c:out></td>
				<td><c:out value="${tran.getBalance()}"></c:out></td>
				<td><c:out value="${tran.getPassword()}"></c:out></td>
			</tr>
		</c:forEach>
		</table>
</body>






<%-- <body style="background-color:yellow"; align="center">
	${list}
</body> --%>
</html>