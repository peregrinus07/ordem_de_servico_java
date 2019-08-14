import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.sessions.Session;
import org.hibernate.SQLQuery;

import model.TabelaCidade;
import model.TabelaEstado;
 

public class main {

	public static void main(String[] args) {

		
		EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("hibernate");
        EntityManager manager = factory.createEntityManager();

        TabelaEstado uf = new TabelaEstado();
        
        TabelaEstado estado = manager.find(uf.getClass(), 1);
        //System.out.println(estado.getTabelaCidades().get(0));        

        List<TabelaCidade> lista = estado.getTabelaCidades();
        
        for (TabelaCidade tarefa : lista) {
            System.out.println(tarefa.getNomeCidade());
            
        }
        System.out.println(estado.getTabelaCidades().size());        
        
        manager.close();
		//System.out.println("teste");

	}

}
