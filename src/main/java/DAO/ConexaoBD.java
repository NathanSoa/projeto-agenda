package DAO;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class ConexaoBD {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/agendaBD";
	private String user = "root";
	private String password = "5432es";
	
	Connection conectar() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	void encerrarConexaoBD(Connection c){
		
		if(c != null) {
			try {
				c.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	void encerrarConexaoBD(Connection c, PreparedStatement stmt){
		
		if(stmt != null) {
			try {
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		encerrarConexaoBD(c);
	}
	
	void encerrarConexaoBD(Connection c, PreparedStatement stmt, ResultSet rs) {
		
		if(rs != null) {
			try {
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		encerrarConexaoBD(c,stmt);
	}
	
	@Test
	public void testaConexao() {	
		assertNotNull(conectar());
	}
}
