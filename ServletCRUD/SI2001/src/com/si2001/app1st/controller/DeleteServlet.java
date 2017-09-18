package com.si2001.app1st.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.si2001.app1st.model.User;

import utils.ConnectionManager;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/CancellaUtente.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Session session = ConnectionManager.openSession();
		
			
		int id = Integer.parseInt(request.getParameter("id"));
        User user = session.get(User.class,id);
        if( user != null ) {
            session.delete(user);
        }

        ConnectionManager.closeSession(session);
               
      

        response.sendRedirect("SearchString.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
