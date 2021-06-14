package ltda.corporation.hugo.health.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ltda.corporation.hugo.health.service.laudoNuloException;

public class Prontuario {

	private Paciente paciente;
	private Laudo laudo;
	private List<Exame> exames = new ArrayList<>();
	private String nome;
	private String historico = "";

	public Prontuario(String nome, Paciente paciente, Laudo laudo) {
		this.nome = nome;
		this.paciente = paciente;
		this.laudo = laudo;
	}

	public Prontuario(String nome, Paciente paciente, Laudo laudo, Exame exame) {
		this.nome = nome;
		this.paciente = paciente;
		this.laudo = laudo;
		this.exames.add(exame);
	}

	public void finalizarAtendimento(String data) throws laudoNuloException {
		if (this.laudo.getDiagnosticoFinal() != null) {
			String historico = "\n------------------- " + data + " ------------------- \n";
			historico += "\nPaciente: " + this.laudo.getNome();
			historico += "\nQueixa: " + this.laudo.getJustificativa();
			historico += "\nDoenças Associadas: " + this.laudo.getDoencasAssociadas();
			historico += "\nHipótese diagnóstica: " + this.laudo.getHipoteseDiagnostico();

			historico += "\n\n-------> Exames";

			for (Exame exame : exames) {
				historico += "\n\n || Nome: " + exame.getNome();
				historico += "\n || Data: " + exame.getData() + " " + exame.getHora();
				historico += "\n || Resultado: " + exame.getResultado();
			}

			historico += "\n\n-------> Diagnóstico final";

			historico += "\n\n  ||  " + this.laudo.getDiagnosticoFinal() + "  || ";

			this.historico += historico;
			this.laudo = null;
			this.exames = null;
			this.exames = new ArrayList<>();

		} else
			throw new laudoNuloException("Diagnóstico final nulo! Favor relatar se esta indefinido ou conslusivo");

	}

	public void addNewExame(Exame exame) {
		this.exames.add(exame);
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public Laudo getLaudo() {
		return laudo;
	}

	public List<Exame> getExames() {
		return Collections.unmodifiableList(this.exames);
	}

	public String getNome() {
		return nome;
	}

	public void getNome(String nome) {
		this.nome = nome;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exames == null) ? 0 : exames.hashCode());
		result = prime * result + ((historico == null) ? 0 : historico.hashCode());
		result = prime * result + ((laudo == null) ? 0 : laudo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
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
		Prontuario other = (Prontuario) obj;
		if (exames == null) {
			if (other.exames != null)
				return false;
		} else if (!exames.equals(other.exames))
			return false;
		if (historico == null) {
			if (other.historico != null)
				return false;
		} else if (!historico.equals(other.historico))
			return false;
		if (laudo == null) {
			if (other.laudo != null)
				return false;
		} else if (!laudo.equals(other.laudo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prontuario [paciente=" + paciente + ", laudo=" + laudo + ", exames=" + exames + ", nome=" + nome
				+ ", historico=" + historico + "]";
	}

}
