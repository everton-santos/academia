<%@page import="modelos.Instrutor"%>
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
						role="button" aria-expanded="false"> Alunos <span
							class="caret"></span>
					</a>
						<ul class="dropdown-menu nav-justified" role="menu">
							<li><a href="alunos-listar"> Listar </a></li>
							<li><a href="alunos-inserir"> Inserir </a></li>
						</ul></li>
					<li><a class="dropdown-toggle" data-toggle="dropdown" href="#"
						role="button" aria-expanded="false"> Instrutores <span
							class="caret"></span>
					</a>
						<ul class="dropdown-menu nav-justified" role="menu">
							<li><a href="instrutores-listar"> Listar </a></li>
							<li><a href="instrutores-inserir"> Inserir </a></li>
						</ul></li>
					<li><a class="dropdown-toggle" data-toggle="dropdown" href="#"
						role="button" aria-expanded="false"> Modalidades <span
							class="caret"></span>
					</a>
						<ul class="dropdown-menu nav-justified" role="menu">
							<li><a href="modalidades-listar"> Listar </a></li>
							<li><a href="modalidades-inserir"> Inserir </a></li>
						</ul></li>
					<li><a class="dropdown-toggle" data-toggle="dropdown" href="#"
						role="button" aria-expanded="false"> Exercicios <span
							class="caret"></span>
					</a>
						<ul class="dropdown-menu nav-justified" role="menu">
							<li><a href="exercicios-listar"> Listar </a></li>
							<li><a href="exercicios-inserir"> Inserir </a></li>
						</ul></li>
					<li><a class="dropdown-toggle" data-toggle="dropdown" href="#"
						role="button" aria-expanded="false"> Medidas <span
							class="caret"></span>
					</a>
						<ul class="dropdown-menu nav-justified" role="menu">
							<li><a href="medidas-listar"> Listar </a></li>
							<li><a href="medidas-inserir"> Inserir </a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<!-- menu principal -->


		<div class="content">
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<h3>Listar instrutores</h3>

					<form action="instrutores-listar">
						Nome:<input type="text" name="nome" /> <input type="submit" value="Pesquisar" />
					</form>
					
					<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>nome</th>
							<th>cpf</th>
							<th>telefone</th>
							<th>celular</th>
							<th>email</th>
							<th>acoes</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<Instrutor> listaAlunos = (List<Instrutor>) request.getAttribute("lista");

							for (Instrutor aluno : listaAlunos) {
						%>



						<tr>
							<td><%=aluno.getId()%></td>
							<td><%=aluno.getNome()%></td>
							<td><%=aluno.getCpf() %></td>
							<td><%=aluno.getTelefoneFixo()%></td>
							<td><%=aluno.getCelular()%></td>
							<td><%=aluno.getEmail()%></td>
							<td>
							<a href="IntrutoresEditar?id=<%=aluno.getId()%>" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a>
							<a href="InstrutoresExcluir?id=<%=aluno.getId()%>" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span></a>
							</td>
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