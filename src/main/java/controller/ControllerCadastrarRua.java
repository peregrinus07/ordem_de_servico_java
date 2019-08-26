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

import model.TabelaBairro;
import model.TabelaCepRua;
import model.TabelaDescricaoRua;

/**
 * Servlet implementation class ControllerCadastrarRua
 */
@WebServlet("/ControllerCadastrarRua")
public class ControllerCadastrarRua extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerCadastrarRua() {
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

		PrintWriter out = response.getWriter();
		out.println("<script>alert('rua cadastrada com sucesso')</script>");

		System.out.println("Cadastrar Rua");

		String estado = request.getParameter("estado");
		String bairro = request.getParameter("bairro");
		String endereco = request.getParameter("endereco");
		String cep = request.getParameter("cep");

		String precoCompraProduto = request.getParameter("precoCompraProduto");
		String precoProdutoVenda = request.getParameter("precoProdutoVenda");
		// String c

		System.out.println("Estado:" + estado);
		System.out.println("Bairro:" + bairro);
		System.out.println("Endereco:" + endereco);
		System.out.println("Cep:" + cep);

		TabelaDescricaoRua rua = new TabelaDescricaoRua();
		TabelaBairro b = new TabelaBairro();

		int i = 1;
		i = Integer.parseInt(bairro.trim());

		System.out.println("bairro: " + bairro);

		b.setIdBairro(i);

		rua.setFkIdTipoDaRua(1);
		rua.setNomeDaRua(endereco);
		rua.setTabelaBairro(b);

		TabelaCepRua c = new TabelaCepRua();

		c.setCepRua(cep);

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
