package br.com.fiap.main.outros;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.persistence.EntityManager;
import br.com.fiap.dao.BoxDao;
import br.com.fiap.dao.implement.BoxDaoImplement;
import br.com.fiap.entidades.Box;
import br.com.fiap.entidades.Local;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.singleton.EMFS;

public class MainBox {

	public static void main(String[] args) {
		
		//Entity Manager
		EntityManager em = EMFS.getInstance().createEntityManager();
		
		//UsuarioDao
		BoxDao dao = new BoxDaoImplement(em);
		
		//Criacao scanner
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("\nMenu CTT Java Database\n1-Cadastrar box\n2-Consultar box");
	
		try {
			int escolha = scanner.nextInt();  // Read user input

			if (escolha == 1){
				//Local Dao
				Local local = new Local("Sao Paulo", "Linha Azul","Catraca da direita");
				
				//As outras informacoes do box
				Box box = new Box("Sao Paulo", 3, local);
				
				//Cadastrar
				try {
					dao.insert(box);
					dao.commit();
					System.out.println("Box cadastrado!\nO id do box é: "+box.getCodigo()+"\n");
				} catch (CommitException e) {
					System.out.println(e.getMessage()); 
				}
				
			}else if (escolha == 2) {
				//Pesquisar dados
				Box box = new Box();
				try {

					System.out.println("Digite o ID do box: ");
					int IdBox = scanner.nextInt();  // Read user input
					
					box = dao.findById(IdBox);
				    
					System.out.println(box.getEstado() + " " + box.getQuantidade());
				} catch(EntityNotFoundException e) {
					System.out.println("Box não encontrado!");
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
