<%@page import="team.java.domain.Funcionario"%>
<%@page import="javax.swing.text.MaskFormatter"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="team.java.domain.Departamento"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Funcionário</title>

<c:import url="/imports.jsp" />

<script type="text/javascript">
	$(document).ready(function() {
		$("li.funcionario").addClass('active');
	});
</script>

</head>

<%
	ArrayList<Departamento> listDepartamento = null;
	Funcionario funcionario = null;

	if (request.getAttribute("departamentos") != null) {
		listDepartamento = (ArrayList<Departamento>) request
				.getAttribute("departamentos");
	}

	if (request.getSession().getAttribute("funcionario") != null) {
		funcionario = (Funcionario) request.getSession().getAttribute(
				"funcionario");
	}
%>


<body>
	<div class="container">
		<c:import url="/navbar.html"></c:import>
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
								value="${funcionario.nome}" required autofocus
								placeholder="Entre com seu nome">
						</div>
						<div class="form-group col-md-4">
							<label for="login">Login</label> <input type="text"
								class="form-control" id="login" name="login"
								value="${funcionario.login}" required placeholder="Login">
						</div>
						<div class="form-group col-md-4">
							<label for="password">Password</label> <input type="password"
								class="form-control" id="password" name="password"
								value="${funcionario.senha}" required placeholder="Password">
						</div>
					</div>

					<div class="col-md-12">
						<div class="form-group col-md-4">
							<jsp:useBean id="Deptdao" class="team.java.dao.DepartamentoDAO" />
							<label for="departamento_id">Departamento</label> <select
								class="chzn-select form-control" name="departamento_id"
								id="departamento_id">
								<c:forEach var="dpto" items="${Deptdao.getAll()}">
									<option value="${dpto.id}">${dpto.nome}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group col-md-4">
							<label for="email">Email</label> <input class="form-control"
								type="text" value="${funcionario.email}" name="email" id="email" />
						</div>
						<div class="form-group col-md-2">
							<label for="nascimento">Data de Nascimento</label> <input
								class="form-control" maxlength="10"
								value="${funcionario.nascimento}" type="text" name="nascimento"
								onkeypress="MascaraData(cadastrar.nascimento);" id="nascimento" />
						</div>
						<div class="form-group col-md-2">
							<label for="cpf">Cpf</label> <input class="form-control"
								type="text" name="cpf" id="cpf" value="${funcionario.cpf}"
								maxlength="14" onkeypress="MascaraCPF(cadastrar.cpf);"
								onblur="ValidarCPF(cadastrar.cpf)" />
						</div>
					</div>

					<div class="col-md-12">
						<div class="form-group col-md-8">
							<label for="endereco">Endereço</label> <input
								class="form-control" value="${funcionario.endereco}" type="text"
								name="endereco" id="endereco" />
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
	</div>
</body>
</html>