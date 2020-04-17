<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Admin</h2>
<p><b>Número de usuarios activos: </b>${fn:length(users)}</p>
<h2>Usuarios</h2>
<table border="1">
<c:forEach items="${users}" var="useri">
<tr>
<td>${useri.name}</td>
<td>${useri.email}</td>
</tr>
</c:forEach>
</table>


<h2>Registrar un nuevo usuario</h2>
<%@ include file = "FormCreaProfesor.jsp" %>

<h2>Registrar una nueva asignatura</h2>
<%@ include file = "FormCreaSubject.jsp" %>

<h2>Registrar un nueva clase</h2>
<%@ include file = "FormCreaClass.jsp" %>

<h2>Buscar Clase</h2>
<%@ include file = "FormSubjectSearch.jsp" %>

<h2>Salir de la aplicación</h2>
<%@ include file = "FormLogout.jsp" %>
</body>
</html>