<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<title>carreiras</title>
		
		<!-- Bootstrap CSS -->
    	<link rel="stylesheet" href="../resources/bootstrap/bootstrap.min.css"></link>
    	<link rel="stylesheet" href="../resources/css/duvidas.css"></link>
	</head>
	
	<body>
	
		<div>
		
			<div class="adicionaCarreira container">
				<div><h4>cadastro carreira</h4></div>
				<form:form servletRelativeAction="adicionaCarreira" method="post" commandName="carreira">
					<div class="form-group">
						<label for="inputNome">nome</label>
						<form:input class="form-control" type="text" path="nome" id="inputNome" placeholder="nome"/>
					</div>
					<div class="form-group">
						<label for="inputNomeAbreviado">nome abreviado</label>
						<form:input class="form-control" type="text" path="nomeAbreviado" id="inputNomeAbreviado" placeholder="nome"/>
					</div>
					<div class="form-group">
						<label for="inputLink">link</label>
						<form:input class="form-control" type="text" path="link" id="inputLink" placeholder="link"/>
					</div>
						<div>
						<label for="inputTipo">tipo</label>
						<form:select path="tipo" id="inputTipo" name="tipo" class="form-control">
							<form:option value="0" label="---select---"/>
							<form:options items="${tipos}" itemValue="value" itemLabel="nome" />
						</form:select>
					</div><br/>
						<div>
						<label for="inputFerramenta">ferramentas</label>
						<form:select path="ferramentas" id="inputFerramenta" name="ferramentas" class="form-control">
							<form:option value="0" label="---select---"/>
							<form:options items="${ferramentas}" itemValue="id" itemLabel="nome" />
						</form:select>
					</div><br/>
					<div>
						<label for="inputCurso">cursos</label>
						<form:select path="cursos" id="inputCurso" name="cursos" class="form-control">
							<form:option value="0" label="---select---"/>
							<form:options items="${cursos}" itemValue="id" itemLabel="nome" />
						</form:select>
					</div><br/>
					<div>
						<label for="inputLinguagem">descrição:</label>
						<form:textarea class="form-control" rows="3" col="50" path="descricao"></form:textarea>
					</div><br />
					<button type="submit" class="btn  btn-primary">cadastrar</button>
				</form:form>
			</div>
			
			<div class="listaCarreira container">
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>nome</th>
							<th>nome abreviado</th>
							<th>link</th>
							<th>tipo</th>
							<th>ferramentas</th>
							<th>cursos</th>
							<th>descricao</th>
						</tr>	
					</thead>
					<tbody>
					<c:forEach var="carreira" items="${carreiras}">
						<tr>
							<td>${carreira.id}</td>
							<td>${carreira.nome}</td>
							<td>${carreira.nomeAbreviado}</td>
							<td>${carreira.link}</td>
							<td>${carreira.tipo}</td>
							<td>${carreira.ferramentas}</td>
							<td>${carreira.cursos}</td>
							<td>${carreira.descricao}</td>
							<td><a href="removeCarreira?id=${carreira.id}">remover</a></td>
							<td><a href="mostraCarreira?id=${carreira.id}">mostrar</a></td>
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