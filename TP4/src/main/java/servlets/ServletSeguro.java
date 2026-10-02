package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletSeguro")
public class ServletSeguro extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pagina = req.getParameter("accion");

		if (pagina == null) {
			pagina = "inicio";
		}

		switch (pagina) {
		case "inicio":
			RequestDispatcher rd = req.getRequestDispatcher("/Inicio.jsp");
			rd.forward(req, resp);
			break;
		case "agregar":
			rd = req.getRequestDispatcher("/AgregarSeguro.jsp");
			rd.forward(req, resp);
			break;
		case "listar":
			rd = req.getRequestDispatcher("/ListadoSeguros.jsp");
			rd.forward(req, resp);
			break;
		default:
			rd = req.getRequestDispatcher("/Inicio.jsp");
			rd.forward(req, resp);
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
}
