<%@page import="modelos.AlunoModalidade"%>
<%@page import="modelos.Aluno"%>
<%@page import="modelos.Modalidade"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Aluno a = (Aluno) request.getAttribute("aluno");
%>
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
					<h3>Matricular aluno</h3>

					<h5>Modalidades atualmente matriculadas</h5>
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>nome</th>
								</tr>
							</thead>
							<tbody>
								<%
									List<AlunoModalidade> listaAlunosModalidades = a
											.getAlunoModalidades();

									for (AlunoModalidade aluno : listaAlunosModalidades) {
								%>



								<tr>
									<td><%=aluno.getModalidade().getNome()%></td>
									<td><a
										href="AlunosModalidadesExcluir?id=<%=a.getId()%>&idM=<%=aluno.getId()%>"
										class="btn btn-danger"><span
											class="glyphicon glyphicon-remove"></span></a></td>
								</tr>


								<%
									}
								%>
							</tbody>
						</table>
					</div>

					<div class="row">
						<div class="col-md-12">
							<form action="AlunosModalidadesInsert" method="post">
								<input type="hidden" name="idAluno" value="<%=a.getId()%>" />
								<div class="control-group">
									<label class="control-label" for="login">login</label>
									<div class="controls">
										<select id="selectbasic" name="modalidade">
											<option value="">Selecione</option>
											<%
												List<Modalidade> lista = (List<Modalidade>) request
														.getAttribute("modalidades");

												for (Modalidade obj : lista) {
											%>
											<option value="<%=obj.getId()%>"><%=obj.getNome()%></option>

											<%
												}
											%>
										</select>

									</div>
									
								</div>
								<div class="control-group">
								<label class="control-label" for="enviar"></label>
								<div class="controls">
									<a id="voltar" name="voltar" class="btn btn-danger"
										href="alunos-listar">voltar</a>
									<button id="enviar" name="enviar" class="btn btn-primary">enviar</button>
								</div>
							</div>
							</form>
						</div>
					</div>


				</div>
			</div>
		</div>


	</div>
</body>
</html>