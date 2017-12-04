package br.fatec.projetofinal.controller;

import javax.faces.bean.ManagedBean;


import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;


import br.fatec.projetofinal.dao.CursoDAO;
import br.fatec.projetofinal.dao.CursoDAOHibernate;
import br.fatec.projetofinal.model.Curso;

@ManagedBean(name = "CursoBean")
@RequestScoped

public class CursoBean {
	private Curso curso = new Curso();
	
	private DataModel<Curso> listaCursos;

	@SuppressWarnings("unchecked")
	public DataModel<Curso> getListaCursos() {
		if (listaCursos == null) {
			CursoDAO dao = new CursoDAOHibernate();
			listaCursos = new ListDataModel<Curso>(dao.listar());
		}
		return listaCursos;
	}
	
	public void setListaCursos(DataModel<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public String novo() {
		this.curso = new Curso();
			return "publico/curso"; //
		}
	
	public String listagem() {
		this.curso = new Curso();
		return "publico/listagemcur";
	}

	public String salvar() {
		CursoRN cursoRN = new CursoRN();
		cursoRN.salvar(this.curso);
		return "cursosucesso";
	}
}
