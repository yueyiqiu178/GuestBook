package site.yueyiqiu.tool;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {
	
	
	private static SessionFactory factory;
	
	static{
		
		try{
			
		Configuration config=new Configuration();
		factory=config.configure().buildSessionFactory();
		
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
	}
	
	public static Session getSession(){
		
		Session session=factory.openSession();
		return session;
	}
	
}
