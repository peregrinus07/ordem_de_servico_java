package hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerarTabelas {
	
	static void teste() {
		  EntityManagerFactory factory = Persistence.
                  createEntityManagerFactory("hibernate");

      EntityManager manager = factory.createEntityManager();
      
      manager.close();
      factory.close();
	}

	static void cadastrarCliente() {
		TabelaCliente cliente = new TabelaCliente();
		cliente.setNomeCliente("janete");
		cliente.setEMailCliente("janete@gmail.com");
		cliente.setTelefoneCliente("1111111");
		
		  EntityManagerFactory factory = Persistence.
                  createEntityManagerFactory("hibernate");

      EntityManager manager = factory.createEntityManager();
      
      manager.getTransaction().begin();        
      manager.persist(cliente);
      manager.getTransaction().commit();    

      System.out.println("ID da tarefa: " + cliente.getIdCliente());

	}
	
	static void pesquisarCliente() {
 
		TabelaCliente cliente = new TabelaCliente();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
	    EntityManager manager = factory.createEntityManager();

	    cliente  = manager.find(cliente.getClass(), 258);

	    System.out.println(cliente.getNomeCliente());
 		
	}
	
	public static void main(String[] args) {
 
TabelaCliente cliente = new TabelaCliente();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
	    EntityManager manager = factory.createEntityManager();

	    cliente  = manager.find(cliente.getClass(), 258);

	    cliente.setTelefoneCliente("2222");
	    
	    manager.getTransaction().begin();
        manager.merge(cliente);
        manager.getTransaction().commit();
	    
	    System.out.println(cliente.getNomeCliente()+" telefone: "+cliente.getTelefoneCliente());
 
		
	}

}
