package hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GerarTabelas {

	
	public static void main(String[] args) {

		TabelaCliente cliente = new TabelaCliente();
		cliente.setNomeCliente("uia");
		cliente.setTelefoneCliente("222");
		cliente.setEMailCliente("testegmail");
		cliente.setIdCliente(261);

		//TabelaCliente teste = new TabelaCliente();
 
		List<TabelaCliente> teste = cliente.listarClientes(); 
		 
		
         for (TabelaCliente t : teste) {
            System.out.println(t.getNomeCliente());
        }
 
       
	}

}
