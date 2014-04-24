<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../css/Bootstrap.min.css" rel="stylesheet">
<title>Cadastro de Funcionário</title>
</head>
<body>
	<div class="container bs-docs-container">
		<div class="row" role="main">
			<div class="col-md-12">
				<h1 id="overview" class="page-header">Cadastro de Funcionário</h1>
			</div>

			<%
				if (request.getAttribute("errorMessage") != null) {
			%>
			<div class="col-md-12">
				<div class="alert alert-danger">${errorMessage}</div>
			</div>
			<%
				}
			%>

			<form role="form" name="cadastrar" method="POST" action="cadastrar">
				<div class="col-md-12">
					<div class="form-group col-md-4">
						<label for="nome">Nome</label> <input type="text"
							class="form-control" id="nome" name="nome"
							value="${funcionario.nome}" placeholder="Entre com seu nome">
					</div>
					<div class="form-group col-md-4">
						<label for="login">Login</label> <input type="text"
							class="form-control" id="login" name="login"
							value="${funcionario.login}" placeholder="Login">
					</div>
					<div class="form-group col-md-4">
						<label for="password">Password</label> <input type="password"
							class="form-control" id="password" name="password"
							value="${funcionario.senha}" placeholder="Password">
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-groud col-md-6">
						<button type="submit" class="btn btn-default">Enviar</button>
						<button type="reset" class="btn btn-danger">Limpar</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>