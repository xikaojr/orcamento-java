<%@page import="team.java.domain.Departamento"%>
<%@page import="team.java.domain.Funcionario"%>
<%@page import="java.util.*"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<c:import url="/imports.jsp" />

<script type="text/javascript">
	$(document).ready(function() {
		$("li.departamento").addClass('active');
	});
</script>

<title>JBudget</title>

</head>

<body>

	<div class="container">
		<c:import url="/navbar.html"></c:import>
		<div>
			<h1>
				Departamentos <a class="btn btn-primary" href="cadastrar.jsp"> <i
					class="fa fa-plus-square"></i>
				</a>
			</h1>
		</div>
		<div class="jumbotron">
			<form method="POST" action="index">
				Buscar por nome: <input type="text" name="nome" /> <input
					type="submit" name="Search" /> <br />
			</form>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Chefe</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<jsp:useBean id="dao" class="team.java.dao.DepartamentoDAO" />
				<c:forEach var="depto" items="${dao.getAll()}">
					<tr>
						<td>${depto.nome}</td>
						<td>${depto.chefeNome}</td>
						<td><a href="editar.jsp?departamento=${depto.id}" style="cursor: pointer;"> <i
								class="fa fa-edit black" title="Editar"></i>
						</a> &nbsp; <a href="#" style="cursor: pointer;"> <i
								class="fa fa-sitemap" title="Alocar um chefe"></i>
						</a> &nbsp; <a href="#" style="cursor: pointer;"> <i
								class="fa fa-trash-o red" title="Deletar"></i>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>
