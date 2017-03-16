package br.usjt.arqdesis.service;

import br.usjt.arqdesis.model.Empresa;
import br.usjt.arqdesis.dao.EmpresaDAO;

public class EmpresaService {

	EmpresaDAO dao = new EmpresaDAO();
	
	public int criar(Empresa empresa){
		return dao.criar(empresa);
	}
	
	public void atualizar(Empresa empresa){
		dao.atualizar(empresa);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public Empresa carregar(int id){
		return dao.carregar(id);
	}
}
