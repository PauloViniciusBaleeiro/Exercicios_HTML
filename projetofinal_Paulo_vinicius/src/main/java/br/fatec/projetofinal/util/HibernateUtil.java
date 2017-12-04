package br.fatec.projetofinal.util;


import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;

//classe responsavel por instanciar a SessionFactory do Hibernate e retorna-la quando solicitado

public class HibernateUtil {

	// procura o arquivo no package raiz do projeto

	// buildSessionFactory responsavel por criar uma SessionFactory com
	// base
	// no arquivo XML montado
	// o codigo fonte incluido no metodo estatico privado
	// buildSessionFactory() 
	// responsavel por configurar o Hibernate e retornar um Session
	// Factory
	// qdo chamar getSessionFactory() retornara a propriedade
	// sessionFactory
	// sessionFactory estara sempre criada, pelo fato de ser uma
	// propriedade
	// estatica alimentada
	// no momento em que a classe e carregada na memoria

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
  	StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
	            .configure( "hibernate.cfg.xml" )
	            .build();

		List<Class<?>> classes = EntityScanner
		            .scanPackages("br.fatec.projetofinal.controller").result();
		    MetadataSources metadataSources = new MetadataSources(standardRegistry);
		    
		    for (Class<?> annotatedClass : classes) {
		        metadataSources.addAnnotatedClass(annotatedClass);
		    }
		    return metadataSources.buildMetadata()
		        .buildSessionFactory();	
	}

	public static SessionFactory getSessionFactory() {
          return sessionFactory;
      }
	
}
