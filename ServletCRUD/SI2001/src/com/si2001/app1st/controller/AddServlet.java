package com.si2001.app1st.controller;

import java.io.IOException;
import java.util.ArrayList;
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

import com.si2001.app1st.model.MaritalStatus;
import com.si2001.app1st.model.Skill;
import com.si2001.app1st.model.User;

import utils.ConnectionManager;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/CreateUser.do")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AddServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Session session = ConnectionManager.openSession();
		//CriteriaBuilder builder = session.getCriteriaBuilder();

		/*CriteriaQuery<MaritalStatus> Maritalquery = builder.createQuery(MaritalStatus.class);
		Root<MaritalStatus> MaritalRoot = Maritalquery.from(MaritalStatus.class);
		Maritalquery.select(MaritalRoot);
		List<MaritalStatus> mstatus = session.createQuery(Maritalquery).getResultList();

		CriteriaQuery<Skill> Skillquery = builder.createQuery(Skill.class);
		Root<Skill> SkillRoot = Skillquery.from(Skill.class);
		Skillquery.select(SkillRoot);
		List<Skill> skills = session.createQuery(Skillquery).getResultList();
*/
		
		 List maritalStatusList = session.createQuery("from MaritalStatus").list();
	     List skills = session.createQuery("from Skill").list();
	        ConnectionManager.closeSession(session);

		request.setAttribute("mstatus", maritalStatusList);
		request.setAttribute("skills", skills);

		RequestDispatcher view = request.getRequestDispatcher("/createuser.jsp");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*
		 * Configuration config = new Configuration().configure();
		 * ServiceRegistry servReg = new
		 * StandardServiceRegistryBuilder().applySettings(config.getProperties()
		 * ).build();
		 */

		Session session = ConnectionManager.openSession();

		User u = new User(request.getParameter("firstname"), request.getParameter("lastname"));

		int maritalId = Integer.parseInt(request.getParameter("marital_status_id"));

		u.setMaritalStatus(session.get(MaritalStatus.class, maritalId));

		String skillsIds = request.getParameter("skillsIds");

		if (skillsIds != null && !skillsIds.equals("")) {
			String[] skillsIdsArray = skillsIds.split(",");
			List<Skill> skills = new ArrayList<>();
			for (String skillId : skillsIdsArray) {
				Skill skill = new Skill();
				skill.setSkillId(Integer.parseInt(skillId));
				skills.add(skill);
			}
			if (skills.size() > 0) {
				u.setSkills(skills);
			}
		}

		session.save(u);

		ConnectionManager.closeSession(session);
		response.sendRedirect(request.getContextPath() + "/SearchString.do");

	}

}
