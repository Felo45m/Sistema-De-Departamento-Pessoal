package application;

import java.util.Scanner;

import entities.DepartamentoPessoal;


public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
						
		DepartamentoPessoal departamentoPessoal = new DepartamentoPessoal();
		 
		int opcao = -1;
		
		do {
			System.out.println("===========================================");
			System.out.println("======SISTEMA DE DEPARTAMENTO PESSOAL======");
			System.out.println("===========================================");
			System.out.println("========== Escolha uma opção: =============");
			System.out.println("======== 1 - Cadastrar funcionário ========");
			System.out.println("======== 2 - Listar funcionário    ========");
			System.out.println("======== 3 - Buscar funcionário    ========");
			System.out.println("======== 4 - Detalhar funcionário  ========");
			System.out.println("======== 5 - Excluir funcionário   ========");
			System.out.println("======== 6 - Editar status         ========");
			System.out.println("======== 0 - Sair                  ========");
			System.out.println("===========================================");
			System.out.println("Opção: ");
			opcao = sc.nextInt();
			sc.nextLine();
			
			switch (opcao) {
            case 1:
                departamentoPessoal.cadastrarFuncionario();
                break;
            case 2:
                departamentoPessoal.listarFuncionarios(1);
                break;
            case 3:
                departamentoPessoal.buscarFuncionario();
                break;
            case 4:
                departamentoPessoal.detalharFuncionario();
                break;
            case 5:
                departamentoPessoal.excluirFuncionario();
                break;
            case 6:
                departamentoPessoal.editarStatus();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
			}
		} while (opcao != 0);
		
		
		sc.close();
	}

}
