<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="curso/adiciona">
		nome: <input type="text" name="nome" /><br /><br />
		nome abreviado: <input type="text" name="nome"/><br /><br />
		link: <input type="text" name="link" /><br /><br /> 
		linguagem: <input type="text" name="linguagem" /><br /><br />
		descricao: <textarea rows="5" cols="50" name="descricao">aaa</textarea><br /><br />
		<input type="submit" value="cadastrar" />
	</form>
</body>
</html>