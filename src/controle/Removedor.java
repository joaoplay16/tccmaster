package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Dal.ModuloConexao;

public class Removedor {

	Connection conexao = null;
	PreparedStatement pst = null;
	
    public void erase(String ids[]){
	try{
		
		conexao = ModuloConexao.conector();			
		
			for (int i = 0; i <= ids.length; i++) {

				String sql = "delete from cadastro_tcc where id = ?";

				pst = conexao.prepareStatement(sql);

				pst.setInt(1, Integer.parseInt(ids[i]));

				pst.executeUpdate();

			}

		
	} catch (Exception e) {

		e.printStackTrace();
	}finally{
		try {
			conexao.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}try {
			pst.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
}
