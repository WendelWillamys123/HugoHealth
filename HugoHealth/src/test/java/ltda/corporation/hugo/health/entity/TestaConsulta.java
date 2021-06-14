package ltda.corporation.hugo.health.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestaConsulta {

	private Paciente paciente;
	private Consulta consulta;
	private Medico medico;
	private Atendente atendente;

	@BeforeEach
	public void givenCenario() {
		// GIVEN
		medico = new Medico("Rafaela Tavares", 29, 7000.00, "154236/PE");
		atendente = new Atendente("Rafaela Tavares", 29, "20181D134855", 1500.00, 0);
		paciente = new Paciente("Wendel Willamys", 18, "Rua Sebastião Pae de Melo, nº 140", "(87) 9 8108-1538");

	}

	@Test
	public void consultaDeveTerMedicoPaciente() {
		// WHEN
		consulta = new Consulta(atendente, medico, paciente, "27/05/2021", "14:00", 250.00);
		atendente.marcarConsulta();

		// THEN
		assertNotNull(consulta.getMedico());
		assertNotNull(consulta.getPaciente());
		assertEquals("Rafaela Tavares", consulta.getMedico().getNome());
		assertEquals("Wendel Willamys", consulta.getPaciente().getNome());
	}

}
