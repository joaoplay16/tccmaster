/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.Usuario;
import controle.UsuarioLogado;

/**
 *
 * @author FEBAC
 */
public class ServletLogin extends HttpServlet {

	private Usuario usuario;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();

		try {
			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");            


			if (request.getParameter("acao").equals("Entrar")){
				this.usuario = new UsuarioLogado().getUsuario(usuario, senha);

				if(this.usuario !=null){
					sessao.setAttribute("usuario", this.usuario);
					response.sendRedirect("sec/index.jsp");
				}else{
					request.setAttribute("erro", "login ou senha incorretos");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			}

			if(request.getParameter("acao").equals("Sair")){
				sessao.invalidate();
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			System.err.print("Erro na operacão - " + e);
		} 
	}

}
