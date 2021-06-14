package ltda.corporation.hugo.health.entity;

public class Laudo {

	private String justificativa;
	private String doencasAssociadas;
	private String hipoteseDiagnostico;
	private String diagnosticoFinal;
	private String nome;

	public Laudo(String nome, String justificativa, String doencasAssociadas, String hipoteseDiagnostico) {
		this.nome = nome;
		this.justificativa = justificativa;
		this.doencasAssociadas = doencasAssociadas;
		this.hipoteseDiagnostico = hipoteseDiagnostico;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public String getDoencasAssociadas() {
		return doencasAssociadas;
	}

	public void setDoencasAssociadas(String doencasAssociadas) {
		this.doencasAssociadas = doencasAssociadas;
	}

	public String getHipoteseDiagnostico() {
		return hipoteseDiagnostico;
	}

	public void setHipoteseDiagnostico(String hipoteseDiagnostico) {
		this.hipoteseDiagnostico = hipoteseDiagnostico;
	}

	public String getDiagnosticoFinal() {
		return diagnosticoFinal;
	}

	public void setDiagnosticoFinal(String diagnosticoFinal) {
		this.diagnosticoFinal = diagnosticoFinal;
	}

	public String getNome() {
		return nome;
	}

	public void getNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diagnosticoFinal == null) ? 0 : diagnosticoFinal.hashCode());
		result = prime * result + ((doencasAssociadas == null) ? 0 : doencasAssociadas.hashCode());
		result = prime * result + ((hipoteseDiagnostico == null) ? 0 : hipoteseDiagnostico.hashCode());
		result = prime * result + ((justificativa == null) ? 0 : justificativa.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Laudo other = (Laudo) obj;
		if (diagnosticoFinal == null) {
			if (other.diagnosticoFinal != null)
				return false;
		} else if (!diagnosticoFinal.equals(other.diagnosticoFinal))
			return false;
		if (doencasAssociadas == null) {
			if (other.doencasAssociadas != null)
				return false;
		} else if (!doencasAssociadas.equals(other.doencasAssociadas))
			return false;
		if (hipoteseDiagnostico == null) {
			if (other.hipoteseDiagnostico != null)
				return false;
		} else if (!hipoteseDiagnostico.equals(other.hipoteseDiagnostico))
			return false;
		if (justificativa == null) {
			if (other.justificativa != null)
				return false;
		} else if (!justificativa.equals(other.justificativa))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Laudo [justificativa=" + justificativa + ", doencasAssociadas=" + doencasAssociadas
				+ ", hipoteseDiagnostico=" + hipoteseDiagnostico + ", diagnosticoFinal=" + diagnosticoFinal + ", nome="
				+ nome + "]";
	}

}
