package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.linuxpro.hibernate.acessoAosDados.CidadeDb;
import br.linuxpro.hibernate.acessoAosDados.EstadoDb;
import model.TabelaCidade;
import model.TabelaEstado;

/**
 * Servlet implementation class ControllerCadastrarCidade
 */
@WebServlet("/ControllerCadastrarCidade")
public class ControllerCadastrarCidade extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerCadastrarCidade() {
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

		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidades");

		System.out.println("Estado: " + estado);
		System.out.println("Cidade: " + cidade);

		EstadoDb estadodb = new EstadoDb();

		TabelaEstado es = estadodb.pesquisarEstadoPorSigla(estado);

		System.out.println("nome estado: " + es.getNomeEstado());
		System.out.println("id: " + es.getIdEstado());

		TabelaCidade cid = new TabelaCidade();

		if (es.getNomeEstado() == "Estado não cadastrado") {

			System.out.println("estado: "+es.getNomeEstado());
			
		} else {

			cid.setTabelaEstado(es);
			cid.setNomeCidade(cidade);

			CidadeDb cidadedb = new CidadeDb();
			cidadedb.salvar(cid);

		}

	} 

}
