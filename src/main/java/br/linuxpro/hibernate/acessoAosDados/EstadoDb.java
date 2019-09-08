package br.linuxpro.hibernate.acessoAosDados;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.linuxpro.util.HibernateUtil;
import model.TabelaEstado;

public class EstadoDb extends AcessoAosDadosGenerico<TabelaEstado> {

	public TabelaEstado pesquisarEstadoPorSigla(String sigla) {

		TabelaEstado estado = new TabelaEstado();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager = factory.createEntityManager();

		// sigla="teste";

		//sigla = "teste";

		List<TabelaEstado> lista = manager
				.createQuery("SELECT t FROM TabelaEstado t where t.siglaEstado ='" + sigla + "'").getResultList();

		System.out.println("lista size " + lista.size());

		if (lista.size() > 0) {

			for (TabelaEstado es : lista) {
				System.out.println(es.getNomeEstado());

				estado = es;

			}

		} 
		else {
			
			estado.setNomeEstado("Estado não cadastrado");
			estado.setSiglaEstado("ce");
			estado.setIdEstado(1);
			
		}
   
		manager.close();
 
		System.out.println("lista: " + lista.size());
		System.out.println("sigla: " + sigla);
		System.out.println("estado: "+estado.getNomeEstado());
		return estado;
	}

}
