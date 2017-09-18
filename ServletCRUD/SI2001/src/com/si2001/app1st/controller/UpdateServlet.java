package com.si2001.app1st.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.si2001.app1st.model.MaritalStatus;
import com.si2001.app1st.model.User;

import utils.ConnectionManager;

/**
 * Servlet implementation class UpdateUser
 */


@WebServlet("/ModificaUtente.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Session session = ConnectionManager.openSession();
		User user = new User();
		
		if ( request.getParameter("id") != null && !request.getParameter("id").equals("") ) {
			
			int id = Integer.parseInt(request.getParameter("id"));
	        user = session.get(User.class,id);
	        
		}
		
		String sqlMarital = "FROM MaritalStatus";
	    Query queryMarital = session.createQuery(sqlMarital);
	    List<MaritalStatus> maritalStatusList = queryMarital.getResultList();
       
        ConnectionManager.closeSession(session);

        request.setAttribute("user",user);
        request.setAttribute("maritalStatusList", maritalStatusList);
        
        RequestDispatcher view = request.getRequestDispatcher("/modificautente.jsp");
        view.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			Session session = ConnectionManager.openSession();

	        String nome 	= request.getParameter("firstname");
	        String cognome  = request.getParameter("lastname");
	      

	        int maritalId = Integer.parseInt(request.getParameter("marital_status_id"));
	       
	        User user = new User();

	        if ( request.getParameter("id") != null && !request.getParameter("id").equals("") ){

	            Integer userId = Integer.parseInt(request.getParameter("id"));
	            user.setId(userId);

	        }
	            user.setFirstname(nome);
	            user.setLastname(cognome);
	          
	            user.setMaritalStatus(session.get(MaritalStatus.class, maritalId));
	           
	           
	            session.saveOrUpdate(user);
	            session.getTransaction().commit();
	            session.close();
	            
	            response.sendRedirect("SearchString.do");
	     
		
	}

}
