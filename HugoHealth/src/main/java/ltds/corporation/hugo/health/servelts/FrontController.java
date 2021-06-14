package ltds.corporation.hugo.health.servelts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ltda.corporation.hugo.health.entity.Atendente;
import ltds.corporation.hugo.health.command.CadastrarAtendenteCommand;
import ltds.corporation.hugo.health.command.NovoAtendenteCommand;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Atendente> atendentes = new ArrayList<>();

	public FrontController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		var acao = request.getParameter("action");
		var pagina = "index.html";
		
		if (acao.equals("novo_atendente")) {
			pagina = new NovoAtendenteCommand().execute(request, response);
		}
		
		if (acao.equals("cadastrar_atendente")) {
			pagina = new CadastrarAtendenteCommand().execute(request, response);
		}
		
		request.getRequestDispatcher(pagina).forward(request, response);
	}

}
