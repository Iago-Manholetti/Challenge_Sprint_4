package br.com.fiap.main;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import br.com.fiap.dao.LivroDao;
import br.com.fiap.dao.implement.LivroDaoImplement;
import br.com.fiap.entidades.Livro;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.singleton.EMFS;

public class Funcionalidade {

	public static void main(String[] args) {
		
		//Entity Manager
		EntityManager em = EMFS.getInstance().createEntityManager();
		
		//LivroDao
		LivroDao dao = new LivroDaoImplement(em);
		
		//Criacao scanner
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nMenu CTT Challenge \n1-Realizar Cadastro do Livro \n2-Pesquisar livro por título \n3-Listar todos os livros \n4-Deletar livro");
		
	try {	
		int escolha = scanner.nextInt();  // Read user input
		
		if (escolha == 1){	
			//As outras informacoes do livro
			Livro livro = new Livro("Amor Liquido", "Bauman",30);
			
			//Cadastrar
			try {
				dao.insert(livro);
				dao.commit();
				System.out.println("Livro cadastrado!\nO seu Id é: "+livro.getCodigo()+"\n");
			} catch (CommitException e) {
				System.out.println(e.getMessage()); 
			}
				
				
			
		}else if (escolha == 2) {
			
			List<Livro> livros = dao.listar();
	
				//Digitar nome do livro
				System.out.println("Digite o título do livro: ");
				String tituloLivro = scanner.next();
			
				//Buscar livro por nome
				livros = dao.buscarTitulo(tituloLivro);
				System.out.println("\nLista de livros com o titulo "+tituloLivro+" achados:");
				
				//If se a busca não achar nada enviar msg de erro
				if (livros.isEmpty()) {
					System.err.println("Nao foi encontrado nenhum livro com esse nome");} 
				{
					livros.forEach(c -> System.out.println(c.getTitulo()+" de "+c.getAutor()+" por "+c.getValor()+"R$"));
					System.out.println("\n");
				}
				//Buscar reservas por datas customizadas
			
				
			}else if (escolha == 3) {
				
				//Mostrar todos os livros
				//If se a busca não achar nada enviar msg de erro
				System.out.println("\nLista de todos os livros achados:\n");
				
				//Instanciar os livros e colocar em uma lista
				List<Livro> livros = dao.listar();
				
					
					if (livros.isEmpty()) {
						System.err.println("Nao foi encontrado nenhum livro na lista");} 
					{
						livros.forEach(c -> System.out.println(c.getTitulo()+" de "+c.getAutor()+" por "+c.getValor()+"R$"+" com o codigo "+c.getCodigo()));
						System.out.println("\n");
					}
				
					
			}else if (escolha == 4) {
					//Digitar o id do livro a ser deletado
					System.out.println("Digite o ID do livro a ser deletado ");
					int idLivro = scanner.nextInt();
					
					//deletar
					try {
						dao.delete(idLivro);
						dao.commit();
						System.out.println("Livro deletado!");
					} catch (CommitException e) {
						System.out.println(e.getMessage()); 
					} catch (EntityNotFoundException e) {
						System.out.println(e.getMessage()); 
					}
						
			}else {
				System.out.println("Por favor digite apenas 1 ou 2");
			}
			}catch(InputMismatchException e) {
				System.err.println("Por favor digite uma opcao valida\n");
			}
			
			//Fecha
			scanner.close();
			em.close();
			EMFS.getInstance().close();
	
	
	}
	
	
}
