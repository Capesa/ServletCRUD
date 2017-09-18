package com.si2001.app1st.controller;


import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import com.si2001.app1st.model.User;

import utils.ConnectionManager;

/**
 * Servlet implementation class searchUser
 */
@WebServlet("/SearchString.do")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Session session = ConnectionManager.openSession();
        
		CriteriaBuilder criteria = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteria.createQuery(User.class);
        Root<User> rootUser = criteriaQuery.from(User.class);
        criteriaQuery.select(rootUser);
        
       
        List<User> users = session.createQuery(criteriaQuery).getResultList();
        ConnectionManager.closeSession(session);

        request.setAttribute("users",users);
        RequestDispatcher view = request.getRequestDispatcher("/list.jsp");
        view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Session session = ConnectionManager.openSession();
        CriteriaBuilder criteria = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteria.createQuery(User.class);
        Root<User> rootUser = criteriaQuery.from(User.class);
        String query = request.getParameter("serchString");
        
        criteriaQuery.select(rootUser);
        
        if (query != null && !query.equals("")) {
            String param = "%" + query + "%";
            criteriaQuery
                .where(
                		criteria.or(
                				criteria.like(rootUser.get("firstname"), param),
                				criteria.like(rootUser.get("lastname"), param)
                    )
                );
        }
             
        
        
        List<User> users = session.createQuery(criteriaQuery).getResultList();
        ConnectionManager.closeSession(session);

        request.setAttribute("users",users);
        RequestDispatcher view = request.getRequestDispatcher("/list.jsp");
        view.forward(request,response);
		
	}

}
