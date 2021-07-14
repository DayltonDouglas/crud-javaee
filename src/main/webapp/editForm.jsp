<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Editando Usuario</title>
	</head>
	<body>
		<%@page import="com.crudjspjava.bean.Usuario, com.crudjspjava.dao.UsuarioDao" %>
		<%
			String nome = request.getParameter("nome");
			Usuario usuario = UsuarioDao.getRegistroByName("nome");
		%>
		<h1>Edição de Usuario</h1>
		<form action="editUsuario.jsp" method="post">
			<table>
				<tr>
					<td>Nome: </td>
					<td><input type="text" name="nome" value="<%=usuario.getNome()%>"/></td>
				</tr>
				<tr>
					<td>Email: </td>
					<td><input type="email" name="email" value="<%=usuario.getEmail()%>"/></td>
				</tr>
				<tr>
					<td>Senha: </td>
					<td><input type="password" name="senha" value="<%=usuario.getSenha()%>"/></td>
				</tr>
				<tr>
					<td>Telefone: </td>
					<td><input type="text" name="telefone" value="<%=usuario.getTelefone()%>"/></td>
				</tr>
				<tr>
					<td>DDD: </td>
					<td><input type="text" name="ddd" value="<%=usuario.getDdd()%>"/></td>
				</tr>
				<tr>
					<td>Numero: </td>
					<td><input type="text" name="numero" value="<%=usuario.getNumero()%>"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Editar o usuário"/></td>
				</tr>
			</table>
		
		</form>
		
	</body>
</html>