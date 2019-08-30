package ObjetoDeAcessoAosDados;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

import model.TabelaDescricaoRua;

public class RuaAcessoAosDados {

	public boolean cadastrarRua(TabelaDescricaoRua rua) {

		
		boolean teste = true;
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager = factory.createEntityManager();


		try {

			manager.getTransaction().begin();
			manager.persist(rua);
			manager.getTransaction().commit();
			
		} catch( HibernateException ex ) {
		    System.out.println( ex.getMessage() ); // imprime 'erro ao tentar .. etc '
		    
		    teste = false;
		}   
		

		int id = rua.getIdDescricaoRua();

		System.out.println("descricao rua: " + id);

		// System.out.println("ID da tarefa: " + cliente.getIdCliente());

		manager.close();
		
		return teste;

	}

}
