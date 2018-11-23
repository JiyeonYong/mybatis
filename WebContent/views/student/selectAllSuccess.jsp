<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table border="1">
	<tr>
		<th>No</th><th>Name</th><th>Tel</th><th>Email</th>
		<th>Address</th><th>RegDate</th>
	</tr>
	
		<c:forEach items="${list}" var="s">
		<tr>
			<td><c:out value="${s.studentNo}"/></td>
			<td><c:out value="${s.studentName}"/></td>
			<td><c:out value="${s.studentTel}"/></td>
			<td><c:out value="${s.studentEmail}"/></td>
			<td><c:out value="${s.studentAddr}"/></td>
			<td><c:out value="${s.regDate}"/></td>
		</tr>
	</c:forEach>
	
	
	

</table>





</body>
</html>






