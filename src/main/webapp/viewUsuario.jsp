<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Lista de Usuarios</title>
	</head>
	<body>
		<%@ page import="com.crudjspjava.dao.UsuarioDao, com.crudjspjava.bean.*, java.util.*" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<h1>Listagem dos Usuarios</h1>
		
		<%
		String pageid = request.getParameter("page");
		int id = Integer.parseInt(pageid);
		int total = 5;
		
		if(id==1){
			
		}else{
			id = id-1;
			id = id*total;
		}
		
		//Função para listar todos os Usuarios
		//List<Usuario> list = UsuarioDao.getAllUsuarios();
		
		//Função para listar os Usuarios com base em quantos cabem no total de uma tela
		List<Usuario> list = UsuarioDao.getRecords(id,total);
		request.setAttribute("list",list);
		%>
		<table border ="1">
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Senha</th>
				<th>Telefone</th>
				<th>DDD</th>
				<th>Numero</th>
				<th>Editar</th>
				<th>Excluir</th>
			</tr>
			<c:forEach items="${list}" var ="usuario">
				<tr>
					<td>${usuario.getNome()}</td>
					<td>${usuario.getEmail()}</td>
					<td>${usuario.getSenha()}</td>
					<td>${usuario.getTelefone()}</td>
					<td>${usuario.getDdd()}</td>
					<td>${usuario.getNumero()}</td>
					<td><a href="editForm.jsp?nome=${usuario.getNome()}">Editar</a></td>
					<td><a href="deleteUser.jsp?nome=${usuario.getNome()}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<a href="viewusuarios.jsp?page=1">1</a>
		<a href="viewusuarios.jsp?page=2">2</a>
		<a href="viewusuarios.jsp?page=3">3</a>
		<br>
		<a href="addUserForm.jsp">Adicionar um novo Usuário</a>
	</body>
</html>