package ltda.corporation.hugo.health.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Venda {

	private List<Consulta> consultas = new ArrayList<>();
	private List<Exame> exames = new ArrayList<>();
	private Paciente paciente;
	private double valorTotal;

	public Venda(Consulta consulta, Exame exame) {
		this.paciente = consulta.getPaciente();
		this.consultas.add(consulta);
		this.exames.add(exame);
	}

	public Venda(Consulta consulta) {
		this.paciente = consulta.getPaciente();
		this.consultas.add(consulta);
	}

	public Venda(Exame exame, Paciente paciente) {
		this.paciente = paciente;
		this.exames.add(exame);
	}

	public double valorTotal() {
		double valor = 0;
		
		for (Consulta consulta : consultas) {
			valor += consulta.getValor();
		}

		for (Exame exame : exames) {
			valor += exame.getValor();
		}

		return valor;
	}

	public void finalizar() {
		for (Consulta consulta : consultas) {
			this.valorTotal += consulta.getValor();
		}
		
		for (Exame exame : exames) {
			this.valorTotal += exame.getValor();
		}
		var valor = this.paciente.getSaldo()+valorTotal;
		this.paciente.setSaldo(valor);
		this.consultas = null;
		this.exames = null;
	}
	
	public void addNewConsulta(Consulta consulta) {
		this.consultas.add(consulta);
	}
	
	public void addNewExame(Exame exame) {
		this.exames.add(exame);
	}

	public List<Consulta> getConsultas() {
		return Collections.unmodifiableList(this.consultas);
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public List<Exame> getExames() {
		return Collections.unmodifiableList(this.exames);
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	
}
