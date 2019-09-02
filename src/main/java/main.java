import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.sessions.Session;
import org.hibernate.SQLQuery;

import model.TabelaBairro;
import model.TabelaCidade;
import model.TabelaCliente;
import model.TabelaDescricaoRua;
import model.TabelaEstado;

public class main {

	private void listandoEstados() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager = factory.createEntityManager();

		TabelaEstado uf = new TabelaEstado();

		TabelaEstado estado = manager.find(uf.getClass(), 1);
		// System.out.println(estado.getTabelaCidades().get(0));

		List<TabelaCidade> lista = estado.getTabelaCidades();

		for (TabelaCidade tarefa : lista) {
			System.out.println(tarefa.getNomeCidade());

		}
		System.out.println(estado.getTabelaCidades().size());

		manager.close();
		// System.out.println("teste");

	}

	public void listarCidades() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager = factory.createEntityManager();

		TabelaBairro bairro = new TabelaBairro();

		// TabelaEstado estado = manager.find(uf.getClass(), 1);
		// System.out.println(estado.getTabelaCidades().get(0));

		String sql = "SELECT t FROM TabelaBairro t where id_bairro='1' and t.nomeBairro like '%ald%'";

		System.out.println("sql: " + sql);

		Query query = manager.createQuery(sql);
		List<TabelaBairro> lista = query.getResultList();

		System.out.println("lista tabela: " + lista.get(0).getTabelaDescricaoRuas().size());

		// System.out.println("rua: lista "+ruas.length);

		// List<TabelaDescricaoRua> c = lista.get(0).getTabelaDescricaoRuas();
		List<TabelaDescricaoRua> c = lista.get(0).getTabelaDescricaoRuas();
		List cities = new ArrayList();
		// cities.add("cidade");
		int sizeRua = c.size();
		int b = sizeRua;

		System.out.println("lista: " + sizeRua);
		String[] ruasLista = new String[b];

		if (c.size() == 0) {
			cities.add("<option>Cadastre uma Rua</option>");
		}

		else {
			cities.add("Listando ruas");
		}

		System.out.println("id do bairro: " + lista.get(0).getTabelaDescricaoRuas().get(0).getNomeDaRua());
		System.out.println("descrição rua: " + c.size());

		int a = sizeRua - 1;
		int contador = 0;

		for (TabelaDescricaoRua tarefa : c) {
			System.out.println("rua teste: " + tarefa.getNomeDaRua());
			cities.add(tarefa.getNomeDaRua());

			if (contador <= a) {

				ruasLista[contador] = tarefa.getNomeDaRua();
				System.out.println("contador" + contador);
				System.out.println("Rua: " + ruasLista[a]);
				contador++;
			}
		}

	}

	public static void main(String[] args) {

		/*
		 * String listando = new String();
		 * 
		 * listando = "1.200,20";
		 * 
		 * String str = new String();
		 * 
		 * str = listando.replace(".", "");
		 * 
		 * System.out.println("listando: "+str.replace(",", "."));
		 */

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager = factory.createEntityManager();

		TabelaCliente cliente = new TabelaCliente();

		cliente.setNomeCliente("nome");
		cliente.setTelefoneCliente("1");
		cliente.setEMailCliente("a@gmail");
		cliente.setCpfCnpjCliente(" ");

		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.getTransaction().commit();

		System.out.println("ID da tarefa: " + cliente.getIdCliente());

		manager.close();

	}

}
