package crudjava;

import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception{
		int option = 0;
		crud metodos = new crud();
		Scanner scan = new Scanner(System.in);
		
		//Motor de repetição do MENU
		do {
			System.out.println("	||MENU||\n"+
								"*1 - Salvar contato\n" +
								"*2 - Alterar contato\n" +
								"*3 - Deletar contato\n" +
								"*4 - Sair");
			option = scan.nextInt();
			
			switch (option) {
			case 1:
				Contato contato = new Contato();
				Telefones telefone = new Telefones();
				scan.nextLine();
				cadastrarContato(contato, scan);
				contato = metodos.saveContato(contato);
				System.out.println("Pressione enter");
				scan.nextLine();
				
					for(int i = 0; i < 3; i++) {
						telefone = cadastrarTelefone(contato, scan, telefone);
						metodos.saveTelefone(telefone);
					}
					
				break;
			
			case 2:
				Contato contato2 = new Contato();
				Telefones telefone2 = new Telefones();
				int idAluno;
				int idTelefone;
				metodos.read();
				scan.nextLine();
				idAluno = cadastrarUpdate(contato2, scan);
				metodos.update(contato2, idAluno);
				metodos.readTelefones();
				System.out.println("Pressione enter");
				scan.nextLine();
				
				telefone = cadastrarUpdateTelefone(contato2, scan, telefone2);
				idTelefone = telefone.getIdTelefone();
				metodos.updateTelefone(idAluno, telefone, idTelefone);
				break;
			case 3:
				int id;
				metodos.read();
				System.out.println("Digite o ID do contato que deseja remover");
				id = scan.nextInt();
				metodos.delete(id);
			default:
				break;
			}
			
			
			
		} while (option >= 1 && option < 4);
	}
	
	//função criada com a finalidade de resolver o erro ao chamar
	//o scanner varias vezes no WHILE
	public static int Menu() {
		Scanner scan = new Scanner(System.in);
		int option = 0;
		System.out.println("Selecione a operação que deseja"+
						   "\n1 - Inserir" +
						   "\n2 - Modificar" +
						   "\n3 - Deletar" +
						   "\n4 - Sair");
		option = scan.nextInt();
		scan.close();
		return option;
	}
	
	public static int cadastrarUpdate(Contato contato2, Scanner scan) {
		String nome;
		String cidade;
		String estado;
		int id;
		

		System.out.println("Digite o id do aluno que precisa alterar ");
		id = Integer.parseInt(scan.nextLine());

		System.out.println("Digite o novo nome: ");
		nome = scan.nextLine();
		contato2.setNome(nome);
		
		System.out.println("Digite o novo Estado: ");
		estado = scan.nextLine();
		contato2.setEstado(estado);
		
		System.out.println("Digite a nova cidade");
		cidade = scan.nextLine();
		contato2.setCidade(cidade);
		
		return id;
		
		
		
	}
	
	public static Contato cadastrarContato(Contato contato, Scanner scan) {
		String nome;
		String cidade;
		String estado;
		
		System.out.println("Digite o nome");
		nome = scan.nextLine();
		contato.setNome(nome);
		
		//Seta o atributo estado
		System.out.println("Digite o estado de "+ contato.getNome());
		estado = scan.nextLine();
		contato.setEstado(estado);
		
		//Seta o atributo cidade
		System.out.println("Digite a cidade de "+ contato.getNome());
		cidade = scan.nextLine();
		contato.setCidade(cidade);
		
		
		
		
		return contato;
	}
	
	public static Telefones cadastrarTelefone(Contato contato, Scanner scan, Telefones telefone) {
		String numTelefone;
		
		//le o numero do telefone
		System.out.println("Digite o numero do telefone: ");
		numTelefone = scan.nextLine();
		//seta o atributo telefone no objeto
		telefone.setTelefone(numTelefone);
		
		//seta o id do aluno no telefone
		telefone.setIdAluno(contato.getId());
		
		return telefone;
	}
	
	public static Telefones cadastrarUpdateTelefone(Contato contato, Scanner scan, Telefones telefone) {
		String numTelefone;
		int idTelefone;
		
		
		System.out.println("Digite o numero do ID TELEFONE a ser alterado");
		idTelefone = Integer.parseInt(scan.nextLine());
		telefone.setIdTelefone(idTelefone);
		
		//le o numero do telefone
		System.out.println("Digite o numero do telefone: ");
		numTelefone = scan.nextLine();
		//seta o atributo telefone no objeto
		telefone.setTelefone(numTelefone);
		
		//seta o id do aluno no telefone
		telefone.setIdAluno(contato.getId());
		
		return telefone;
	}
}
