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
		<tr><th>AccountNo</th><th>TransactionType</th><th>Balance</th></tr>
		<c:forEach var="tran" items="${list }">
			<tr><td><c:out value="${tran.getAccountno() }"></c:out></td>
				<td><c:out value="${tran.getTransactiontype() }"></c:out></td>
				<td><c:out value="${tran.getBalance() }"></c:out></td>
			</tr>
		</c:forEach>
		</table>
</body>
</html>