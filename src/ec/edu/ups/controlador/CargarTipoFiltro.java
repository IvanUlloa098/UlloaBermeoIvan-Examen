package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TipoTelefonoDAO;
import ec.edu.ups.entidad.TipoTelefono;

/**
 * Servlet Filter implementation class CargarTipoFiltro
 */
@WebFilter({"/CargarTipoFiltro", "/JSP/index.jsp", "/JSP/ingresar_usuario.jsp", "/JSP/ingresar_telefono.jsp"})
public class CargarTipoFiltro implements Filter {

	private TipoTelefonoDAO tipDAO;
    /**
     * Default constructor. 
     */
    public CargarTipoFiltro() {
    	try {	
	        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        tipDAO = DAOFactory.getFactory().getTipoTelefonoDAO();
	        
	    } catch (Exception ex) {
	        System.out.println("NO");
	    }
    	
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		TipoTelefono tt;
		
		try {
			if (session.getAttribute("tipo").equals("carga")) {
				System.out.println("1");	
				
				chain.doFilter(request, response);
				
			} 
		} catch (Exception e) {
			System.out.println("2");
			tt = new TipoTelefono("CELULAR");
			tipDAO.create(tt);
			tt = new TipoTelefono("CONVENCIONAL");
			tipDAO.create(tt);
			
			session.setAttribute("tipo", "carga");
			chain.doFilter(request, response);
			
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
