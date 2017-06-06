package security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter(
		urlPatterns = {"/sec/*"}, 
		servletNames = { 
				"ServletIndex", 
				"ServletTrabalhos",
		})
public class SecurityFilter implements Filter {

   
    public SecurityFilter() {
       
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession sessao = req.getSession();
		
		if(sessao.getAttribute("usuario")== null){
//			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			res.sendRedirect("../login.jsp");
			return;
		}else{		
			chain.doFilter(request, response);
		}
	}
	
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
