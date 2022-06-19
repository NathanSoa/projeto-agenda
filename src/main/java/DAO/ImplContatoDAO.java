package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.ContatoBean;

public class ImplContatoDAO implements interfaceDAO {

	ConexaoBD conecta = new ConexaoBD();
	
	
	@Override
	public void insereContato(ContatoBean contato) {
		String sql = "INSERT INTO contatos(con_nome, con_email, con_telefone) VALUES (?, ?, ?);";
		
		try {
			Connection c = conecta.conectar();
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
	
	@Override
	public ArrayList<ContatoBean> retornaTodosContatos() {
		String sql = "SELECT * FROM contatos ORDER BY con_nome";
		ArrayList<ContatoBean> lista = new ArrayList<ContatoBean>();
		
		try {
			Connection c = conecta.conectar();
			PreparedStatement stmt = c.prepareStatement(sql);		
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				lista.add(montaObjeto(rs));
			}

			conecta.encerrarConexaoBD(c, stmt, rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	@Override
	public ContatoBean buscaContatoPorCodigo(String codigo) {
		String sql = "SELECT * FROM contatos WHERE con_codigo = ?";
		ContatoBean contato = null;
		try {
			Connection c = conecta.conectar();
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, codigo);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				contato = montaObjeto(rs);
			}
			conecta.encerrarConexaoBD(c, stmt, rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return contato;
	}
	
	@Override
	public void alteraContato(ContatoBean contato) {
		String sql = "UPDATE contatos SET con_nome = ?, con_email = ?, con_telefone = ? WHERE con_codigo = ?";
		try {
			Connection c = conecta.conectar();
			PreparedStatement stmt = c.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getTelefone());
			stmt.setInt(4, Integer.valueOf(contato.getCodigo()));
			stmt.executeUpdate();
			
			conecta.encerrarConexaoBD(c, stmt);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deletaContato(String codigo) {
		String sql = "DELETE FROM contatos WHERE con_codigo = ?";
		
		try {
			Connection c = conecta.conectar();
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setInt(1, Integer.valueOf(codigo));	
			stmt.executeUpdate();
			
			conecta.encerrarConexaoBD(c, stmt);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private ContatoBean montaObjeto(ResultSet rs) throws SQLException {
		
		String codigo = String.valueOf(rs.getInt("con_codigo"));
		String email = rs.getString("con_email");
		String nome = rs.getString("con_nome");
		String telefone = rs.getString("con_telefone");
		
		return new ContatoBean(codigo, nome, email, telefone);
	}
}
