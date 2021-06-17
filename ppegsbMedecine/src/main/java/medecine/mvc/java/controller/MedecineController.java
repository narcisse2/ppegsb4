package medecine.mvc.java.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import medecine.mvc.java.dao.MedecineDAO;
import medecine.mvc.java.dao.MedecineDAOImpl;
import medecine.mvc.java.model.Medecine;

/**
 * Servlet implementation class MedecineController
 */
@WebServlet(urlPatterns = {"/getMedical"})
public class MedecineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	MedecineDAO medecineDAO = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedecineController() {
    	medecineDAO = new MedecineDAOImpl();
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listMedecine(request, response);
				break;
			case "EDIT":
				getSingleMedecine(request,response);
				break;
				
			case "DELETE":
				deleteMedecine(request, response);
				break;
				
			default:
				listMedecine(request, response);
				break;
				
		}
	}
	
private void deleteMedecine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
	
		if(medecineDAO.delete(Integer.parseInt(id))) {
			request.setAttribute("NOTIFICATION", "Medecine Deleted Successfully!");
		}
		
		listMedecine(request, response);
	}


  private void getSingleMedecine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	String id = request.getParameter("id");
	
	Medecine theMedecine = medecineDAO.get(Integer.parseInt(id));
	
	request.setAttribute("medecine", theMedecine);
	
	dispatcher = request.getRequestDispatcher("/view/medecine-form.jsp");
	
	dispatcher.forward(request, response);
}

	private void listMedecine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		List<Medecine> theList = medecineDAO.get();
		
		request.setAttribute("list", theList);
	
		dispatcher = request.getRequestDispatcher("/view/medecine-list.jsp");
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		Medecine m = new Medecine();

		m.setNom(request.getParameter("nom"));
		m.setPrenom(request.getParameter("Prenom"));
		m.setAdress(request.getParameter("Adresse"));
		m.setTel(request.getParameter("Tel"));
		m.setSpe(request.getParameter("specialiteComplementaire"));
		
		m.setDepartement(Integer.parseInt(request.getParameter("departement")));
		
		
		
		
		
		

		
  	if(id.isEmpty() || id == null) {
			
			if(medecineDAO.save(m)) {
				request.setAttribute("NOTIFICATION", " Save Successfully!");
			}
		
		}else {
			
			m.setId(Integer.parseInt(id));
			if(medecineDAO.update(m)) {
				request.setAttribute("NOTIFICATION", " Update Successfully!");
			}
			
		}
		
		getSingleMedecine(request, response);
		
		
	}
	

}


