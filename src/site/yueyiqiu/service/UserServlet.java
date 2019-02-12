package site.yueyiqiu.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.yueyiqiu.dao.*;
import site.yueyiqiu.model.*;

/**
 * Servlet implementation class UserServlet
 */

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
			
			if("userLogin".equalsIgnoreCase(action)){
				this.userLogin(request, response);
			}
			
			if("userReg".equalsIgnoreCase(action)){
				this.userReg(request, response);	
			}
			
			if("exit".equalsIgnoreCase(action)){
				this.exit(request, response);
			}
			
		}
		else{
			request.getRequestDispatcher("index.jsp").forward(request, response);	
		}
		
	}
	
	protected void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao dao=UserDao.getInstance();
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		User user=dao.getUserByNameAndPwd(name, pwd);
		
		if(user!=null){
			
			if(user instanceof Administrator)
				request.getSession().setAttribute("admin", user);
			
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		else{
			
			request.setAttribute("error", "帳號或密碼錯誤");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			
		}
	}
	
	protected void userReg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("username");
		String pwd=request.getParameter("userpwd");
		String email=request.getParameter("useremail");
		
		UserDao dao=UserDao.getInstance();
		
		if(dao.findUserByName(name)==true){
			request.setAttribute("error", "註冊的username已經存在");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		else{
			
			User user=new User();
			user.setName(name);
			user.setPassword(pwd);
			user.setEmail(email);
			user.setType("user_guest");
			dao.saveUser(user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}
	
	protected void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().removeAttribute("user");
		
		if(request.getSession().getAttribute("admin")!=null){
			request.getSession().removeAttribute("admin");}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
}
