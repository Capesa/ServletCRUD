package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.si2001.app1st.model.MaritalStatus;
import com.si2001.app1st.model.Skill;
import com.si2001.app1st.model.User;

public class ConnectionManager {

	private static SessionFactory sessionFactory;

	static {
		Configuration config = new Configuration().configure();

		config.addAnnotatedClass(User.class);
		config.addAnnotatedClass(MaritalStatus.class);
		config.addAnnotatedClass(Skill.class);

		ServiceRegistry servReg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(servReg);

	}

	public static Session openSession() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		return session;
	}

	public static void closeSession(Session session) {
		session.getTransaction().commit();
		session.close();
	}
}