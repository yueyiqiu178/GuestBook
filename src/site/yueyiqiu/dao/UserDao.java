package site.yueyiqiu.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import site.yueyiqiu.model.User;
import site.yueyiqiu.tool.SessionFactoryProvider;

public class UserDao {
	
	private static UserDao dao=null;
	
	public static UserDao getInstance(){
		
		if(dao==null)
		  dao=new UserDao();
		return dao;
	}
	
	public User getUserByNameAndPwd(String name,String pwd){
		
		Session session=null;
		User user=null;
		try{
			
			session=SessionFactoryProvider.getSession();
			session.beginTransaction();
			
			String hql="from User where name=:name and password=:pwd";
			
			Query query=session.createQuery(hql);
			query.setString("name", name);
			query.setString("pwd", pwd);
			
			user=(User) query.uniqueResult();
			session.getTransaction().commit();
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally{
			session.close();
		}
		return user;
		
	} 
	
	
	public void saveUser(User user){
		
		Session session=null;
		
		try{
			
			session=SessionFactoryProvider.getSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			
		}
		catch(Exception e){
			
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally{
			session.close();
		}
		
	}
	
	public boolean findUserByName(String name){
		
		Session session=null;
		boolean ptr=false;
		try{
			
			session=SessionFactoryProvider.getSession();
			session.beginTransaction();
			
			String hql="from User where name=:name";
			
			Query query=session.createQuery(hql);
			query.setString("name", name);
			
			if(query.list().size()>0)
				ptr=true;
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally{
			session.close();
		}
		return ptr;
		
	}
	
}
