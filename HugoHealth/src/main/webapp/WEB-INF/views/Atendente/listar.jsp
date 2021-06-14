<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="ltda.corporation.hugo.health.entity.Atendente"
	import="java.util.List"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Hugo Health</title>
</head>
<body>


	<ul>
		<%
		List<Atendente> atendentes = (List<Atendente>) request.getAttribute("atendentes");
		for (Atendente atendente : atendentes) {
		%>
		<li><%=atendente.getNome()%></li>
		<%
		}
		%>
	</ul>


</body>
</html>