<%@ page import="com.crudjspjava.dao.UsuarioDao" %>
<jsp:useBean id="u" class="com.crudjspjava.bean.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
	UsuarioDao.deletarUser(u);
	response.sendRedirect("viewUsuario.jsp");
%>