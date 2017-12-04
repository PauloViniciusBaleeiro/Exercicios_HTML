package br.fatec.projetofinal.dao;

import java.util.List;



import br.fatec.projetofinal.model.Curso;
import br.fatec.projetofinal.controller.CursoBean;

public interface CursoDAO {
	
	public void salvar(Curso curso);
	public List listar();
}
