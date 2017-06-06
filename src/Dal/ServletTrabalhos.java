package Dal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.ListaDeTrabalhos;
import controle.Removedor;
import controle.Trabalho;

import java.util.List;



public class ServletTrabalhos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Trabalho> lista;

	protected void Service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
						
		
			
			String modalidade = request.getParameter("modalidade");
			String curso = request.getParameter("curso");
			String pesquisaPor = request.getParameter("pesquisaPor");
			String busca = request.getParameter("txtBusca");
			
			
		
			if (request.getParameter("txtBusca") != null && 
				request.getParameter("txtBusca").equals("")) {

				lista = new ListaDeTrabalhos().pegarTrabalho("titulo");
				request.setAttribute("lista", lista);
				request.getRequestDispatcher("sec/trabalhos.jsp").forward(request, response);
				return;
			}
			

			if (request.getParameter("opcao") != null && 
				request.getParameter("opcao").equals("Buscar")) {

				lista = new ListaDeTrabalhos().pegarTrabalho(modalidade, curso, pesquisaPor, busca, pesquisaPor);
				request.setAttribute("lista", lista);	
				request.getRequestDispatcher("sec/trabalhos.jsp").forward(request, response);
				return;
			}
			
			
			if (request.getParameter("opcao") != null && 
				request.getParameter("opcao").equals("Remover")) {
				String ids[] = request.getParameterValues("check"); 
				new Removedor().erase(ids);
				
				response.sendRedirect("trabalhos?txtBusca=");
			}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service(request, response);
	}

}
