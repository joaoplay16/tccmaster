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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FEBAC
 */
public class ServletLogin extends HttpServlet {

    Connection conexao = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            conexao = ModuloConexao.conector();
        } catch (SQLException ex) {
            Logger.getLogger(ServletIndex.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            
            if (request.getParameter("acao").equals("Entrar")){

                String sql = "select * from login where usuario = ? and senha = ?";
                pst = conexao.prepareStatement(sql);
                pst.setString(1, usuario);
                pst.setString(2, senha);
                rs = pst.executeQuery();
                
                if(rs.next()){
                    response.sendRedirect("index.jsp");
                }  else{
                    request.setAttribute("erro_login", "Login ou senha incorretos!");
                    request.getRequestDispatcher("/erro.jsp").forward(request, response);             
                }
           }
                

        } catch (Exception e) {
            System.err.print("Erro na operação - " + e);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServletIndex.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServletIndex.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ServletIndex.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
