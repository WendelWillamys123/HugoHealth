package ltds.corporation.hugo.health.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ltda.corporation.hugo.health.entity.Atendente;

public class CadastrarAtendenteCommand implements Command {

	private final String pagina = "/WEB-INF/views/Atendente/listar.jsp";
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		 
		 String nome = request.getParameter("nome");
		 int idade = Integer.parseInt(request.getParameter("idade"));
		 String matricula = request.getParameter("matricula");
		 double salario = Double.parseDouble(request.getParameter("salario"));
		 request.setAttribute("atendentes", List.of(new Atendente(nome, idade, matricula, salario, 0)));
		 
		return pagina;
	}

}
