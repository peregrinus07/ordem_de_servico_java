package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TabelaProduto;

/**
 * Servlet implementation class CadastrarProduto
 */
@WebServlet("/CadastrarProduto")
public class CadastrarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastrarProduto() {
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

		System.out.println("cadastrar produto");

		out.println("<br>cadastrar produto");
		String nomeProduto = request.getParameter("nomeProduto");
		String precoCompraProduto = request.getParameter("precoCompraProduto");
		String precoProdutoVenda = request.getParameter("precoProdutoVenda");
		String cpf = request.getParameter("quantidade");
		String dataDeEntradaProduto = request.getParameter("data");
		String descricaoProduto = request.getParameter("descricaoProduto");

		out.println("<br>cadastrar produto: " + nomeProduto);
		out.println("<br>cadastrar preço de compra: " + precoCompraProduto);
		out.println("<br>cadastrar preço de venda: " + precoProdutoVenda);
		out.println("<br>cadastrar data de entrada produto: " + dataDeEntradaProduto);
		out.println("<br>cadastrar descrição do produto: " + descricaoProduto);

		// String numero ="234,43";

		String listando = new String();

		listando = "1.200,20";

		String str = new String();

		str = precoCompraProduto.replace(".", "");

		String string = str.replace(",", ".");
		
		System.out.println("String: "+string);
		
		
		TabelaProduto produto = new TabelaProduto();
		BigDecimal preco = new BigDecimal(string);
		produto.setNomeProduto(nomeProduto);
		produto.setPrecoDeCompraProduto(preco);
		produto.setPrecoDeVendaProduto(preco);
		
		//SimpleDateFormat formato = new SimpleDateFormat(dataDeEntradaProduto); 
		//SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd"); 
		//Date data = formato.parse("23/11/2015");
		//Date data = null;
		 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 
		
		try {
			produto.setDataEntradaProduto(sdf.parse(dataDeEntradaProduto));
			System.out.println("data");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		produto.setDescricaoProduto(descricaoProduto);
		
		//BigDecimal  = new BigDecimal(string);
		
		//System.out.println(string);
		
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		    EntityManager manager = factory.createEntityManager();

		    manager.getTransaction().begin();        
		    manager.persist(produto);
		    manager.getTransaction().commit();    

		    //System.out.println("ID da tarefa: " + cliente.getIdCliente());

		    manager.close();  
		
		// BigDecimal b = new BigDecimal(numero);
		// BigDecimal bres = new BigDecimal("450.23");
		// bres = b.add(new BigDecimal("450.23"));
		// System.out.println("adicionar :"+b);

	}

}
