<%@page import="team.java.domain.Departamento"%>
<%@page import="team.java.domain.Funcionario"%>
<%@page import="java.util.*"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <meta charset="utf-8"> -->
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- <meta name="description" content=""> -->
<!-- <meta name="author" content=""> -->
<!-- <link rel="shortcut icon" href="../../assets/ico/favicon.ico"> -->

<title>JBudget</title>

<!-- Bootstrap core CSS -->
<link href="../css/Bootstrap.min.css" rel="stylesheet">
<link href="../css/geral.css" rel="stylesheet">

<!-- fontawesome-4.0.3 core CSS -->
<link href="../assets/font-awesome-4.0.3/css/font-awesome.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../css/Navbar.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy this line! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>


<%!ArrayList<Departamento> listDepartamento = null;%>
<%
	listDepartamento = (ArrayList<Departamento>) request
			.getAttribute("departamentos");
%>


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
						<li><a href="/orcamento-java/funcionario/index">Funcionarios</a></li>
						<li class="active"><a href="index">Departamentos</a></li>
						<li><a href="/orcamento-java/rubrica/index">Rubricas</a></li>
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

		<!-- Main component for a primary marketing message or call to action -->
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
		<%
			if (listDepartamento != null) {
		%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Chefe</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (int i = 0; i < listDepartamento.size(); i++) {
				%>
				<tr>
					<td><%=listDepartamento.get(i).getNome()%></td>
					<td><%=listDepartamento.get(i).getChefeNome()%></td>
					<td><a href="#" style="cursor: pointer;"> <i
							class="fa fa-edit black" title="Editar"></i>
					</a> &nbsp; <a href="#" style="cursor: pointer;"> <i
							class="fa fa-sitemap" title="Alocar um chefe"></i>
					</a> &nbsp; <a href="#" style="cursor: pointer;"> <i
							class="fa fa-trash-o red" title="Deletar"></i>
					</a></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<%
			}
		%>
	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
