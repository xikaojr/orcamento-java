package team.java.controllers.Funcionario;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import team.java.dao.FuncionarioDAO;
import team.java.domain.Funcionario;


@WebServlet("/funcionario/autocomplete/*")
public class AutoComplete extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	  public void executa(HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	        
		  
	        JSONArray lista = null; //cria o array
	        FuncionarioDAO funcDAO = new FuncionarioDAO();
	        
	        String term = request.getParameter("term"); //term é o parametro enviado pelo jquery ao usar o autocomplete
	        
	        try {
	            lista = new JSONArray(); //cria o array
	            
	            List<Funcionario> listaFunionarios = funcDAO.getAll(term) ;
	 
	            for (Funcionario funcionario: listaFunionarios)
	            {
	                JSONObject jsonObject = new JSONObject();
	                
	                jsonObject.put("label", funcionario.getNome());
	                jsonObject.put("func_id", funcionario.getId());
	                jsonObject.put("value", funcionario.getNome());
	                
	                lista.put(jsonObject);
	            }
	 
	            listaFunionarios = null;
	            term = null;
	 
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.getMessage();
	        }
	        
	        response.setContentType("application/json");
	        response.getWriter().write(lista.toString());
	 
	        lista = null;
	    }
	  
	  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  try {
			executa(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	  
	  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  try {
			executa(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}