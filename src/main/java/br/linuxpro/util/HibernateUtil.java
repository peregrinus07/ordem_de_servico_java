package br.linuxpro.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import model.TabelaBairro;
import model.TabelaCliente;
import model.TabelaDescricaoRua;
import model.TabelaProduto;

public class HibernateUtil {

	// fabrica de sessão
	private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();

	public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}

	private static SessionFactory criarFabricaDeSessoes() {

		try {

			Configuration configuracao = new Configuration().configure();
			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties())
					.build();

			configuracao.addAnnotatedClass(TabelaCliente.class);
			configuracao.addAnnotatedClass(TabelaProduto.class);
			configuracao.addAnnotatedClass(TabelaDescricaoRua.class);
			configuracao.addAnnotatedClass(TabelaBairro.class);
			
			SessionFactory fabrica = configuracao.buildSessionFactory(registro);

			return fabrica;

		} catch (Throwable ex) {
			// TODO: handle exception

			System.err.println("Initical SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}

	}

}
