package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClienteDao;
import entidad.Cliente;

@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
	private final ClienteDao cliente = new ClienteDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		if (!usuarioAutenticado(request)) {
	        response.sendRedirect(request.getContextPath() + "/Login.jsp");
	        return;
	    }

	    request.setCharacterEncoding("UTF-8");

	    String accion = request.getParameter("accion");

	    if ("guardar".equals(accion)) {

	        String dni = request.getParameter("txtDni");
	        String cuil = request.getParameter("txtCuil");
	        String nombre = request.getParameter("txtNombre");
	        String apellido = request.getParameter("txtApellido");
	        String sexo = request.getParameter("ddlSexo");
	        String fecha = request.getParameter("txtFecha");
	        String direccion = request.getParameter("txtDireccion");
	        String nacionalidad = request.getParameter("txtNacionalidad");
	        String localidad = request.getParameter("txtLocalidad");
	        String provincia = request.getParameter("txtProvincia");
	        String correo = request.getParameter("txtCorreo");
	        String telefono = request.getParameter("txtTelefono");

	        Cliente nuevoCliente = new Cliente(
	                dni,
	                cuil,
	                nombre,
	                apellido,
	                sexo,
	                fecha,
	                direccion,
	                nacionalidad,
	                localidad,
	                provincia,
	                correo,
	                telefono
	        );

	        int filas = cliente.altaCliente(nuevoCliente);

	        if (filas > 0) {
	            request.setAttribute("mensaje", "Cliente agregado correctamente");
	        } else {
	            request.setAttribute("mensaje", "No se pudo agregar el cliente");
	        }

	        request.getRequestDispatcher("/WEB-INF/Vistas/AltaCliente.jsp")
	               .forward(request, response);
	    }		
	}
	
	private boolean usuarioAutenticado(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    return session != null && session.getAttribute("usuario") != null;
	}
	
}