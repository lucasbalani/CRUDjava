package crudjava;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static String USER = "";//Insira o usuario do banco de dados
	private static String PASS = "";//Insira a senha do banco de dados
	private static String DB_URL = "jdbc:mysql://<endereço do banco aqui>?useTimezone=true&serverTimezone=UTC";//Insira a url do banco de dados
	
	//Metodo que carrega a classe jdbc driver e cria uma conexao com o driver manager
	public static Connection createConnectionSQL() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		return con;
	}
	
	
}
