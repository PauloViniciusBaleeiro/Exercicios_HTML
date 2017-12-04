package br.fatec.projetofinal.dao;

import br.fatec.projetofinal.util.HibernateUtil;

public class DAOFactoryCurso {
	
	public static CursoDAO criaCursoDAO() {
		CursoDAOHibernate cursoDAO = new CursoDAOHibernate();
			      cursoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
			return cursoDAO;
		}
}
