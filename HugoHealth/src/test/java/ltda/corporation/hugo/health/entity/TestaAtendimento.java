package ltda.corporation.hugo.health.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ltda.corporation.hugo.health.service.laudoNuloException;

class TestaAtendimento {

	private Laudo laudo;
	private Paciente paciente;
	private Prontuario prontuario;
	private Exame exame;
	private Exame exame2;

	@BeforeEach
	public void givenCenario() {
		laudo = new Laudo("Wendel Willamys", "Pressão alta", "Febre Reumática, rinite, sinusite",
				"Eletro alterado, Inchasso de atrio ou ventriculo");
		exame = new Exame("ECG convencional", "Alterado", "27/05/2021", "14:00", 280);
		paciente = new Paciente("Wendel Willamys", 18, "Rua Sebastião Pae de Melo, nº 140", "(87) 9 8108-1538");
		exame2 = new Exame("ETT convencional", "Normal", "04/06/2021", "14:00", 280);
	}

	@Test
	public void prontuarioDeveTePacienteLaudo() {
		// WHEN
		prontuario = new Prontuario(paciente.getNome(), paciente, laudo, exame);
		// THEN
		assertNotNull(prontuario.getLaudo());
		assertNotNull(prontuario.getPaciente());
		assertEquals(prontuario.getPaciente().getNome(), prontuario.getLaudo().getNome());
	}

	@Test
	public void devePoderAddNovosExames() {
		// WHEN
		prontuario = new Prontuario(paciente.getNome(), paciente, laudo);
		prontuario.addNewExame(exame);
		prontuario.addNewExame(exame2);

		// THEN
		assertTrue(2 >= prontuario.getExames().size());
	}

	@Test
	public void naoDeveFinalizarAtendimentoComDiagnosticoFinalNulo() {
		// GIVEN
		prontuario = new Prontuario(paciente.getNome(), paciente, laudo);
		prontuario.addNewExame(exame);
		prontuario.addNewExame(exame2);
		// AND
		var historico = prontuario.getHistorico();

		// THEN
		assertThrows(laudoNuloException.class, () -> prontuario.finalizarAtendimento("07/06/2021"));
		assertTrue(historico == prontuario.getHistorico());

	}

}
