<%@page import="modelos.Instrutor"%>
<%@page import="modelos.Aluno"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Instrutor a = (Instrutor) request.getAttribute("aluno");
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
				<div class="col-md-4 col-md-offset-4">

					<form class="form-horizontal" action="IntrutoresEditar" method="post">
						<fieldset>
							<input type="hidden" name="ida" value="<%= a.getId() %>" /> <input type="hidden"
								name="idu" value="<%= a.getUsuario().getId() %>" />
							<!-- Form Name -->
							<legend>Cadastro/Edição</legend>

							<!-- Text input-->
							<div class="control-group">
								<label class="control-label" for="login">login</label>
								<div class="controls">
									<input id="login" name="login" type="text" placeholder=""
										class="input-xlarge" value="<%= a.getUsuario().getLogin() %>">

								</div>
							</div>

							<!-- Password input-->
							<div class="control-group">
								<label class="control-label" for="senha">senha</label>
								<div class="controls">
									<input id="senha" name="senha" type="password" value="<%= a.getUsuario().getSenha() %>" placeholder=""
										class="input-xlarge">

								</div>
							</div>

							<!-- Text input-->
							<div class="control-group">
								<label class="control-label" for="nome">nome</label>
								<div class="controls">
									<input id="nome" name="nome" type="text" value="<%= a.getNome() %>" placeholder=""
										class="input-xlarge">

								</div>
							</div>

							<!-- Text input-->
							<div class="control-group">
								<label class="control-label" for="cpf">cpf</label>
								<div class="controls">
									<input id="cpf" name="cpf" type="text" value="<%= a.getCpf() %>" placeholder=""
										class="input-xlarge">

								</div>
							</div>

							<!-- Text input-->
							<div class="control-group">
								<label class="control-label" for="telefone">telefone</label>
								<div class="controls">
									<input id="telefone" name="telefone" value="<%= a.getTelefoneFixo() %>" type="text" placeholder=""
										class="input-xlarge">

								</div>
							</div>

							<!-- Text input-->
							<div class="control-group">
								<label class="control-label" for="celular">celular</label>
								<div class="controls">
									<input id="celular" name="celular" value="<%= a.getCelular() %>" type="text" placeholder=""
										class="input-xlarge">

								</div>
							</div>

							<!-- Text input-->
							<div class="control-group">
								<label class="control-label" for="datanasc">data
									nascimento</label>
								<div class="controls">
									<input id="datanasc" name="datanasc" type="text"
										placeholder="dd/mm/yyyy" value="<%= a.getDataNascimento() %>" class="input-xlarge">

								</div>
							</div>

							<!-- Text input-->
							<div class="control-group">
								<label class="control-label" for="email">email</label>
								<div class="controls">
									<input id="email" name="email" value="<%= a.getEmail() %>" type="text" placeholder=""
										class="input-xlarge">

								</div>
							</div>

							<!-- Text input-->
							<div class="control-group">
								<label class="control-label" for="rua">rua</label>
								<div class="controls">
									<input id="rua" name="rua" type="text" value="<%= a.getEndereco().getRua() %>" placeholder=""
										class="input-xlarge">

								</div>
							</div>

							<!-- Text input-->
							<div class="control-group">
								<label class="control-label" for="numero">numero</label>
								<div class="controls">
									<input id="numero" name="numero" type="text" value="<%= a.getEndereco().getNumero() %>"  placeholder=""
										class="input-xlarge" value="0">

								</div>
							</div>

							<!-- Text input-->
							<div class="control-group">
								<label class="control-label" for="complemento">complemento</label>
								<div class="controls">
									<input id="complemento" name="complemento" value="<%= a.getEndereco().getComplemento() %>"  type="text"
										placeholder="" class="input-xlarge">

								</div>
							</div>

							<!-- Text input-->
							<div class="control-group">
								<label class="control-label" for="bairro">bairro</label>
								<div class="controls">
									<input id="bairro" name="bairro" type="text" value="<%= a.getEndereco().getBairro() %>"  placeholder=""
										class="input-xlarge">

								</div>
							</div>

							<!-- Text input-->
							<div class="control-group">
								<label class="control-label" for="cep">cep</label>
								<div class="controls">
									<input id="cep" name="cep" type="text" value="<%= a.getEndereco().getCep() %>"  placeholder=""
										class="input-xlarge">

								</div>
							</div>

							<!-- Button -->
							<div class="control-group">
								<label class="control-label" for="enviar"></label>
								<div class="controls">
									<a id="voltar" name="voltar" class="btn btn-danger"
										href="alunos-listar">voltar</a>
									<button id="enviar" name="enviar" class="btn btn-primary">enviar</button>
								</div>
							</div>

						</fieldset>
					</form>
				</div>
			</div>
		</div>


	</div>
</body>
</html>