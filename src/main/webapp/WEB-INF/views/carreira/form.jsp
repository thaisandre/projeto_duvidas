<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<title>lista</title>
		
		<!-- Bootstrap CSS -->
    	<link rel="stylesheet" href="../resources/bootstrap/bootstrap.min.css"></link>
    	<link rel="stylesheet" href="../resources/css/carreira.css"></link>
	</head>
	
	<body>
	
		<div class="container">
		
			<div class="adicionaCarreira container">
				<form action="adiciona">
					<div class="form-group">
						<label for="inputNome">nome</label>
						<input type="text" name="nome" id="inputNome" placeholder="nome"/>
					</div>
					<div class="form-group">
						<label for="inputLink">link</label>
						<input type="text" name="link" id="inputLink" placeholder="link"/>
					</div>
					<div>
						<label for="inputLinguagem">linguagem</label>
						<input type="text" name="linguagem" id="inputLinguagem" placeholder="linguagem"/>
					</div>
					<div>
						<label for="inputLinguagem">descrição:</label>
						<textarea class="form-control" rows="3" col="50" name="descricao"></textarea>
					</div>
					<button type="submit" class="btn  btn-primary">cadastrar</button>
				</form>
			</div>
			
			<div class="listaCarreira container">
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>nome</th>
							<th>link</th>
							<th>linguagem</th>
							<th>descricao</th>
						</tr>	
					</thead>
					<tbody>
					<c:forEach var="carreira" items="${carreiras}">
						<tr>
							<td>${carreira.id}</td>
							<td>${carreira.nome}</td>
							<td>${carreira.link}</td>
							<td>${carreira.linguagem}</td>
							<td>${carreira.descricao}</td>
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