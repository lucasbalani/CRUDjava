package crudjava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class crud {

	private Connection con = null;
	
	public Contato saveContato(Contato contato) throws Exception{
		con = ConnectionFactory.createConnectionSQL();
		String sql = "INSERT INTO CONTATOS(nome, cidade, estado) values(?,?,?)";
		PreparedStatement pstm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet rs;
		
		pstm.setString(1, contato.getNome());
		pstm.setString(2, contato.getCidade());
		pstm.setString(3, contato.getEstado());
		pstm.execute();
		
		rs = pstm.getGeneratedKeys();
		if(rs != null) {
			if(rs.next()) {
				int id = rs.getInt(1);
				contato.setId(id);
			}
		}
		
		if(con != null) {
			con.close();
		}
		if(pstm != null) {
			pstm.close();
		}
		
		return contato;
		
	}
	
	public Telefones saveTelefone(Telefones telefone) throws Exception{
		con = ConnectionFactory.createConnectionSQL();
		String sql = "INSERT INTO telefones (idAluno, telefone) values(?,?)";
		PreparedStatement pstm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		ResultSet rs;
		
		pstm.setInt(1, telefone.getIdAluno());
		pstm.setString(2, telefone.getTelefone());
		pstm.execute();
		
		
		rs = pstm.getGeneratedKeys();
		if(rs != null) {
			if(rs.next()) {
				int id = rs.getInt(1);
				telefone.setIdTelefone(id);
			}
		}
		
		if(con != null) {
			con.close();
		}
		if(pstm != null) {
			pstm.close();
		}
		
		return telefone;
		
		
	}
	
	
	public void read() throws Exception {
		con = ConnectionFactory.createConnectionSQL();
		String sql = "Select * from contatos";
		ResultSet result;
		PreparedStatement pstm = con.prepareStatement(sql);
		result = pstm.executeQuery();
		
		while(result.next()) {
			int id = result.getInt("id");
			String nome = result.getString("nome");
			String cidade = result.getString("cidade");
			String estado = result.getString("estado");
			
			String message = "ID %d - NOME %s - CIDADE %s - ESTADO %s\n";
			System.out.printf(message, id, nome, cidade, estado);
		}
		
		con.close();
		pstm.close();
	}

	public void readTelefones() throws Exception {
		con = ConnectionFactory.createConnectionSQL();
		String sql = "Select * from telefones";
		ResultSet result;
		PreparedStatement pstm = con.prepareStatement(sql);
		result = pstm.executeQuery();
		
		while(result.next()) {
			int idAluno = result.getInt("idAluno");
			int idTelefone = result.getInt("idTelefone");
			String telefone = result.getString("telefone");
			
			String message = "ID DO ALUNO: %d - ID DO TELEFONE: %d - TELEFONE: %s\n";
			System.out.printf(message, idAluno, idTelefone, telefone);
		}
		
		con.close();
		pstm.close();
	}
	
	public void update(Contato contato2, int id) throws Exception {
		con = ConnectionFactory.createConnectionSQL();
		String sql = "UPDATE contatos SET nome=?, cidade=?, estado=? WHERE id=?;";
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setString(1, contato2.getNome());
		pstm.setString(2, contato2.getCidade());
		pstm.setString(3, contato2.getEstado());
		pstm.setInt(4, id);
		pstm.execute();
		
		con.close();
		pstm.close();
		
		
	}
	
	public void updateTelefone(int idAluno, Telefones telefone, int idTelefone) throws Exception {
		con = ConnectionFactory.createConnectionSQL();
		String sql = "UPDATE telefones SET telefone=? WHERE idAluno=? and idTelefone=?;";
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setString(1, telefone.getTelefone());
		pstm.setInt(2, idAluno);
		pstm.setInt(3, idTelefone);
		pstm.execute();
		
		con.close();
		pstm.close();
	}
	
	public void delete(int id) {
		
		try {
		con = ConnectionFactory.createConnectionSQL();
		String sql = "DELETE FROM CONTATOS WHERE ID = ?";
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setInt(1, id);
		pstm.execute();
		
		System.out.println("Aluno deletado com sucesso !");
		 
		con.close();
		pstm.close();
		
		} catch (Exception e){
			System.out.println("Erro ao deletar aluno - "+ e.getMessage());
		}
	}
	
}
