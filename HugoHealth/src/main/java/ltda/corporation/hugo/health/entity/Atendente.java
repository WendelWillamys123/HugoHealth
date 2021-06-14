package ltda.corporation.hugo.health.entity;

public class Atendente {

	private int consultasMarcadas;
	private String nome;
	private int idade;
	private String matricula;
	private double salario;

	public Atendente(String nome, int idade, String matricula, double salario, int consultasMarcadas) {
		this.nome = nome;
		this.idade = idade;
		this.matricula = matricula;
		this.salario = salario;
		this.consultasMarcadas = consultasMarcadas;

	}

	public int getConsultasMarcadas() {
		return consultasMarcadas;
	}

	public void setConsultasMarcadas(int consultasMarcadas) {
		this.consultasMarcadas = consultasMarcadas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + consultasMarcadas;
		result = prime * result + idade;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atendente other = (Atendente) obj;
		if (consultasMarcadas != other.consultasMarcadas)
			return false;
		if (idade != other.idade)
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(salario) != Double.doubleToLongBits(other.salario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atendente [consultasMarcadas=" + consultasMarcadas + ", nome=" + nome + ", idade=" + idade
				+ ", matricula=" + matricula + ", salario=" + salario + "]";
	}

	public void marcarConsulta() {
		this.consultasMarcadas += 1;
	}

}
