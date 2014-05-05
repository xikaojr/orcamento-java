<%@page import="team.java.domain.Funcionario"%>
<%@page import="javax.swing.text.MaskFormatter"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@page import="team.java.domain.Departamento"%>
<%@page import="java.util.*"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../css/Bootstrap.min.css" rel="stylesheet">
<link href="../css/geral.css" rel="stylesheet">

<script src="validator.js"></script>

<!-- ATIVANDO JQUERY -->
<script src="../assets/jquery-2.0.2.js"></script>


<!-- CHOSEN 0.14-->
<link href="../assets/chosen-0.14.0/chosen.css" rel="stylesheet">
<script src="../assets/chosen-0.14.0/chosen.jquery.js"></script>

<!-- ATIVANDO O CHOSEN -->
<script type="text/javascript">
	$(document).ready(function() {
		$('.chzn-select').chosen({
			width : "100%",
			height : "100%"
		});
	});
</script>



<!-- fontawesome-4.0.3 core CSS -->
<link href="../assets/font-awesome-4.0.3/css/font-awesome.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../css/Navbar.css" rel="stylesheet">


<title>Cadastro de Funcionário</title>

<%

Funcionario funcionario = null;
if(request.getSession().getAttribute("funcionario") != null)
{
	funcionario = (Funcionario)request.getSession().getAttribute("funcionario");		
}else{
	response.sendRedirect("/orcamento-java/login.jsp");
}

%>

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
						<li class=""><a href="index">Funcionarios</a></li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
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

				<form role="form" name="editar" method="POST" action="cadastrar">
					<div class="col-md-12">
						<div class="form-group col-md-4">
							<label for="nome">Nome</label> <input type="text"
								class="form-control" id="nome" name="nome"
								value="<%=funcionario.getNome() %>" required autofocus
								placeholder="Entre com seu nome">
						</div>
						<div class="form-group col-md-4">
							<label for="login">Login</label> <input type="text"
								class="form-control" id="login" name="login"
								value="<%=funcionario.getLogin() %>" required placeholder="Login">
						</div>
						<div class="form-group col-md-4">
							<label for="password">Password</label> <input type="password"
								class="form-control" id="password" name="password"
								value="<%=funcionario.getSenha() %> %>" required placeholder="Password">
						</div>
					</div>

					<div class="col-md-12">
						<div class="form-group col-md-4">
							<label for="departamento_id">Departamento</label> <select
								class="chzn-select form-control" name="departamento_id"
								id="departamento_id">
								<%
									if (listDepartamento != null) {
										for (int i = 0; i < listDepartamento.size(); i++) {
								%>
								<option value="<%=listDepartamento.get(i).getId()%>">
									<%=listDepartamento.get(i).getNome()%>
								</option>
								<%
										}
									}
								%>
							</select>
						</div>
						<div class="form-group col-md-4">
							<label for="email">Email</label> <input class="form-control"
								type="text" name="email" id="email" value="<%=funcionario.getEmail() %>" />
						</div>
						<div class="form-group col-md-2">
							<label for="nascimento">Data de Nascimento</label> <input
								class="form-control"
								type="text" name="nascimento"
								onkeypress="MascaraData(cadastrar.nascimento);"
								id="nascimento"
								value="<%=funcionario.getDataNascimento() %>" />
						</div>
						<div class="form-group col-md-2">
							<label for="cpf">Cpf</label> <input class="form-control"
								type="text" name="cpf" id="cpf"
								onkeypress="MascaraCPF(cadastrar.cpf);"
								onblur="ValidarCPF(cadastrar.cpf)" 
								value="<%=funcionario.getCpf()%>"/>
						</div>
					</div>

					<div class="col-md-12">
						<div class="form-group col-md-8">
							<label for="endereco">Endereço</label> <input
								class="form-control" 
								type="text"
								value="<%=funcionario.getEndereco() %>" 
								name="endereco" 
								id="endereco" />
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