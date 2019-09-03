package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.linuxpro.hibernate.acessoAosDados.CepDaRuaDb;
import br.linuxpro.hibernate.acessoAosDados.DescricaoDaRuaDb;
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

		// TabelaCepRua c = new TabelaCepRua();

		int i = 1;
		i = Integer.parseInt(bairro.trim());

		System.out.println("bairro: " + bairro);

		// bairro id
		b.setIdBairro(i);

		rua.setFkIdTipoDaRua(1);
		rua.setNomeDaRua(endereco);
		rua.setTabelaBairro(b);

		TabelaCepRua cepRua = new TabelaCepRua();

		// adicionando o cep da rua ao cep_da_rua
		cepRua.setCepRua(cep);

		DescricaoDaRuaDb ruaDb = new DescricaoDaRuaDb();

		List<TabelaCepRua> cepDaRua = new ArrayList<TabelaCepRua>();

		cepDaRua.add(cepRua);

		rua.setTabelaCepRuas(cepDaRua);

		ruaDb.salvar(rua);

		CepDaRuaDb cepDb = new CepDaRuaDb();

		
		cepRua.setTabelaDescricaoRua(rua);
		
		cepDb.salvar(cepRua);

		System.out.println("id da rua: " + rua.getIdDescricaoRua());
		System.out.println("id cep da rua: " + cepRua.getIdCepRua());

		// RuaAcessoAosDados r = new RuaAcessoAosDados();

		// boolean teste = r.cadastrarRua(rua);
		/*
		 * if (teste) {
		 * 
		 * System.out.println("Teste");
		 * 
		 * PrintWriter out = response.getWriter();
		 * out.println("<script>alert('rua cadastrada com sucesso')</script>");
		 * System.out.println("Rua cadastrada com sucesso");
		 * 
		 * } else { System.out.println("erro ao cadastrar rua"); }
		 */
	}

}
