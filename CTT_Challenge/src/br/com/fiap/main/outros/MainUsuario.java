package br.com.fiap.main.outros;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.EntityManager;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.dao.implement.UsuarioDaoImplement;
import br.com.fiap.entidades.Livro;
import br.com.fiap.entidades.Usuario;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.singleton.EMFS;

public class MainUsuario {
	
	public static void main(String[] args) {
	
		//Entity Manager
		EntityManager em = EMFS.getInstance().createEntityManager();
		
		//UsuarioDao
		UsuarioDao dao = new UsuarioDaoImplement(em);
		
		//Criacao scanner
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nMenu CTT Java Database\n1-Cadastrar usuario\n2-Consultar usuario");
		
		try {
		int escolha = scanner.nextInt();  // Read user input

		if (escolha == 1){
			//Informacoes para criar o usuario
			Calendar CalendarioDataNascimento = Calendar.getInstance();
			//A data de nascimento, exemplo: 12/01/2005
			CalendarioDataNascimento.set(2001, 6, 29);
			//As outras informacoes do usuario
			Usuario usuario = new Usuario("Lago", "coxinha123",CalendarioDataNascimento,"12345678-90", 100);
			
			
			//Informacoes para criar livros
			Livro livroCortico = new Livro("O cortico", "Aluisio Azevedo", 10);
			
			usuario.addLivro(livroCortico);
			
			//Cadastrar
			try {
				dao.insert(usuario);
				dao.commit();
				System.out.println("Usuario cadastrado!\nO id do usuario é: "+usuario.getCodigo()+"\n");
			} catch (CommitException e) {
				System.out.println(e.getMessage()); 
			}
			
		}else if (escolha == 2) {
			//Pesquisar dados
			Usuario usuario = new Usuario();
			try {

				System.out.println("Digite o ID do usuario: ");
				int IdUsuario = scanner.nextInt();  // Read user input
				
				usuario = dao.findById(IdUsuario);
				
			    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			    String Data = sdf.format(usuario.getDataNascimento().getTime());
			    
				System.out.println(usuario.getUsername() + " " + usuario.getSenha()+ " " + Data + " " + usuario.getCpf()+ " " + usuario.getCreditos());
			} catch(EntityNotFoundException e) {
				System.out.println("Usuario não encontrado!");
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
