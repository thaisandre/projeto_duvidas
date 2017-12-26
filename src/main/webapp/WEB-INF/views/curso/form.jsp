<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<title>lista</title>
		
		<!-- Bootstrap CSS -->
    	<link rel="stylesheet" href="../resources/bootstrap/bootstrap.min.css"></link>
    	<link rel="stylesheet" href="../resources/css/duvidas.css"></link>
	</head>
<body>
	<div>

		<div class="adicionaCurso container">
			<div><h4>cadastro curso</h4></div>
			<form action="adicionaCurso" method="post">
				<div class="form-group">
					<label for="inputNome">nome</label> <input class="form-control" type="text" name="nome"
						id="inputNome" placeholder="nome" />
				</div>
				<div class="form-group">
					<label for="inputNomeAbreviado">nome</label> <input class="form-control" type="text"
						name="nomeAbreviado" id="inputNomeAbreviado"
						placeholder="nome abreviado" />
				</div>
				<div class="form-group">
					<label for="inputLink">link</label> <input class="form-control" type="text" name="link"
						id="inputLink" placeholder="link" />
				</div>
				<div class="form-group">
					<label for="inputLinguagem">linguagem</label> <input class="form-control" type="text"
						name="linguagem" id="inputLinguagem" placeholder="linguagem" />
				</div>
				<div class="form-group">
					<label for="inputDescricao">descrição:</label>
					<textarea class="form-control" rows="3" col="50" name="descricao"></textarea>
				</div>
				<div class="form-group">
					<label for="inputCarreiras">carreiras</label> 
					<select multiple class="form-control" id="inputCarreiras">
						<c:forEach var="carreira" items="${carreiras}">
							<option value="${carreira.id}">${carreira.nome}</option>
						</c:forEach>
					</select>
				</div>
				<br/>
				<button type="submit" class="btn  btn-primary">cadastrar</button>
			</form>
		</div>

		<div class="listaCursos">
			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>nome</th>
						<th>nome abreviado</th>
						<th>link</th>
						<th>linguagem</th>
						<th>descricao</th>
						<th>carreiras</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="curso" items="${cursos}">
						<tr>
							<td>${curso.id}</td>
							<td>${curso.nome}</td>
							<td>${curso.nomeAbreviado}</td>
							<td>${curso.link}</td>
							<td>${curso.linguagem}</td>
							<td>${curso.descricao}</td>
							<td>${curso.carreira}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
		<!-- bootstrap -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</body>
</html>