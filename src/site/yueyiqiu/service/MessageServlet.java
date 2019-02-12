package site.yueyiqiu.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.yueyiqiu.dao.MessageDao;
import site.yueyiqiu.model.Message;
import site.yueyiqiu.model.User;
import site.yueyiqiu.tool.PageModel;

/**
 * Servlet implementation class MessageServlet
 */

public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
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
			
			if(action.equalsIgnoreCase("view"))
				this.view(request, response);
			else if(action.equalsIgnoreCase("save"))
				this.save(request, response);
			
		}
		else{
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		
	}
	
	protected void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page=request.getParameter("currentpage");
		int currentPage=1;
		int pageSize=2;
		
		if(page!=null)
		currentPage=Integer.parseInt(page);
		
		MessageDao dao=MessageDao.getInstance();
		PageModel model=dao.findPaging(currentPage, pageSize);
		//List<Message> kk=(List<Message>) model.getList();
		//System.out.println(kk.get(0).getTitle());
		//System.out.println(kk.get(0).getContent());
		request.setAttribute("pagemodel", model);
		request.getRequestDispatcher("message_list.jsp").forward(request, response);
		
	}
	
	
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		this.isLogin(request, response);
		
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		if(content.indexOf("\n")!=-1)
			content.replaceAll("\n", "<br/>");
		
		User user=(User) request.getSession().getAttribute("user");
		
		Message message=new Message();
		message.setTitle(title);
		message.setContent(content);
		message.setCreatetime(new Date());
		message.setUser(user);
		
		MessageDao dao=MessageDao.getInstance();
		dao.saveMessage(message);
		request.getRequestDispatcher("MessageServlet?method=view").forward(request, response);
		
	}
	
	
	protected void isLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		if(request.getSession().getAttribute("user")==null){
			request.setAttribute("error", "對不起,您還沒有登入!!");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}
	
}
