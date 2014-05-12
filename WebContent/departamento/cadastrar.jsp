<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:import url="/imports.jsp" />
<title>Cadastro de Departamento</title>

<script type="text/javascript">
	$(document).ready(function() {
		$("li.departamento").addClass('active');
	});
</script>

</head>
<body>
	<div class="container">
		<c:import url="/navbar.html"/>
		<div class="container bs-docs-container">
			<div class="row" role="main">
				<div class="col-md-12">
					<h1 id="overview" class="page-header">Cadastro de Departamento</h1>
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
					<input type="hidden" name="acao" value="create" id="acao" />
					<div class="col-md-12">
						<div class="form-group col-md-4">
							<label for="nome">Nome</label> <input type="text"
								class="form-control" id="nome" name="nome"
								value="${departamento.nome}"
								placeholder="Entre o nome do Departamento">
						</div>
						<div class="form-group col-md-8">
							<label for="chefe">Chefe do Departamento</label> <input type="text"
								class="form-control" id="chefe" name="chefe"
								value=""
								placeholder="Entre o nome do funcionario e aguarde a lista.">
						</div>
						<br />
					</div>
					<div class="col-md-12">
						<div class="form-group col-md-8">
							<label for="descricao">Descrição</label>
							<textarea rows="7" class="form-control" id="descricao" name="descricao"
								value="${departamento.descricao}"></textarea>
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

<script type="text/javascript">
$(document).ready(function() {
    $('#chefe').autocomplete({
        source: "/orcamento-java/funcionario/autocomplete",
        type: "post",
        dataType: "json",
        data: {
            'term': $('#chefe').val()
        },
        minLength: 2,
        label: 'label',
        value: 'value',
        open: function() {
           $('.ui-autocomplete').css('z-index', "1060 !important");
        },
        select: function(e, ui) {
        	$('#chefe').val(ui.item.value);
            $('#chefe_id').val(ui.item.func_id);
            return false;
        }
    }).blur(function() {
        if (!$('#chefe_id').val())
            return;
    });
});
</script>

</html>