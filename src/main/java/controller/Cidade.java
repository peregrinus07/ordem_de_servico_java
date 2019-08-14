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

import model.TabelaCidade;
import model.TabelaEstado;

/**
 * Servlet implementation class Cidade
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("<option>cidade</option>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//System.out.println("cidade");
		//request.setAttribute("cidade", d);
		//response.setContentType("text/plain");
		//response.setCharacterEncoding("UTF-8");
	   //response.setContentType("application/json");
//	   response.getWriter().write("cidade");
	   //String json;
	   //json = new Gson().toJson(someObject); 
	   //response.setContentType("application/json"); 
	   //response.setCharacterEncoding("UTF-8"); 
	   //response.getWriter().write("cidade");
    //    response.setContentType("application/json"); response.setCharacterEncoding("utf-8"); 
	   //response.getWriter().write("cidade");
	   //PrintWriter out; 
	  // System.out.println("cidade");
//	   String name = request.getParameter("name");
	   //response.getWriter().print("Hello "+ name + "!!");
	   //response.getWriter().write("cidade");
		response.setContentType("text/plain");
		//String fullname = request.getParameter("id");
		//System.out.println("cidade");
		//PrintWriter out = response.getWriter();
 			//out.printf("<option>teste</option>");
	   
 			//JsonArray ob = new JsonArray();
 		///	JSONObject my_obj = new JSONObject();
 			
 			//JsonObject objeto = new JsonObject();
 			//String[] cidade = null;
 			//cidade[0]="cidade";
 			//String[] cidade = null;
 			//cidade[0]="cidade";
 			//cidade.add("cidade");
 			//response.getWriter().print(cidade);
 			//request.setAttribute("lista", cidade);

		String id = request.getParameter("id");
		
		System.out.println("id: "+id);
        response.setContentType("application/json;charset=UTF-8");

        
        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernate");		
   	 
		//EntityManager manager = factory.createEntityManager();
		
		String sql ="select * from tabela_estado where sigla_estado='"+id+"'"; 
		
		//Query query = manager.createNativeQuery(sql); List<Object[]> objects = query.getResultList(); 
		//int d = objects.size();
		//int a = 0;
		
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
		
		
		
		
		int d = lista.size();
		int a = 0;
		List cities = new ArrayList();
		  

		 for (TabelaCidade tarefa : lista) {
	     //       System.out.println(tarefa.getNomeCidade());
			 cities.add("<option>"+tarefa.getNomeCidade()+"</option>");
		     //cities.add("<option>cidade 2</option>");
		          
	        }      
	            
		  
		  
        
        try (PrintWriter out = response.getWriter()) {

            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();

            out.print(gson.toJson(cities));
        }
	}

}
