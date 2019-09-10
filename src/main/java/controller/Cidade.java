package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.persistence.config.ReferenceMode;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.descriptors.partitioning.PartitioningPolicy;
import org.eclipse.persistence.exceptions.DatabaseException;
import org.eclipse.persistence.exceptions.EclipseLinkException;
import org.eclipse.persistence.exceptions.ExceptionHandler;
import org.eclipse.persistence.exceptions.IntegrityChecker;
import org.eclipse.persistence.exceptions.ValidationException;
import org.eclipse.persistence.expressions.Expression;
import org.eclipse.persistence.history.AsOfClause;
import org.eclipse.persistence.internal.databaseaccess.Platform;
import org.eclipse.persistence.logging.SessionLog;
import org.eclipse.persistence.logging.SessionLogEntry;
import org.eclipse.persistence.platform.database.DatabasePlatform;
import org.eclipse.persistence.platform.server.ServerPlatform;
import org.eclipse.persistence.queries.AttributeGroup;
import org.eclipse.persistence.queries.Call;
import org.eclipse.persistence.queries.DatabaseQuery;
import org.eclipse.persistence.sessions.DatabaseLogin;
import org.eclipse.persistence.sessions.ExternalTransactionController;
import org.eclipse.persistence.sessions.IdentityMapAccessor;
import org.eclipse.persistence.sessions.Login;
import org.eclipse.persistence.sessions.ObjectCopyingPolicy;
import org.eclipse.persistence.sessions.Project;
import org.eclipse.persistence.sessions.Session;
import org.eclipse.persistence.sessions.SessionEventManager;
import org.eclipse.persistence.sessions.SessionProfiler;
import org.eclipse.persistence.sessions.UnitOfWork;
import org.eclipse.persistence.sessions.serializers.Serializer;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.mysql.cj.x.json.JsonArray;

import antlr.ByteBuffer;
import model.TabelaBairro;
import model.TabelaCidade;
import model.TabelaDescricaoRua;
import model.TabelaEstado;

/**
 * Servlet implementation class Cidade
 * 
 * @param <E>
 */
@WebServlet("/Cidade/*")
public class Cidade<E> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cidade() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	private List listarCidades(String id) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager = factory.createEntityManager();

		TabelaEstado uf = new TabelaEstado();

		// TabelaEstado estado = manager.find(uf.getClass(), 1);
		// System.out.println(estado.getTabelaCidades().get(0));

		String sql = "SELECT t FROM TabelaEstado t where sigla_estado='" + id + "'";

		List<TabelaEstado> lista = manager.createQuery(sql).getResultList();

		System.out.println("lista tabela" + lista.get(0).getTabelaCidades().size());

		List<TabelaCidade> c = lista.get(0).getTabelaCidades();

		List cities = new ArrayList();
		// cities.add("cidade");

		if (c.size() == 0) {
			cities.add("<option>Cadastre uma Cidade</option>");
		}

		else {
			cities.add("<option>Selecione uma Cidade</option>");
		}

		for (TabelaCidade tarefa : c) {
			// System.out.println(tarefa.getNomeCidade());
			cities.add("<option  value='" + tarefa.getIdCidade() + " '>" + tarefa.getNomeCidade() + "</option>");
			// cities.add("<option>cidade 2</option>");

		}
		// List<TabelaCidade> cities = estado.get(0).getTabelaCidades();

		manager.close();

		return cities;

	} // func listar cidades

	private List listarBairros(String uf, String cidade) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager = factory.createEntityManager();

		TabelaCidade c = new TabelaCidade();

		String sql = "SELECT t FROM TabelaCidade t where id_cidade= '" + cidade + "'";

		List<TabelaCidade> lista = manager.createQuery(sql).getResultList();

		List<TabelaBairro> bairro = lista.get(0).getTabelaBairros();

		List bairros = new ArrayList();

		System.out.println("lista tabela: " + bairro.size());

		for (TabelaBairro tarefa : bairro) {
			System.out.println("bairro: " + tarefa.getNomeBairro());
			bairros.add("<option  value='" + tarefa.getIdBairro() + " '>" + tarefa.getNomeBairro() + "</option>");
			// cities.add("<option>cidade 2</option>");

		}

		// List cities = new ArrayList();

		System.out.println("cidade: " + cidade);

		return bairros;

	} // listar bairros

	private String[] listarRuas(String id) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager = factory.createEntityManager();

		TabelaBairro bairro = new TabelaBairro();

		// TabelaEstado estado = manager.find(uf.getClass(), 1);
		// System.out.println(estado.getTabelaCidades().get(0));

		String sql = "SELECT t FROM TabelaBairro t where id_bairro='" + id + "'";

		System.out.println("sql: " + sql);

		List<TabelaBairro> lista = manager.createQuery(sql).getResultList();

		System.out.println("lista tabela: " + lista.get(0).getTabelaDescricaoRuas().size());

		// List<TabelaDescricaoRua> c = lista.get(0).getTabelaDescricaoRuas();
		List<TabelaDescricaoRua> c = lista.get(0).getTabelaDescricaoRuas();
		List cities = new ArrayList();
		// cities.add("cidade");

		int sizeRua = c.size();
		int b = sizeRua - 1;

		System.out.println("lista: " + sizeRua);
		String[] ruasLista = new String[b];

		if (c.size() == 0) {
			cities.add("<option>Cadastre uma Rua</option>");
		}

		else {
			cities.add("Listando ruas");
		}

		System.out.println("id do bairro: " + lista.get(0).getTabelaCidade().getNomeCidade());
		System.out.println("descrição rua: " + c.size());

		int a = sizeRua - 1;
		int contador = 0;

		for (TabelaDescricaoRua tarefa : c) {
			System.out.println("rua teste: " + tarefa.getNomeDaRua());
			cities.add(tarefa.getNomeDaRua());

			if (contador <= a) {

				ruasLista[contador] = tarefa.getNomeDaRua();
				System.out.println("contador" + contador);
				contador++;
			}

			// cities.add("<option>cidade 2</option>");

		}
		// List<TabelaCidade> cities = estado.get(0).getTabelaCidades();

		manager.close();

		return ruasLista;

	} // func listar cidades

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// System.out.println("<option>cidade</option>");

		response.setContentType("text/html;charset=UTF-8");
		String rua = request.getParameter("rua");
		String teste = request.getParameter("teste");
		System.out.println("logradouro: " + rua + " bairro: " + teste);

		String[] ruas = new String[1];
		ruas[0] = "cidade";

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager manager = factory.createEntityManager();

		// TabelaBairro bairro = new TabelaBairro();

		TabelaDescricaoRua listarua = new TabelaDescricaoRua();

		// TabelaEstado estado = manager.find(uf.getClass(), 1);
		// System.out.println(estado.getTabelaCidades().get(0));

		// String sql = "SELECT t FROM TabelaBairro t where id_bairro='1' and
		// t.nomeBairro like '%ald%'";
		String sql = "SELECT t FROM TabelaDescricaoRua t where id_bairro='" + teste + "' and t.nomeDaRua like '%" + rua
				+ "%'";
		// and t.nomeBairro like '%ald%'
		System.out.println("sql: " + sql);

		Query query = manager.createQuery(sql);
		List<TabelaDescricaoRua> lista = query.getResultList();

		System.out.println("lista tabela: " + lista.size());

		// System.out.println("rua: lista "+ruas.length);

		// List<TabelaDescricaoRua> c = lista.get(0).getTabelaDescricaoRuas();
		// List<TabelaDescricaoRua> c = lista.get(0).get;
		List cities = new ArrayList();
		// cities.add("cidade");
		int sizeRua = lista.size();
		int a = sizeRua - 1;

		int b = sizeRua;
		String[] ruasLista = new String[b];

		if (lista.size() == 0) {
			// cities.add("<option>Cadastre uma Rua</option>");
			System.out.println("teste");

			System.out.println("lista vazia");

		} else {

			int contador = 0;
			for (TabelaDescricaoRua tarefa : lista) {
				System.out.println("rua teste: " + tarefa.getNomeDaRua());
				cities.add(tarefa.getNomeDaRua());

				if (contador <= a) {

					ruasLista[contador] = tarefa.getNomeDaRua();
					System.out.println("contador" + contador);
					System.out.println("Rua: " + ruasLista[a]);
					contador++;
				}
			}

			System.out.println("lista rua: " + ruasLista.length);

		} // else
		System.out.println("lista: " + sizeRua);

		if (lista.size() == 0) {

			ruasLista = new String[1];
			ruasLista[0] = "Cadastre uma cidade";

			try (PrintWriter out = response.getWriter()) {

				Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

				out.print(gson.toJson(ruasLista));
			}

		} // if
		else {
			try (PrintWriter out = response.getWriter()) {

				Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

				out.print(gson.toJson(ruasLista));
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		System.out.println("controller cidade");

		String name = request.getParameter("logradouro");

		switch (name) {
		case "cidades":

			System.out.println(name);
			String id = request.getParameter("id");

			List cities = listarCidades(id);

			System.out.println("uf: " + id);

			System.out.println("tamanho da lista cidades: " + cities.size());

			if (cities.size() == 0) {
				cities.add("<option>vazio</option");
			}

			try (PrintWriter out = response.getWriter()) {

				Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

				out.print(gson.toJson(cities));
			}

			break;

		case "bairros":
			System.out.println("listar bairros");
			String cidade = request.getParameter("id");
			String estado = request.getParameter("estado");
			System.out.println("cidade: " + cidade);
			System.out.println("estado: " + estado);

			List bairros = listarBairros(estado, cidade);

			if (bairros.size() == 0) {
				bairros.add("<option>vazio</option");
			}

			try (PrintWriter out = response.getWriter()) {

				Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

				out.print(gson.toJson(bairros));
			}

			break;

		case "logradouro":

			String[] lista = new String[2];

			lista[0] = "cidade";
			lista[1] = "cidade";

			System.out.println("lista de ruas");

			try (PrintWriter out = response.getWriter()) {

				Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

				out.print(gson.toJson(lista));
			}

			break;

		default:

			break;
		}
	}

}
