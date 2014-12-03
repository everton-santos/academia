<%@page import="modelos.MedidaAvaliacao"%>
<%@page import="modelos.Ficha"%>
<%@page import="modelos.Medicao"%>
<%@page import="modelos.Exercicio"%>
<%@page import="modelos.Aluno"%>
<%@page import="modelos.Modalidade"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Projeto academia</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/justified-nav.js"></script>
</head>
<body>
	<div class="container">
		<!-- menu principal -->
		<div class="masthead">
			<h3 class="text-muted">Projeto Academia</h3>
			<div role="navigation">
				<ul class="nav nav-justified">
					<li><a class="dropdown-toggle" data-toggle="dropdown" href="#"
						role="button" aria-expanded="false"> Avaliaçoes <span
							class="caret"></span>
					</a>
						<ul class="dropdown-menu nav-justified" role="menu">
							<li><a href="AvaliacoesListarInstrutor"> Listar </a></li>
							<li><a href="AvaliacoesInserirInstrutor"> Inserir </a></li>
						</ul></li>
						
					<li><a class="dropdown-toggle" data-toggle="dropdown" href="#"
						role="button" aria-expanded="false"> Fichas <span
							class="caret"></span>
					</a>
						<ul class="dropdown-menu nav-justified" role="menu">
							<li><a href="FichasListarInstrutor"> Listar </a></li>
							<li><a href="FichasInserirInstrutor"> Inserir </a></li>
						</ul></li>
					</li>
				</ul>
			</div>
		</div>
		<!-- menu principal -->


		<div class="content">
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<h3>Listar fichas</h3>


					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									
									<th>nome</th>
									<th>medida</th>
									<th>valor</th>
								</tr>
							</thead>
							<tbody>
								<%
									List<MedidaAvaliacao> listaAlunos = (List<MedidaAvaliacao>) request
											.getAttribute("lista");

									for (MedidaAvaliacao aluno : listaAlunos) {
								%>
								<tr>
									<td><%=aluno.getAvaliacao().getAluno().getNome()%></td>
									<td><%=aluno.getMedicao().getDescricao()%></td>
									<td><%=aluno.getValor()%></td>
									
									<%-- <td><a href="FichaEditarInstrutor?id=<%=aluno.getId()%>"
										class="btn btn-primary"><span
											class="glyphicon glyphicon-pencil"></span></a> <a
										href="FichaExcluirInstrutor?id=<%=aluno.getId()%>"
										class="btn btn-danger"><span
											class="glyphicon glyphicon-remove"></span></a></td> --%>
								</tr>
								<%
									}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>