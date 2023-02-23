package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartamentoPessoal {
    private List<Funcionario> funcionarios;
    private Scanner sc;

    public DepartamentoPessoal() {
        this.funcionarios = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }
	
	public void cadastrarFuncionario() {
		System.out.println("=== Cadastro de funcionários ===");
		int id = gerarId();
		System.out.println("Nome: ");
		String nome = sc.nextLine();
		System.out.println("Endereço: (Rua, Bairro, Cidade): ");
		String endereco = sc.nextLine();
		System.out.println("Cargo: ");
		String cargo = sc.nextLine();
		System.out.println("Sexo: ");
		String sexo = sc.nextLine();
		System.out.println("Idade: ");
		int idade = sc.nextInt();
		sc.nextLine();
		Funcionario funcionario = new Funcionario(id, nome, endereco, cargo, sexo, idade);
		funcionarios.add(funcionario);
		System.out.println("Funcionário cadastrado com sucesso!");
	}
	
	private int gerarId() {
		if (funcionarios.isEmpty()) {
			return 1;
		}
		return funcionarios.get(funcionarios.size() - 1). getId() + 1;
	}
	
	public void listarFuncionarios(int paginaAtual) {
		int numPaginas = (int) Math.ceil(funcionarios.size() / 10.0);
		int startIndex = (paginaAtual - 1) * 10;
		int endIndex = Math.min(startIndex + 10, funcionarios.size());
		System.out.printf("=== Lista de Funcionários (Página %d/%d) ====\n", paginaAtual, numPaginas);
		System.out.printf("%-10s %-20s %-15s\n", "Identificador", "Nome", "Status");
		for (int i = startIndex; i < endIndex; i++) {
			Funcionario funcionario = funcionarios.get(i);
			System.out.printf("%-10d %-20s %-15s\n", funcionario.getId(), funcionario.getNome(), funcionario.getStatus());
		}
		if (paginaAtual < numPaginas) {
			System.out.println("Pressione Enter para ir para a próxima página.");
			sc.nextLine();
			listarFuncionarios(paginaAtual + 1);
		}
	}
	
	public void buscarFuncionario() {
		System.out.println("Digite o termo de busca: ");
		String termo = sc.nextLine();
		List<Funcionario> resultados = new ArrayList<>();
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getNome().contains(termo) || funcionario.getEndereco().contains(termo) || funcionario.getCargo().contains(termo) || 
					funcionario.getSexo().contains(termo)) {
				resultados.add(funcionario);
			}
		}
		if (resultados.isEmpty()) {
			System.out.println("Nenhum resultado encontrado.");
		} else {
			System.out.printf("=== Resultados da busca por '%s' ====\n", termo);
			System.out.printf("%-10s %-20s %-15s\n", "Identificador", "Nome", "Status");
			for (Funcionario funcionario : resultados) {
				System.out.printf("%-10d %-20s %-15s\n", funcionario.getId(), funcionario.getNome(), funcionario.getStatus());
			}
		}
	}
	
	public void detalharFuncionario() {
		System.out.println("Digite o identificador do funcionário: ");
		int id = sc.nextInt();
		sc.nextLine();
		Funcionario funcionario = buscarFuncionarioPorId(id);
		if (funcionario == null) {
			System.out.println("Funcionário não encontrado.");
		} else {
			System.out.println("=== Detalhes do funcionário ===");
			System.out.println("Identificador: " + funcionario.getId());
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Endereço: " + funcionario.getEndereco());
			System.out.println("Cargo: " + funcionario.getCargo());
			System.out.println("Sexo: " + funcionario.getSexo());
			System.out.println("Idade: " + funcionario.getIdade());
			System.out.println("Status: " + funcionario.getStatus());
		}
	}
	
	public void excluirFuncionario() {
		System.out.println("Digite o identificador do funcionario que deseja excluir");
		int id = sc.nextInt();
		sc.nextLine();
		Funcionario funcionario = buscarFuncionarioPorId(id);
		if (funcionario == null) {
			System.out.println("Funcionário não encontrado.");
		} else {
			funcionarios.remove(funcionario);
			System.out.println("Funcionario removido com sucesso!");
		}
	}
	
	public void editarStatus() {
		System.out.println("Digite o identificador do funcionário: ");
		int id = sc.nextInt();
		sc.nextLine();
		Funcionario funcionario = buscarFuncionarioPorId(id);
		if (funcionario == null) {
			System.out.println("Funcionário não encontrado");
		} else {
			System.out.printf("Status atual: %s\n", funcionario.getStatus());
			System.out.println("Digite o novo status (EM_TREINAMENTO, CONTRATADO ou QUASE_DEMITIDO): ");
			String novoStatus = sc.nextLine();
			if (novoStatus.equals("EM_TREINAMENTO") || novoStatus.equals("CONTRATADO") || novoStatus.equals("QUASE_DEMITIDO")) {
				funcionario.setStatus(novoStatus);
				System.out.println("Status atualizado com sucesso!");
			} else {
				System.out.println("Status inválido.");
			}
		}
	}
	
	private Funcionario buscarFuncionarioPorId(int id) {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getId() == id) {
				return funcionario;
			}
		}
		return null;
	}
}












