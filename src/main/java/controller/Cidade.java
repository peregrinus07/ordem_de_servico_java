package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.mysql.cj.x.json.JsonArray;

import model.TabelaBairro;
import model.TabelaCidade;
import model.TabelaEstado;

/**
 * Servlet implementation class Cidade
 * 
 * @param <E>
 */
@WebServlet("/Cidade")
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

		if(c.size()==0) {
			cities.add("<option>Cadastre uma Cidade</option>");
		} 
		
		else {
			cities.add("<option>Selecione uma Cidade</option>");
		}
		
		 
		for (TabelaCidade tarefa : c) {
			// System.out.println(tarefa.getNomeCidade());
			cities.add("<option  value='"+ tarefa.getIdCidade() +" '>" + tarefa.getNomeCidade() + "</option>");
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
		
		List bairros= new ArrayList();
		
		System.out.println("lista tabela: " + bairro.size());
   
		for (TabelaBairro tarefa : bairro) {
			System.out.println("bairro: "+tarefa.getNomeBairro());
			bairros.add("<option  value='"+ tarefa.getIdBairro() +" '>" + tarefa.getNomeBairro() + "</option>");
			// cities.add("<option>cidade 2</option>");

		}
		  
		//List cities = new ArrayList();
		
		System.out.println("cidade: "+cidade);
		 
		return bairros;

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("<option>cidade</option>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String name = request.getParameter("logradouro");

		switch (name) {
		case "cidades":

			System.out.println(name);
			String id = request.getParameter("id");

			List cities = listarCidades(id);

			System.out.println("uf: " + id);

			System.out.println("tamanho da lista cidades: " + cities.size());


			 if (cities.size()==0) {
				cities.add("<option>vazio</option");
			}
 
			   try (PrintWriter out = response.getWriter()) {

		            Gson gson = new GsonBuilder()
		                    .excludeFieldsWithoutExposeAnnotation()
		                    .create();

		            out.print(gson.toJson(cities));
		        }
			 
			 
			break;

		case "bairros":
		    System.out.println("listar bairros");
		    String cidade = request.getParameter("id");
		    String estado = request.getParameter("estado");
		    System.out.println("cidade: "+cidade);
		    System.out.println("estado: "+estado); 
		    
		    List bairros =listarBairros(estado, cidade);
		    
		    if (bairros.size()==0) {
				bairros.add("<option>vazio</option");
			}
 
			   try (PrintWriter out = response.getWriter()) {

		            Gson gson = new GsonBuilder()
		                    .excludeFieldsWithoutExposeAnnotation()
		                    .create();

		            out.print(gson.toJson(bairros));
		        } 
		    
		    break;
			
		default:
			break;
		}
	}

}
