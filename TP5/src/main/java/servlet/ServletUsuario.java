package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDao;

@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final UsuarioDao daoU = new UsuarioDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String usuario = request.getParameter("txtUsuario");
		String pass = request.getParameter("txtPassword");
		
		if (campoVacio(usuario) || campoVacio(pass)) {
			
			request.setAttribute("mensaje", "Debe ingresar usuario y contraseña");
			
		} else if (daoU.existeUsuario(usuario, pass)) {
			
			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuario", usuario);
			
			response.sendRedirect(request.getContextPath() + "/ServletCliente?accion=agregar");
			return;
				
		} else {
			
			request.setAttribute("mensaje", "Usuario o contraseña incorrectos");
		
		}
		
		request.setAttribute("usuarioIng", usuario);
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
			
	}
	
	private boolean campoVacio(String valor) {
		return valor == null || valor.trim().isEmpty();
	}
}