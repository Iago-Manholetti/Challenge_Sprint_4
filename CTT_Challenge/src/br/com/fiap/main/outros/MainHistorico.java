package br.com.fiap.main.outros;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.EntityManager;

import br.com.fiap.dao.HistoricoDao;
import br.com.fiap.dao.implement.HistoricoDaoImplement;
import br.com.fiap.entidades.Historico;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.singleton.EMFS;

public class MainHistorico {

public static void main(String[] args) {
		
		//Entity Manager
		EntityManager em = EMFS.getInstance().createEntityManager();
		
		//UsuarioDao
		HistoricoDao dao = new HistoricoDaoImplement(em);
		
		//Criacao scanner
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("\nMenu CTT Java Database\n1-Cadastrar historico\n2-Consultar historico");
	
		try {
			int escolha = scanner.nextInt();  // Read user input

			if (escolha == 1){
				//Informacoes para criar a data do Historico
				Calendar CalendarioQuando = Calendar.getInstance();
				//A data de quando, exemplo: 25/04/1998
				CalendarioQuando.set(1998, 4, 25);
				
				//As outras informacoes do historico
				Historico historico = new Historico("NomePessoa", "Titulo", 15, CalendarioQuando);
				
				//Cadastrar
				try {
					dao.insert(historico);
					dao.commit();
					System.out.println("Historico cadastrado!\nO id do historico é: "+historico.getCodigo()+"\n");
				} catch (CommitException e) {
					System.out.println(e.getMessage()); 
				}
				
			}else if (escolha == 2) {
				//Pesquisar dados
				Historico historico = new Historico();
				try {

					System.out.println("Digite o ID do historico: ");
					int IdHistorico = scanner.nextInt();  // Read user input
					
					historico = dao.findById(IdHistorico);
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				    String Data = sdf.format(historico.getQuando().getTime());
				    
					System.out.println(historico.getNomePessoa() + " " + historico.getTituloLivro()+ " "+historico.getQuantidade()+" "+Data);
				} catch(EntityNotFoundException e) {
					System.out.println("Historico não encontrado!");
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
