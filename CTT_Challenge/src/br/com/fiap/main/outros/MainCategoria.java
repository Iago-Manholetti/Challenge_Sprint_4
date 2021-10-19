package br.com.fiap.main.outros;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CategoriaDao;
import br.com.fiap.dao.implement.CategoriaDaoImplement;
import br.com.fiap.entidades.Categoria;
import br.com.fiap.entidades.Livro;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.singleton.EMFS;

public class MainCategoria {

	public static void main(String[] args) {
		
		//Entity Manager
		EntityManager em = EMFS.getInstance().createEntityManager();
		
		//UsuarioDao
		CategoriaDao dao = new CategoriaDaoImplement(em);
		
		//Criacao scanner
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("\nMenu CTT Java Database\n1-Cadastrar Categoria\n2-Consultar Categoria");
	
		try {
			int escolha = scanner.nextInt();  // Read user input

			if (escolha == 1){
				//As outras informacoes da Categoria
				Categoria categoria = new Categoria("1", "Comedia");
				
				Livro livroMachado = new Livro("Dom Casmurro", "Machado de Assis", 30);
				
				List<Livro> livros = new ArrayList<>();
				livros.add(livroMachado);
				
				categoria.setLivros(livros);
				
				//Cadastrar
				try {
					dao.insert(categoria);
					dao.commit();
					System.out.println("Categoria cadastrada!\nO id da Categoria é: "+categoria.getCodigo()+"\n");
				} catch (CommitException e) {
					System.out.println(e.getMessage()); 
				}
				
			}else if (escolha == 2) {
				//Pesquisar dados
				Categoria Categoria = new Categoria();
				try {

					System.out.println("Digite o ID da Categoria: ");
					int IdCategoria = scanner.nextInt();  // Read user input
					
					Categoria = dao.findById(IdCategoria);
				    
					System.out.println(Categoria.getNome() + " " + Categoria.getGeneros());
				} catch(EntityNotFoundException e) {
					System.out.println("Categoria não encontrada!");
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
