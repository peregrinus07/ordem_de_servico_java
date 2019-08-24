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

import model.TabelaUsuario;

/**
 * Servlet implementation class CadastrarUsuario
 */
@WebServlet("/CadastrarUsuario")
public class CadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastrarUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		System.out.println("Cadastrar Usuário");

		PrintWriter out = response.getWriter();

		TabelaUsuario usuario = new TabelaUsuario();

		out.println("<br>cadastrar Usuario");
		String nomeCliente = request.getParameter("nomeCliente");
		String telefone = request.getParameter("telefone");
		String rg = request.getParameter("rg");
		String email = request.getParameter("email");
		String cpf = request.getParameter("cpf");

		out.println("<br>cadastrar Cliente: " + nomeCliente);
		out.println("<br>cadastrar telefone: " + telefone);
		out.println("<br>cadastrar email: " + email);
		out.println("<br>cadastrar cpf: " + cpf);
		out.println("<br>cadastrar rg: " + rg);

		usuario.setNomeUsuario(nomeCliente);
		usuario.setTelefoneUsuario(telefone);
		usuario.setEMailUsuario(email);
		usuario.setRgUsuario(rg);
		usuario.setCpfUsuario(cpf);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();

		// System.out.println("ID da tarefa: " + cliente.getIdCliente());

		manager.close();
	}

}
