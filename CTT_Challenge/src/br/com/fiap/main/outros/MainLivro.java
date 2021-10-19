package br.com.fiap.main.outros;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.EntityManager;

import br.com.fiap.dao.LivroDao;
import br.com.fiap.dao.implement.LivroDaoImplement;
import br.com.fiap.entidades.Livro;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.singleton.EMFS;

public class MainLivro {

public static void main(String[] args) {
		
		//Entity Manager
		EntityManager em = EMFS.getInstance().createEntityManager();
		
		//LivroDao
		LivroDao dao = new LivroDaoImplement(em);
		
		//Criacao scanner
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("\nMenu CTT Java Database\n1-Cadastrar livro\n2-Consultar livro");
	
		try {
			int escolha = scanner.nextInt();  // Read user input

			if (escolha == 1){
				//As outras informacoes do livro
				Livro livro = new Livro("Titulo", "Autor",22);
				
				//Cadastrar
				try {
					dao.insert(livro);
					dao.commit();
					System.out.println("Livro cadastrado!\nO id do livro é: "+livro.getCodigo()+"\n");
				} catch (CommitException e) {
					System.out.println(e.getMessage()); 
				}
				
			}else if (escolha == 2) {
				//Pesquisar dados
				Livro livro = new Livro();
				try {

					System.out.println("Digite o ID do livro: ");
					int IdLivro = scanner.nextInt();  // Read user input
					
					livro = dao.findById(IdLivro);
				    
					System.out.println(livro.getTitulo() + " " + livro.getAutor()+ " "+livro.getValor());
				} catch(EntityNotFoundException e) {
					System.out.println("Livro não encontrado!");
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
