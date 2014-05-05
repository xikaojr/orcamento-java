<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../css/Bootstrap.min.css" rel="stylesheet">
<link href="../css/geral.css" rel="stylesheet">

<!-- fontawesome-4.0.3 core CSS -->
<link href="../assets/font-awesome-4.0.3/css/font-awesome.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../css/Navbar.css" rel="stylesheet">

<script src="../assets/jquery-2.0.2.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<!-- <script src="//code.jquery.com/jquery-1.10.2.js"></script> -->
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>


<title>Cadastro de Rubrica</title>
</head>
<body>
	<div class="container">
		<!-- Static navbar -->
		<div class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/orcamento-java/index.html">JBudget</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class=""><a href="/orcamento-java/funcionario/index">Funcionarios</a></li>
						<li class=""><a href="/orcamento-java/departamento/index">Departamentos</a></li>
						<li class="active"><a href="index">Rubricas</a></li>
						<!--               <li class="dropdown"> -->
						<!--                 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Cadastros <b class="caret"></b></a> -->
						<!--                 <ul class="dropdown-menu"> -->
						<!--                   <li><a href="#">Action</a></li> -->
						<!--                   <li><a href="#">Another action</a></li> -->
						<!--                   <li><a href="#">Something else here</a></li> -->
						<!--                   <li class="divider"></li> -->
						<!--                   <li class="dropdown-header">Nav header</li> -->
						<!--                   <li><a href="#">Separated link</a></li> -->
						<!--                   <li><a href="#">One more separated link</a></li> -->
						<!--                 </ul> -->
						<!--               </li> -->
					</ul>
					<!-- 					<ul class="nav navbar-nav navbar-right"> -->
					<!-- 						<li class="active"><a href="./">Default</a></li> -->
					<!-- 						<li><a href="../navbar-static-top/">Static top</a></li> -->
					<!-- 						<li><a href="../navbar-fixed-top/">Fixed top</a></li> -->
					<!-- 					</ul> -->
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</div>
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
								<option value="D">D</option>
								<option value="R">R</option>
								<option value="I">I</option>
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