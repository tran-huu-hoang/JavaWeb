package hoang.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import hoang.entity.Department;
import hoang.entity.Employee;
import hoang.entity.SalaryGrade;
import hoang.entity.Timekeeper;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry standardServiceRegistry;
	static {
		try {
//			Configuration config = new Configuration().configure();
//			ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
//			sessionFactory = config.buildSessionFactory(reg);
			if(sessionFactory == null) {
				standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
				metadataSources.addAnnotatedClass(Employee.class);
				metadataSources.addAnnotatedClass(Department.class);
				metadataSources.addAnnotatedClass(SalaryGrade.class);
				metadataSources.addAnnotatedClass(Timekeeper.class);
				Metadata metadata = metadataSources.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			}
		}catch(Throwable ex) {
			ex.printStackTrace();
		} 
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}