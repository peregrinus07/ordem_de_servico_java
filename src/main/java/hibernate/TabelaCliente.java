package hibernate;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the tabela_clientes database table.
 * 
 */
@Entity
@Table(name = "tabela_clientes")
@NamedQuery(name = "TabelaCliente.findAll", query = "SELECT t FROM TabelaCliente t")
public class TabelaCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_cliente")
	private int idCliente;

	@Column(name = "cpf_cnpj_cliente")
	private String cpfCnpjCliente;

	@Column(name = "e_mail_cliente")
	private String eMailCliente;

	@Column(name = "nome_cliente")
	private String nomeCliente;

	@Column(name = "telefone_cliente")
	private String telefoneCliente;

	public TabelaCliente() {
	}

	static void criarTabela() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");

		EntityManager manager = factory.createEntityManager();

		manager.close();
		factory.close();

	}


	public void cadastrarCliente(TabelaCliente cliente) {
		//TabelaCliente 
		//cliente = new TabelaCliente();
		//cliente.setNomeCliente("janete");
		//cliente.setEMailCliente("janete@gmail.com");
		//cliente.setTelefoneCliente("1111111");
		
		  EntityManagerFactory factory = Persistence.
                  createEntityManagerFactory("hibernate");

      EntityManager manager = factory.createEntityManager();
      
      manager.getTransaction().begin();        
      manager.persist(cliente);
      manager.getTransaction().commit();    

      System.out.println("ID da tarefa: " + cliente.getIdCliente());

	}
	

	static void pesquisarClienteId(TabelaCliente cliente) {
 
		//TabelaCliente 
		
		//cliente = new TabelaCliente();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
	    EntityManager manager = factory.createEntityManager();

	    cliente  = manager.find(cliente.getClass(), cliente.getIdCliente());

	    System.out.println("Nome: "+cliente.getNomeCliente()+" email: "+cliente.getEMailCliente()+" - telefone: "+cliente.getTelefoneCliente());
 		
	}


	
	public void atualizarCliente(TabelaCliente cliente) {

//TabelaCliente 
		//cliente = new TabelaCliente();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
	    EntityManager manager = factory.createEntityManager();

	    TabelaCliente teste  = manager.find(cliente.getClass(), cliente.getIdCliente());

	    cliente.setIdCliente(teste.getIdCliente());
	    
	    manager.getTransaction().begin();
        manager.merge(cliente);
        manager.getTransaction().commit();
        
        pesquisarClienteId(cliente);
        
        System.out.println("id cliente: "+cliente.getTelefoneCliente());
	    System.out.println(cliente.getNomeCliente()+" telefone: "+cliente.getTelefoneCliente());

		
	} 
	
	public static List<TabelaCliente> listarClientes() {

		TabelaCliente cliente = new TabelaCliente();

		EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("hibernate");
            EntityManager manager = factory.createEntityManager();

        //cuidado, use o import javax.persistence.Query
        Query query = manager
                .createQuery("SELECT t FROM TabelaCliente t");
        //query.setParameter("paramFinalizado", true);

        List<TabelaCliente> lista = query.getResultList();
        
        manager.close();
 
		return (List<TabelaCliente>) lista;

	}

	
	
	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCpfCnpjCliente() {
		return this.cpfCnpjCliente;
	}

	public void setCpfCnpjCliente(String cpfCnpjCliente) {
		this.cpfCnpjCliente = cpfCnpjCliente;
	}

	public String getEMailCliente() {
		return this.eMailCliente;
	}

	public void setEMailCliente(String eMailCliente) {
		this.eMailCliente = eMailCliente;
	}

	public String getNomeCliente() {
		return this.nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getTelefoneCliente() {
		return this.telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

}