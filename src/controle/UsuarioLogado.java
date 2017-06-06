package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Dal.ModuloConexao;
import Dal.ServletIndex;

public class UsuarioLogado {

	private Usuario usuario;
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public Usuario getUsuario(String usuario, String senha){

		try {
			conexao = ModuloConexao.conector();
			
			String sql = "select * from login where usuario = ? and senha = ?";
			pst = conexao.prepareStatement(sql);
			pst.setString(1, usuario);
			pst.setString(2, senha);
			rs = pst.executeQuery();
			
			if(rs.next()){
				this.usuario = new Usuario();
				this.usuario.setNome(rs.getString("usuario"));
				this.usuario.setSenha(rs.getString("senha"));
			}else{
				this.usuario = null;
			}


		}catch (Exception e) {
			e.printStackTrace();
		}
		return this.usuario;
	}
}
