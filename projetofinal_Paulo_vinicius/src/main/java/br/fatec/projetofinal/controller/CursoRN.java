package br.fatec.projetofinal.controller;

import java.util.List;



import br.fatec.projetofinal.dao.CursoDAO;
import br.fatec.projetofinal.dao.DAOFactoryCurso;
import br.fatec.projetofinal.model.Curso;

public class CursoRN {
	private CursoDAO cursoDAO;
	
	public CursoRN() {
		this.cursoDAO = DAOFactoryCurso.criaCursoDAO();
	}
	
	public void salvar(br.fatec.projetofinal.model.Curso curso) {
		Integer id = curso.getIdcurso();
		if (id == null || id == 0) {
			this.cursoDAO.salvar(curso);
		} 
	}
	
	@SuppressWarnings("unchecked")
	public List<Curso> listar() {
		return this.cursoDAO.listar();
	}
	
}
