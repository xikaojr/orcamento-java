<%@page import="team.java.domain.Rubrica"%>
<%@page import="java.util.*"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
		$("li.rubrica").addClass('active');
	});
</script>

<title>JBudget</title>

</head>

<body>

	<div class="container">
		<c:import url="/navbar.html"></c:import>
		<div>
			<h1>
				Rubricas <a class="btn btn-primary" href="cadastrar.jsp"> <i
					class="fa fa-plus-square"></i>
				</a>
			</h1>
		</div>

		<%
			if (request.getAttribute("message") != null) {
		%>
		<div class="col-md-12">
			<div class="alert alert-${tipoAlerta}">${message}</div>
		</div>
		<div class="clear"></div>
		<%
			}
		%>

		<form method="POST" action="index" role="form">
			<fieldset>
				<legend>Busca</legend>
				<div class="col-md-5 form-group"">
					<label for="term">Nome</label> <input type="text"
						class="form-control" id="nome" name="nome" value=""
						placeholder="Digite um nome para buscar">
				</div>
				<div class="col-md-3">
					<input type="submit" name="Search" class="btn btn-primary"
						style="margin-top: 25px;" />
				</div>
			</fieldset>
		</form>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Tipo</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="rubrica" items="${rubricasCadastradas}">
					<tr>
						<td>${rubrica.nome}</td>
						<td>${rubrica.tipo}</td>
						<td><a href="editar.jsp?rubrica=${rubrica.id}"
							style="cursor: pointer;"> <i class="fa fa-edit black"
								title="Editar"></i>
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


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
