package site.yueyiqiu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import site.yueyiqiu.model.Message;
import site.yueyiqiu.model.User;
import site.yueyiqiu.tool.PageModel;
import site.yueyiqiu.tool.SessionFactoryProvider;

public class MessageDao {
	
	private static MessageDao dao=null;
	
	public static MessageDao getInstance(){
		
		if(dao==null)
		  dao=new MessageDao();
		return dao;
	}
	
	public PageModel findPaging(int currentpage,int pagesize){
		
		Session session=null;
		PageModel model = null;
		try{
			
			session=SessionFactoryProvider.getSession();
			session.beginTransaction();
			System.out.println("currentpage="+currentpage);
			System.out.println("pagesize="+pagesize);
			String hql="from Message order by createtime desc";
			Query query=session.createQuery(hql);
			query.setMaxResults(pagesize);
			query.setFirstResult((currentpage-1)*pagesize);
			
			List<Message> list=query.list();
			//System.out.println(((Message)list.get(0)).getTitle());
			model=new PageModel();
			model.setCurrentpage(currentpage);
			model.setList(list);
			model.setPageSize(pagesize);
			model.setTotalRows(this.getTotalRecords(session));
			session.getTransaction().commit();
			
		}
		catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally{
			session.close();
		}
		return model;
		
		
	}
	
	
	public int getTotalRecords(Session session){
		
		String hql="select count(*) from Message";
		Query query=session.createQuery(hql);
		Long ptr=(Long) query.uniqueResult();
		return ptr.intValue();
	}
	
	
	public void saveMessage(Message message){
		
		Session session=null;
		
		try{
			
			session=SessionFactoryProvider.getSession();
			session.beginTransaction();
			session.saveOrUpdate(message);
			
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
	
	
	public void deleteMessage(int id){
		
		Session session=null;
		
		try{
			
			session=SessionFactoryProvider.getSession();
			session.beginTransaction();
			
			Message message=(Message) session.get(Message.class, id);
			session.delete(message);
			
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
	
	
	public List<Message> findAllMessage(){
		
		Session session=null;
		List<Message> list=null;
		try{
			
			session=SessionFactoryProvider.getSession();
			session.beginTransaction();
			
			
			String hql="from Message";
			
			list=session.createQuery(hql).list();
			
			
			session.getTransaction().commit();
			
		}
		catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally{
			session.close();
		}
		
		return list;
	}
	
	
	public Message getMessage(int id){
		
		Session session=null;
		Message message=null;
		try{
			
			session=SessionFactoryProvider.getSession();
			session.beginTransaction();
			
			message=(Message) session.get(Message.class, id);
			
			
			
			session.getTransaction().commit();
			
		}
		catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		finally{
			session.close();
		}
		
		return message;
	}
	
	
}
