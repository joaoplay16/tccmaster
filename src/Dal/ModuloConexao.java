
package Dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModuloConexao{
    public static Connection conector() throws SQLException{
        java.sql.Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/tcc";
        String user = "root";
        String password = "";

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            System.err.println("Erro!" + e);
            return null;
       
        }

    }
}
