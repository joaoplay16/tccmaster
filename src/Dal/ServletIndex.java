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
                String modalidade= request.getParameter("modalidade");
                String titulo = request.getParameter("titulo");
                String autor = request.getParameter("autor");
                String curso = request.getParameter("curso");

                String sql = "insert into cadastro_tcc (titulo, autor, curso, modalidade)"
                        + "values(?,?,?,?) ";
                pst = conexao.prepareStatement(sql);
                pst.setString(1, titulo);
                pst.setString(2, autor);
                pst.setString(3, curso);
                pst.setString(4, modalidade);
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
        	try {
				if(pst!=null && rs != null && conexao != null){
					conexao.close();
					pst.close();
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

    }

}
