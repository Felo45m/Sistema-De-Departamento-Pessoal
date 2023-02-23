package entities;

public class Funcionario {
	
	private int id;
	private String nome;
	private String endereco;
	private String cargo;
	private String sexo;
	private int idade;
	private String status;
	
	public Funcionario(int id, String nome, String endereco, String cargo, String sexo, int idade) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cargo = cargo;
		this.sexo = sexo;
		this.idade = idade;
		this.status = "EM_TREINAMENTO";
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
