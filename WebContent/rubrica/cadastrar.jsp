<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<c:import url="/imports.jsp" />

<script type="text/javascript">
	$(document).ready(function() {
		$("li.rubrica").addClass('active');
	});
</script>

<title>Cadastro de Rubrica</title>
</head>
<body>
	<div class="container">
		<c:import url="/navbar.html"></c:import>
		<div class="container bs-docs-container">
			<div class="row" role="main">
				<div class="col-md-12">
					<h1 id="overview" class="page-header">Cadastro de Rubrica</h1>
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
					<input type="hidden" name="chefe_id" id="chefe_id" />
					<div class="col-md-12">
						<div class="form-group col-md-10">
							<label for="nome">Nome</label> <input type="text"
								class="form-control" id="nome" name="nome"
								value="${rubrica.nome}"
								placeholder="Entre como o nome">
						</div>
						<div class="form-group col-md-2">
							<label for="tipo">Tipo de Rubrica</label> 
							<select name="tipo" class="chzn-select form-control">
								<option value="D">Despesa</option>
								<option value="R">Receita</option>
								<option value="I">Investimento</option>
							</select>
						</div>
						<br />
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