package org.vaadin.johannest.diagnosticservlet;

import java.util.logging.Logger;
import com.vaadin.server.DeploymentConfiguration;
import com.vaadin.server.ServiceException;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinServletService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Marcus Hellberg (marcus@vaadin.com) Further modified by Johannes
 *         Tuikkala (johannes@vaadin.com)
 */
public class DiagnosticAndTestServlet extends VaadinServlet {
	private static final long serialVersionUID = 898354532369443197L;
	
	public DiagnosticAndTestServlet() {
	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Logger.getLogger(DiagnosticAndTestServlet.class.getName()).finer(
				request.getRequestURI());

		super.service(request, response);
	}

	@Override
	protected VaadinServletService createServletService(
			DeploymentConfiguration deploymentConfiguration)
			throws ServiceException {
		DiagnosticAndTestServletService service = new DiagnosticAndTestServletService(this,
				deploymentConfiguration);
		service.init();
		return service;
	}
}
