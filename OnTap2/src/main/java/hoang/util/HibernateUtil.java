package hoang.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import hoang.entity.Category;
import hoang.entity.Book;
import hoang.entity.Publisher;
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
				metadataSources.addAnnotatedClass(Category.class);
				metadataSources.addAnnotatedClass(Book.class);
				metadataSources.addAnnotatedClass(Publisher.class);
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