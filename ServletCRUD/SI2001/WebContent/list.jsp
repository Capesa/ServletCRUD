<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Title</h1>

	<table id="MiaTable" border="2">
		<th>Nome</th>
		<th>Cognome</th>
		<tbody>
			<c:forEach items="${users}" var="users">
				<tr class="header">
					<td>${users.firstname}</td>
					<td>${users.lastname}</td>
					<td>${users.id}</td>
					<td>${users.maritalStatus.status}</td>
					<td><c:forEach items="${users.skills}" var="skills">
       		 				 ${skills.skill}
         				</c:forEach>
					<td>
					<td><a href="ModificaUtente.do?id=${users.id}" title="">Edit</a></td>
					<td><a href="CancellaUtente.do?id=${users.id}" title="">Delete</a></td>

				</tr>
			</c:forEach>

		</tbody>
	</table>
	<br>

	<form method="post" action="SearchString.do">
		Ricerca <input type="text" name="serchString"> <input
			type="submit" value="cerca" />
	</form>


	<a href="CreateUser.do">add</a>







</body>
</html>