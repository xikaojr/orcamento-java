<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page import="team.java.domain.Funcionario"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="css/Bootstrap.min.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<%
			if (request.getAttribute("errorMessage") != null) {
		%>
		<div class="col-md-12">
			<div class="alert alert-danger">${errorMessage}</div>
		</div>
		<%
			}
		%>

		<%
			Funcionario funcionario = new Funcionario();
			if (request.getAttribute("funcionario") != null) {
				funcionario = (Funcionario) request.getAttribute("funcionario");
			}
		%>

		<div style="clear: both"></div>
		<form class="form-signin well" role="form" action="login"
			method="POST">
			<h2 class="form-signin-heading">Log in</h2>
			<input type="text" name="login" class="form-control"
				placeholder="Login"
				value="<%=(funcionario.getLogin() != null ? funcionario.getLogin()
					: "")%>"
				required autofocus> <br /> <input type="password"
				name="senha" class="form-control" placeholder="Senha" required>
			<div style="clear: both;"></div>
			<div style="text-align: center;">
				<button class="btn btn-lg btn-primary" title="Entrar" type="submit">Sign
					in</button>
			</div>
		</form>
	</div>
</body>
</html>