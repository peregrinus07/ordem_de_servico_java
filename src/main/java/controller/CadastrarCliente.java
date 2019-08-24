package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TabelaCliente;
 

/**
 * Servlet implementation class CadastrarCliente
 */
@WebServlet("/CadastrarCliente")
public class CadastrarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//String parametro1 = config.getInitParameter("param1");
		PrintWriter out = response.getWriter();
		
		System.out.println("cadastrar cliente");
		
		out.println("<br>cadastrar Cliente");
		String nomeCliente = request.getParameter("nomeCliente");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String cpf = request.getParameter("cpf");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidades");
		String bairro = request.getParameter("bairro");
		String endereco = request.getParameter("endereco");
		String numero = request.getParameter("numero");
		String cep = request.getParameter("cep");
		
		out.println("<br>cadastrar Cliente: "+nomeCliente);
		out.println("<br>cadastrar telefone: "+telefone);
		out.println("<br>cadastrar email: "+email);
		out.println("<br>cadastrar cpf: "+cpf);
		out.println("<br>cadastrar estado: "+estado);
		out.println("<br>cadastrar cidade: "+cidade);   
		out.println("<br>cadastrar bairro: "+bairro);
		out.println("<br>cadastrar endereco: "+endereco);
		out.println("<br>cadastrar numero: "+numero); 
		out.println("<br>cadastrar cep: "+cep);
		
		TabelaCliente cliente = new TabelaCliente();
		cliente.setNomeCliente(nomeCliente);
		cliente.setEMailCliente(email);
		cliente.setTelefoneCliente(telefone);
		cliente.setCpfCnpjCliente(cpf);
		//cliente.set
		
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		    EntityManager manager = factory.createEntityManager();

		    manager.getTransaction().begin();        
		    manager.persist(cliente);
		    manager.getTransaction().commit();    

		    //System.out.println("ID da tarefa: " + cliente.getIdCliente());

		    manager.close();  
	}
 
}
