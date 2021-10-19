package br.com.fiap.main.outros;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AvaliacaoDao;
import br.com.fiap.dao.implement.AvaliacaoDaoImplement;
import br.com.fiap.entidades.Avaliacao;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.singleton.EMFS;

public class MainAvaliacao {

	public static void main(String[] args) {
		
		//Entity Manager
		EntityManager em = EMFS.getInstance().createEntityManager();
		
		//UsuarioDao
		AvaliacaoDao dao = new AvaliacaoDaoImplement(em);
		
		//Criacao scanner
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("\nMenu CTT Java Database\n1-Cadastrar avaliacao\n2-Consultar avaliacao");
	
		try {
			int escolha = scanner.nextInt();  // Read user input

			if (escolha == 1){
				//As outras informacoes do avaliacao
				Avaliacao avaliacao = new Avaliacao(10,"Muito bom");
				
				//Cadastrar
				try {
					dao.insert(avaliacao);
					dao.commit();
					System.out.println("Avaliacao cadastrado!\nO id das avaliacoes é: "+avaliacao.getCodigo()+"\n");
				} catch (CommitException e) {
					System.out.println(e.getMessage()); 
				}
				
			}else if (escolha == 2) {
				//Pesquisar dados
				Avaliacao avaliacao = new Avaliacao();
				try {

					System.out.println("Digite o ID da avaliacao: ");
					int IdAvaliacao = scanner.nextInt();  // Read user input
					
					avaliacao = dao.findById(IdAvaliacao);
				    
					System.out.println(avaliacao.getNota() + " " + avaliacao.getComentario());
				} catch(EntityNotFoundException e) {
					System.out.println("Avaliacao não encontrado!");
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
