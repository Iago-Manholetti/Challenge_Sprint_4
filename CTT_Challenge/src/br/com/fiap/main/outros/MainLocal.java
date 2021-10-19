package br.com.fiap.main.outros;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.EntityManager;

import br.com.fiap.dao.LocalDao;
import br.com.fiap.dao.implement.LocalDaoImplement;
import br.com.fiap.entidades.Local;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.singleton.EMFS;

public class MainLocal {

	public static void main(String[] args) {
		
		//Entity Manager
		EntityManager em = EMFS.getInstance().createEntityManager();
		
		//UsuarioDao
		LocalDao dao = new LocalDaoImplement(em);
		
		//Criacao scanner
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("\nMenu CTT Java Database\n1-Cadastrar local\n2-Consultar local");
	
		try {
			int escolha = scanner.nextInt();  // Read user input

			if (escolha == 1){
				//As outras informacoes do local
				Local local = new Local("Barueri", "Terminal de Onibus","Em frente a bilheteria");
				
				//Cadastrar
				try {
					dao.insert(local);
					dao.commit();
					System.out.println("Local cadastrado!\nO id do local é: "+local.getCodigo()+"\n");
				} catch (CommitException e) {
					System.out.println(e.getMessage()); 
				}
				
			}else if (escolha == 2) {
				//Pesquisar dados
				Local local = new Local();
				try {

					System.out.println("Digite o ID do local: ");
					int IdLocal = scanner.nextInt();  // Read user input
					
					local = dao.findById(IdLocal);
				    
					System.out.println(local.getCidade() + " " + local.getPontoReferencia()+ " "+local.getLocalExato());
	
				} catch(EntityNotFoundException e) {
					System.out.println("Local não encontrado!");
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
