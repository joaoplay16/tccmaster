/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joao
 */
public class ServletIndex extends HttpServlet {

    int id;
    private int registro;
    private String titulo;
    private String autor;
    private String curso;

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            conexao = ModuloConexao.conector();
        } catch (SQLException ex) {
            Logger.getLogger(ServletIndex.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        try {
        		if (request.getParameter("acao").equals("Salvar")) {
                int registro = Integer.parseInt(request.getParameter("registro"));
                String titulo = request.getParameter("titulo");
                String autor = request.getParameter("autor");
                String curso = request.getParameter("curso");

                String sql = "insert into cadastro_tcc (registro, titulo, autor, curso)"
                        + "values(?,?,?,?) ";
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, registro);
                pst.setString(2, titulo);
                pst.setString(3, autor);
                pst.setString(4, curso);
                int b = pst.executeUpdate();

                if (b != 0) {
                    response.sendRedirect("index.jsp");
                } else {
                	request.setAttribute("falha_inserir", "Falha ao inserir dados!");
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

    }

}
