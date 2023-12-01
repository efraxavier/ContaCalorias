package principal;

import java.util.Scanner;

import controller.ConexaoDB;
public class MainDB {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConexaoDB conex = new ConexaoDB();
		
		Boolean exit = false;
		
		System.out.println("Bem vindo ao ContaCalorias.\n");
		
		while(!exit) {
			
			Scanner myObj = new Scanner(System.in);


			System.out.println("Insira a opção desejada:\n");
			
			System.out.println("0 - Registrar um novo usuário.");
			System.out.println("1 - Consultar Calorias Diárias.");
			System.out.println("2 - Registrar um novo alimento.");
			System.out.println("3 - Alterar sistema métrico.");
			System.out.println("4 - Excluir um registro.");
			System.out.println("5 - Exibir relatório do usuário.");
			System.out.println("6 - Sair...\n");

		int i = myObj.nextInt();  // Read user input
		
		switch (i) {
		case(0): {
			
			conex.RegistraUsuario();
			break;
		}case(1): {
			
			conex.ConsultaCalorias();
			break;
		}
		case(2): {
			conex.InsereAlimento();
			break;
		}
		case(3): {
			conex.AlteraMetrica();
			break;
		}
		case(4): {
			conex.ExcluiAlimento();
			break;
		}
		case(5): {
			conex.ImprimeRelatorio();
			break;
		}
		case(6): {
			System.out.println("\nスペースカウボーイに会いましょう");
			exit = true;
			break;
		}
		}
		}
		 
	}
}