package ObjetoDeAcessoAosDados;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TabelaDescricaoRua;

public class RuaAcessoAosDados {

	public void cadastrarRua(TabelaDescricaoRua rua) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(rua);

		manager.getTransaction().commit();

		int id = rua.getIdDescricaoRua();

		System.out.println("descricao rua: " + id);

		// System.out.println("ID da tarefa: " + cliente.getIdCliente());

		manager.close();

	}

}
