package ltda.corporation.hugo.health.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ltda.corporation.hugo.health.service.FormaPagamento;
import ltda.corporation.hugo.health.service.VendaService;

class TestaVenda {

	private VendaService vendaService;
	private Medico medico;
	private Atendente atendente;
	private Paciente paciente;
	private Consulta consulta;
	private Venda venda;
	private Exame exame;

	@BeforeEach
	public void givenCenario() {
		// GIVEN
		medico = new Medico("Rafaela Tavares", 29, 7000.00, "154236/PE");
		atendente = new Atendente("Rafaela Tavares", 29, "20181D134855", 1500.00, 0);
		paciente = new Paciente("Wendel Willamys", 18, "Rua Sebastião Pae de Melo, nº 140", "(87) 9 8108-1538");
		consulta = new Consulta(atendente, medico, paciente, "27/05/2021", "14:15", 250.00);
		exame = new Exame("ECG convencional", "Alterado", "27/05/2021", "14:00", 280);
	}
	@Test
	public void totalVenda() {
		venda = new Venda(consulta);
		venda.addNewExame(exame);
		//THEN
		assertEquals(530.00, venda.valorTotal());
	}

	@Test
	public void adicionaValorDaConsultaNaContaPaciente() {
		// WHEN
		venda = new Venda(consulta);
		venda.addNewExame(exame);
		venda.finalizar();
		//THEN
		assertEquals(530.0, this.paciente.getSaldo());
	}

	@Test
	public void pagarSaldoDePaciente() {
		// WHEN
		venda = new Venda(consulta);
		venda.addNewExame(exame);
		vendaService = new VendaService(venda);
		venda.finalizar();
		// AND
		vendaService.pagar(FormaPagamento.DINHEIRO, 720.00);
		// THEN
		assertEquals(0, this.paciente.getSaldo());
	}
}
