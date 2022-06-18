package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.ContatoBean;

public class ImplContatoDAO implements interfaceDAO {

	ConexaoBD conecta = new ConexaoBD();
	
	
	@Override
	public void insereContato(ContatoBean contato) {
		String sql = "INSERT INTO contatos(con_nome, con_email, con_telefone) VALUES (?, ?, ?);";
		Connection c = conecta.conectar();
		
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getTelefone());
			
			stmt.executeUpdate();
			
			conecta.encerrarConexaoBD(c, stmt);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
