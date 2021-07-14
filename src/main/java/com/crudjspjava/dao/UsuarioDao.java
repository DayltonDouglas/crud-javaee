package com.crudjspjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudjspjava.bean.Usuario;

//Classe onde aplicamos todas fun��es e modelos para modelagem do Usu�rio
public class UsuarioDao {

	private static Connection con = null;
	private static String usuario="SA";
	private static String senha="";
	private static String PathBase="C:\\Users\\Daylt\\Downloads\\hsqldb-2.6.0\\hsqldb-2.6.0\\hsqldb\\data\\crud\\usuario";
	private final static String URL = "jdbc:hsqldb:file" + PathBase;
	
	//Estabelecendo a conex�o com o HSQLDB
	public static Connection getConnection() {
		
		if(con==null) {
			try {
				Class.forName("org.hsqldb.jdbc.JDBCDriver");
				con=DriverManager.getConnection(URL,usuario,senha);
			}catch(Exception e){
				System.out.println(e);
			}
			
		}
		return con;
		
	}
	//Fun��o para deletar o Usu�rio
	public static int deletarUser(Usuario u) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM usuario WHERE nome=?");
			ps.setString(1, u.getNome());
			status = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	//Salvando um novo Usuario no sistema e no banco de dados
	public static int salvarUsuario(Usuario u) {
		
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO usuario(nome,email,senha,telefone,ddd,numero) VALUES (?,?,?,?,?,?)");
			ps.setString(1, u.getNome());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getSenha());
			ps.setString(4, u.getTelefone());
			ps.setInt(5, u.getDdd());
			ps.setString(6, u.getNumero());
			status = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	//Buscando um usu�rio atrav�s de seu nome registrado
	public static Usuario getRegistroByName(String nome) {
		Usuario usuario = null;
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario WHERE nome=?");
			ps.setString(0, nome);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setDdd(rs.getInt("ddd"));
				usuario.setNumero(rs.getString("numero"));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return usuario;
	}
	
	//Fun��o para poder editar e atualizar um Usu�rio existente
	public static int updateUsuario(Usuario u) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement)con.prepareStatement("UPDATE	usuario SET nome=?," + "email=?, senha=?, telefone=?, ddd=?, numero=? WHERE id=?");
			ps.setString(1, u.getNome());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getSenha());
			ps.setString(4, u.getTelefone());
			ps.setInt(5, u.getDdd());
			ps.setString(6, u.getNumero());
			status = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	//Fun��o que lista todos os Usu�rios
	public static List<Usuario> getAllUsuarios(){
		
		List<Usuario> list = new ArrayList<Usuario>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setDdd(rs.getInt("ddd"));
				usuario.setNumero(rs.getString("numero"));
				list.add(usuario);
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return list;
	}
	
	//Fun��o que lista os Usu�rios partindo do principio de colocar um limite em quantos podem ser visualizados
	public static List<Usuario> getRecords(int start, int total){
		
		List<Usuario> list = new ArrayList<Usuario>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario LIMIT " + (start-1) + "," + total);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setDdd(rs.getInt("ddd"));
				usuario.setNumero(rs.getString("numero"));
				list.add(usuario);
			}
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
}
