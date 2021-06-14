<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="styleCadastro.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="content">
		<div id="cadastro">

			<div class="contentImagens">
				<img id="logoCadastro"
					src="https://lh3.google.com/u/0/d/1QJFXgiLb_LORenl992ERwIMriiF9w8s3=w1226-h918-iv1">
			</div>

			<form method="post" action="FrontController">
				<h1 style="font-size:30px;">Ficha de cadastro</h1>

				<div class="contentImagens">
					<img id="medicine"
						src="https://lh3.google.com/u/0/d/1357h2arl2CNPdyZMdN0DE6jOvZod9Pc5=w1919-h918-iv1">
				</div>

				<p>
					<label>Nome do atendente</label> <input id="nome_cad" name="nome"
						required="required" type="text" placeholder="Nome" />
				</p>

				<p>
					<label>Idade</label> <input id="idade_cad" name="idade"
						required="required" type="number" placeholder="Idade" />
				</p>

				<p>
					<label>Matricula</label> <input id="matricula_cad" name="matricula"
						required="required" type="text" placeholder="Ex: 201214-86" />
				</p>

				<p>
					<label>Salario</label> <input type="number" placeholder="00.00"
						required name="salario" min="0" value="0" step="00.01"
						pattern="^\d+(?:\.\d{1,2})?$" />
				</p>

				<p>
					<input type="submit" value="Cadastrar" />
				</p>
				<input type="hidden" name="action" value="cadastrar_atendente" />
			</form>
		</div>
	</div>
</body>
</html>