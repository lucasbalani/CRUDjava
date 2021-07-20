package crudjava;


//sera passado ID(Auto Increment), NOME, CIDADE, ESTADO
public class Contato {
	private int id;
	private String nome;
	private String cidade;
	private String estado;
	
	public Contato() {
		
	}
		
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
