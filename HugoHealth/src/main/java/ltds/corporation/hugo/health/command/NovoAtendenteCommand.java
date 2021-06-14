package ltds.corporation.hugo.health.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovoAtendenteCommand implements Command {

	private final String pagina = "WEB-INF/views/Atendente/cadastrar.jsp";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		return pagina;
	}

}
