package site.yueyiqiu.tool;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{
	
	String encoding=null;
	
	@Override
	public void destroy() {
		
		this.encoding=null;
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		if(this.encoding!=null){
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html; charset="+this.encoding);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
		
		this.encoding=filterconfig.getInitParameter("encoding");
		
		
	}
	
	
}
