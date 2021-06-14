package ltda.corporation.hugo.health.service;

import ltda.corporation.hugo.health.entity.Venda;

public class VendaService {

	private Venda venda;

	public VendaService(Venda venda) {
		this.venda = venda;
	}

	public void pagar(FormaPagamento formaPagamento, double valorEmDinheiro) {
		double saldoComDesconto = 0;

		switch (formaPagamento) {
		case DEBITO:
			if (this.venda.getPaciente().getNumeroCartao() == null) {
//				System.out.println("Paciente sem cart�o de debito! Escolha outra op��p ou adicione um novo cart�o");
			} else {
				saldoComDesconto = this.venda.getPaciente().getSaldo() - (this.venda.getPaciente().getSaldo() * 0.10);
//				System.out.println("Valor a ser pago R$" + saldoComDesconto + ".");

				this.venda.getPaciente().setSaldo(0);
//				System.out.println("Desconto de 5% no cart�o: " + this.venda.getPaciente().getNumeroCartao() + "\n"
//						+ "Pagou R$" + saldoComDesconto + ". Obrigado!");
			}
			break;

		case CREDITO:
			if (this.venda.getPaciente().getNumeroCartao() == null) {
				// System.out.println("Paciente sem cart�o de cr�dito! Escolha outra op��p ou
				// adicione um novo cart�o");
			} else {
//				System.out.println("Valor a ser pago R$" + this.venda.getPaciente().getSaldo() + " no cart�o: "
//						+ this.venda.getPaciente().getNumeroCartao() + ". Obrigado!");
				this.venda.getPaciente().setSaldo(0);
			}
			break;

		case DINHEIRO:
			saldoComDesconto = this.venda.getPaciente().getSaldo() - (this.venda.getPaciente().getSaldo() * 0.10);
//			System.out.println("Valor a ser pago R$" + saldoComDesconto + ".");

			if (valorEmDinheiro > saldoComDesconto) {
				this.venda.getPaciente().setSaldo(0);
//				System.out.println("Desconto de 10% :)" + "\n" + "Troco de R$" + (valorEmDinheiro - saldoComDesconto)
//						+ ". Obrigado!");
			}

			else if (valorEmDinheiro < saldoComDesconto) {
				this.venda.getPaciente().setSaldo(this.venda.getPaciente().getSaldo() - valorEmDinheiro);
//				System.out.println("Sem descontos :(" + "\n" + "Faltam R$"
//						+ (this.venda.getPaciente().getSaldo() - valorEmDinheiro)
//						+ " para quitar sua divida. Obrigado!");
			} else {
				this.venda.getPaciente().setSaldo(0);
				System.out.println("Desconto de 10% :)" + "\n" + "Obrigado!");
			}

			break;
		}

	}

}
