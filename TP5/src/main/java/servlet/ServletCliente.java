package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClienteDao;

@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final ClienteDao cliente = new ClienteDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!usuarioAutenticado(request)) {
			response.sendRedirect(request.getContextPath() + "/Login.jsp");
			return;
		}

		String pagina = request.getParameter("accion");

		if (pagina == null) {
			pagina = "agregar";
		}

		switch (pagina) {
		case "agregar":
			request.getRequestDispatcher("/WEB-INF/Vistas/AltaCliente.jsp").forward(request, response);
			break;

		case "listar":
			request.setAttribute("listaClientes", cliente.listarClientes());

			request.getRequestDispatcher("/WEB-INF/Vistas/ListadoClientes.jsp").forward(request, response);
			break;

		default:
			request.getRequestDispatcher("/WEB-INF/Vistas/AltaCliente.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private boolean usuarioAutenticado(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    return session != null && session.getAttribute("usuario") != null;
	}

}