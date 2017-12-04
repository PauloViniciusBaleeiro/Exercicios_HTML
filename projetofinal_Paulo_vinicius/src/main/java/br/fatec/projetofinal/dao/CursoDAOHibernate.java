package br.fatec.projetofinal.dao;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.fatec.projetofinal.model.Curso;
import br.fatec.projetofinal.util.HibernateUtil;
import br.fatec.projetofinal.controller.CursoBean;

public class CursoDAOHibernate implements CursoDAO {
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	public void salvar(Curso curso){
		try {
			this.session.getSessionFactory().openSession();
			this.session.beginTransaction();
			this.session.save(curso);
			this.session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível inserir o Curso. Erro: " + e.getMessage());
		}
	}
	
	
	public List<Curso> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "from Curso";
		@SuppressWarnings("unchecked")
		List<Curso> lista = session.createQuery(hql).list();
		if (lista != null) {
			return lista;
		} else {
			System.out.println("nao passou nada");
			return null;
		}
	}
}
