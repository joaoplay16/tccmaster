package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dal.ModuloConexao;

public class ListaDeTrabalhos {

	private Connection conexao = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private List<Trabalho> listaTrabalhos = null; 
	private StringBuilder sql;
	

	
	public List<Trabalho> pegarTrabalho(String orderby){
		
		
		try{	
			listaTrabalhos = new ArrayList<Trabalho>();
				conexao = ModuloConexao.conector();	
					sql = new StringBuilder();
					sql.append("select * from cadastro_tcc ");
					if(!orderby.equals("sem-ordem")){
						sql.append("order by ");
						sql.append(orderby);
					}
						pst = conexao.prepareStatement(sql.toString());			
							rs = pst.executeQuery();

			while (rs.next()) {
				Trabalho t = new Trabalho();
				t.setRegistro(rs.getInt("registro"));
				t.setTitulo(rs.getString("titulo"));
				t.setAutor(rs.getString("autor"));
				t.setCurso(rs.getString("curso"));
				t.setModalidade(rs.getString("modalidade"));
				listaTrabalhos.add(t);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
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
		return listaTrabalhos;
	}

	public List<Trabalho> pegarTrabalho(String modalidade, String curso,  String pesquisaPor, String texto,  String orderby){		
		try{	
			listaTrabalhos = new ArrayList<Trabalho>();
			conexao = ModuloConexao.conector();	
			sql = new StringBuilder();
			
				sql.append("select * from cadastro_tcc where modalidade = ? ");
				sql.append("and curso = ? and ");
				sql.append(pesquisaPor);
				sql.append(" like ? ");
				sql.append("order by ");
				sql.append(orderby);
			
			pst = conexao.prepareStatement(sql.toString());
			pst.setString(1, modalidade);
			pst.setString(2, curso);
			pst.setString(3, "%" +texto + "%");
			
						
			rs = pst.executeQuery();

			while (rs.next()) {
				Trabalho t = new Trabalho();
				t.setRegistro(rs.getInt("registro"));
				t.setTitulo(rs.getString("titulo"));
				t.setAutor(rs.getString("autor"));
				t.setCurso(rs.getString("curso"));
				t.setModalidade(rs.getString("modalidade"));
				listaTrabalhos.add(t);
			}			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
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
		return listaTrabalhos;
	}
}
