package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
			req.setAttribute("tiposSeguro", daoTS.listarTipoSeguros());
			req.setAttribute("proximoId", daoS.obtenerProximoId());
			rd = req.getRequestDispatcher("/AgregarSeguro.jsp");
			rd.forward(req, resp);
			break;
		case "listar":
			req.setAttribute("tiposSeguro", daoTS.listarTipoSeguros());
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
		
		String accion = req.getParameter("accion");
		
		if ("guardar".equals(accion))
		{
			
			String descripcion = req.getParameter("txtDescripcion");
			
			int idTipo =Integer.parseInt(req.getParameter("tipoSeguro"));
			
			double costoContratacion = Double.parseDouble(req.getParameter("txtCostoContratacion"));
			
			double costoAsegurado = Double.parseDouble((req.getParameter("txtCostoMax")));
			
			TipoSeguros tipo = new TipoSeguros();
			tipo.setIdTipo(idTipo);
			
			Seguro seguro = new Seguro();
			
			seguro.setDescripcion(descripcion);
			seguro.setTipoSeguro(tipo);
			seguro.setCostoContratacion(costoContratacion);
			seguro.setCostoAsegurado(costoAsegurado);
			
			int filas = daoS.altaSeguro(seguro);
			
			if (filas > 0) 
			{
				req.setAttribute("mensaje", "Seguro agregado con éxito");
				
			}else {
				req.setAttribute("mensaje", "No se pudo agregar el seguro");
			}
			
			req.setAttribute("tiposSeguro", daoTS.listarTipoSeguros());
			req.setAttribute("proximoId", daoS.obtenerProximoId());
			
			RequestDispatcher rd = req.getRequestDispatcher("/AgregarSeguro.jsp");
			
			rd.forward(req, resp);
						
			
		}
	}
	
}
