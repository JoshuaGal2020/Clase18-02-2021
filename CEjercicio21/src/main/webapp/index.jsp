<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ControllerAcceso" method="post">
		<br>
		<label>USER</label> 
		<br>
		<input type="text" name="user" placeholder="Escribe tu usuario"> 
		<br>
		<label>PASS</label> 
		<br>
		<input type="text" name="pass" placeholder="Escribe tu pass">
		<br>
		<input type="submit">
	</form>
<%String saludo= "HOLA MUNDO DESDE JAVA"; %>
<h1 value= <%=saludo %>>h</h1>
</body>
</html>