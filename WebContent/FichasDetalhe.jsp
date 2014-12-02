<%@page import="modelos.Ficha"%>
<%@page import="modelos.FichaExercicio"%>
<%@page import="modelos.Medicao"%>
<%@page import="modelos.Exercicio"%>
<%@page import="modelos.Aluno"%>
<%@page import="modelos.Modalidade"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<% Ficha ficha = (Ficha) request.getAttribute("ficha"); %>
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
					<li><a href="AvaliacoesListar" role="button" aria-expanded="false">
							Minhas Avaliações
					</a>
					</li>
					<li><a href="FichasListar" role="button" aria-expanded="false">
							Minhas Fichas
					</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- menu principal -->


		<div class="content">
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<h3>Ficha detalhe</h3>

					
						Nome: <%= ficha.getAlunoModalidade().getAluno().getNome()  %>

					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Exercicio</th>
									<th>Num Series</th>
									<th>Qtd repeticoes</th>
								</tr>
							</thead>
							<tbody>
								<%

									for (FichaExercicio aluno : ficha.getFichaExercicios()) {
								%>



								<tr>
									<td><%=aluno.getExercicio().getNome()%></td>
									<td><%=aluno.getQtdSeries()%></td>
									<td><%=aluno.getQtdRepeticoes()%></td>
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