package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TipoSegurosDao;
import dominio.Seguro;
import dominio.TipoSeguros;
import dao.SeguroDao;

@WebServlet("/ServletSeguro")
public class ServletSeguro extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final TipoSegurosDao daoTS = new TipoSegurosDao();
	private final SeguroDao daoS = new SeguroDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pagina = request.getParameter("accion");

		if (pagina == null)
			pagina = "inicio";

		switch (pagina) {

		case "inicio":
			request.getRequestDispatcher("/Inicio.jsp").forward(request, response);
			break;

		case "agregar":
			request.setAttribute("listaTiposSeguros", daoTS.listarTipoSeguros());
			request.setAttribute("proximoId", daoS.obtenerProximoId());

			request.getRequestDispatcher("/AgregarSeguro.jsp").forward(request, response);
			break;

		case "listar":

			int idTipo = 0;

			if (request.getParameter("btnFiltrar") != null)
				idTipo = Integer.parseInt(request.getParameter("tipoSeguro"));

			request.setAttribute("listaTiposSeguros", daoTS.listarTipoSeguros());
			request.setAttribute("listaSeguros", daoS.listarSeguros(idTipo));

			request.getRequestDispatcher("/ListarSeguros.jsp").forward(request, response);
			break;

		default:
			request.getRequestDispatcher("/Inicio.jsp").forward(request, response);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pagina = request.getParameter("accion");

		if ("guardar".equals(pagina)) {

			String descripcion = request.getParameter("txtDescripcion");
			int idTipo = Integer.parseInt(request.getParameter("tipoSeguro"));

			String costoContratacionStr = request.getParameter("txtCostoContratacion");
			String costoAseguradoStr = request.getParameter("txtCostoMax");

			if (costoContratacionStr == "" || costoAseguradoStr == "") {
				request.setAttribute("mensaje", "Ingrese datos válidos");
			} else {

				try {
					double costoContratacion = Double.parseDouble(costoContratacionStr);
					double costoAsegurado = Double.parseDouble(costoAseguradoStr);

					if (!validarNumeros(costoContratacion) || !validarNumeros(costoAsegurado)) {
						request.setAttribute("mensaje", "Los costos deben ser valores mayores a 0");
					} else {
						TipoSeguros tipo = new TipoSeguros();
						tipo.setIdTipo(idTipo);

						Seguro seguro = new Seguro();

						seguro.setDescripcion(descripcion);
						seguro.setTipoSeguro(tipo);
						seguro.setCostoContratacion(costoContratacion);
						seguro.setCostoAsegurado(costoAsegurado);

						int filas = daoS.altaSeguro(seguro);

						if (filas > 0)
							request.setAttribute("mensaje", "Seguro agregado con éxito");
						else
							request.setAttribute("mensaje", "No se pudo agregar el seguro");
					}

				} catch (Exception e) {
					request.setAttribute("mensaje", "Los costos deben ser números positivos");
				}
			}

			request.setAttribute("listaTiposSeguros", daoTS.listarTipoSeguros());
			request.setAttribute("proximoId", daoS.obtenerProximoId());

			request.getRequestDispatcher("/AgregarSeguro.jsp").forward(request, response);
		}
	}

	private boolean validarNumeros(double valor) {
		if (valor > 0) {
			return true;
		} else {
			return false;
		}
	}
}