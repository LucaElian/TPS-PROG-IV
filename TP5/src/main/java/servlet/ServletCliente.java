package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
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
	private final ClienteDao daoC = new ClienteDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (!usuarioAutenticado(request)) {
			response.sendRedirect(request.getContextPath() + "/Login.jsp");
			return;
		}

		String pagina = request.getParameter("accion");

		if (pagina == null)
			pagina = "agregar";

		switch (pagina) {
		
			case "agregar":
				request.getRequestDispatcher("/WEB-INF/Vistas/AltaCliente.jsp").forward(request, response);
				break;

			case "listar":
				request.setAttribute("listaClientes", daoC.listarClientes());
	
				request.getRequestDispatcher("/WEB-INF/Vistas/ListadoClientes.jsp").forward(request, response);
				break;

			default:
				request.getRequestDispatcher("/WEB-INF/Vistas/AltaCliente.jsp").forward(request, response);
				break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		if (!usuarioAutenticado(request)) {
			response.sendRedirect(request.getContextPath() + "/Login.jsp");
			return;
		}

		request.setCharacterEncoding("UTF-8");

		String accion = request.getParameter("accion");
		
		if (accion == null)
			accion = "";
		
		switch (accion) {
		
			case "guardar":
			
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
	
				Cliente cliente = new Cliente(dni, cuil, nombre, apellido, sexo, fecha, direccion, nacionalidad,
						localidad, provincia, correo, telefono);
				
				request.setAttribute("clienteIng", cliente);
				
				List<String> errores = validarCliente(cliente);
				
				if (!errores.isEmpty()) {
					
					request.setAttribute("errores", errores);
					
					request.getRequestDispatcher("/WEB-INF/Vistas/AltaCliente.jsp").forward(request, response);
					return;
				}
				
				int filas = daoC.altaCliente(cliente);
				
				if (filas > 0) {
					
					request.removeAttribute("clienteIng");
					request.setAttribute("mensaje", "Cliente agregado correctamente");
					
				} else
					request.setAttribute("mensaje", "No se pudo agregar el cliente");
				
				request.getRequestDispatcher("/WEB-INF/Vistas/AltaCliente.jsp").forward(request, response);
				break;
		}
	}

	private List<String> validarCliente(Cliente c) {

		List<String> errores = new ArrayList<>();
		
		String letras = "\\p{L}+(?: +\\p{L}+)*";
		
		validarCampo(errores, "DNI", c.getDni(), 8, "[0-9]{6,8}");
		if (daoC.existeDni(c.getDni())) 		errores.add("DNI: Ya existe un cliente con este DNI");
		
		validarCampo(errores, "CUIL", c.getCuil(), 11, "[0-9]{11}");
		if (daoC.existeCuil(c.getCuil()))		errores.add("CUIL: Ya existe un cliente con este CUIL");
		
		validarCampo(errores, "Nombre", c.getNombre(), 100, letras);
		validarCampo(errores, "Apellido", c.getApellido(), 100, letras);
		validarCampo(errores, "Sexo", c.getSexo(), 10, "M|F|Otro");
		validarCampo(errores, "Fecha de nacimiento", c.getFecha(), 10, "[0-9]{4}-[0-9]{2}-[0-9]{2}");
		validarCampo(errores, "Dirección", c.getDireccion(), 150, ".*[\\p{L}0-9].*");
		validarCampo(errores, "Nacionalidad", c.getNacionalidad(), 50, letras);
		validarCampo(errores, "Localidad", c.getLocalidad(), 50, letras);
		validarCampo(errores, "Provincia", c.getProvincia(), 50, letras);
		
		validarCampo(errores, "Correo electrónico", c.getCorreo(), 100, "[^\\s@]+@[^\\s@]+\\.[^\\s@]+");
		if (daoC.existeCorreo(c.getCorreo()))	errores.add("Correo electrónico: Ya existe un cliente con este correo electrónico");
		
		validarCampo(errores, "Teléfono", c.getTelefono(), 10, "[0-9]{10}");
		
		
		if (c.getFecha() != null && c.getFecha().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
			
			try {
				LocalDate nacimiento = LocalDate.parse(c.getFecha());
				
				if (nacimiento.isAfter(LocalDate.now()))
					errores.add("La fecha de nacimiento no puede ser futura");
				
				else if (nacimiento.getYear() < 1)
					errores.add("La fecha de nacimiento debe ser un año valido");
					
			} catch (DateTimeParseException e) {
				
				errores.add("Ingrese una fecha de nacimiento válida");
			
			}
		}
		
		return errores;
	}

	private void validarCampo(List<String> errores, String nombre, String valor, int maximo, String patron) {
		
		if (valor == null || valor.trim().isEmpty())
			errores.add(nombre + ": debe completar este campo");
		
		else if (valor.length() > maximo || !valor.matches(patron))
			errores.add(nombre + ": revise el formato y la longitud ingresados");

	}

	private boolean usuarioAutenticado(HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		return session != null && session.getAttribute("usuario") != null;
	}
}
