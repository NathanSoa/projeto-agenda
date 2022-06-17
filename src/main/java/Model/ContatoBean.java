package Model;

import java.io.Serializable;

public class ContatoBean implements Serializable {

	private String codigo;
	private String nome;
	private String email;
	private String telefone;
	
	
	public ContatoBean() {
		
	}
	
	public ContatoBean(String codigo, String nome, String email, String telefone) {
		this.codigo = codigo;
		this.email = email;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
}
