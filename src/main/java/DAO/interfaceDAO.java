package DAO;

import java.util.ArrayList;

import Model.ContatoBean;

public interface interfaceDAO {

	void insereContato(ContatoBean contato);
	
	ArrayList<ContatoBean> retornaTodosContatos();
}
