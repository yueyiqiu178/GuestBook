package site.yueyiqiu.service;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.yueyiqiu.dao.MessageDao;
import site.yueyiqiu.model.Message;
import site.yueyiqiu.model.Revert;

/**
 * Servlet implementation class ManagerServlet
 */

public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("method");
		
		if(action!=null){
			
			if(action.equalsIgnoreCase("reply"))
				this.reply(request, response);
			else if(action.equalsIgnoreCase("delete"))
				this.delete(request, response);
			else if(action.equalsIgnoreCase("saveOrUpdateReply"))
				this.saveOrUpdateReply(request, response);
		}
		else{
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		
		if(id!=null){
			
			MessageDao dao=MessageDao.getInstance();
			dao.deleteMessage(Integer.parseInt(id));
			
		}
		else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	
	protected void reply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		MessageDao dao=MessageDao.getInstance();
		Message message=dao.getMessage(Integer.parseInt(id));
		request.setAttribute("message", message);
		System.out.println("title"+message.getTitle());
		System.out.println("content"+message.getContent());
		request.getRequestDispatcher("admin_reply.jsp").forward(request, response);
		
	}
	
	protected void saveOrUpdateReply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String content=request.getParameter("content");
		
		if(content.indexOf("\n")!=-1)
			content.replaceAll("\n", "<br/>");
		MessageDao dao=MessageDao.getInstance();
		Message message=dao.getMessage(Integer.parseInt(id));
		
		if(message!=null){
			Revert reply=message.getReply();
			
			if(reply==null){
				reply=new Revert();
			}
			
			reply.setContent(content);
			reply.setReplytime(new Date());
			
			message.setReply(reply);
			dao.saveMessage(message);
			
		}
		
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	
	protected void isAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("admin")==null){
			
			request.setAttribute("error", "對不起,您沒有權限操作!");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}
	

}
