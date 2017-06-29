package org.vaadin.johannest.diagnosticservlet;

import com.vaadin.server.DeploymentConfiguration;
import com.vaadin.server.ServiceException;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinServletService;
import com.vaadin.server.VaadinSession;

public class DiagnosticAndTestServletService extends VaadinServletService {
	private static final long serialVersionUID = -5874716650679865909L;

	public DiagnosticAndTestServletService(VaadinServlet servlet,
			DeploymentConfiguration deploymentConfiguration)
			throws ServiceException {
		super(servlet, deploymentConfiguration);
	}

	@Override
	protected VaadinSession createVaadinSession(VaadinRequest request)
			throws ServiceException {
		return new DiagnosticAndTestServletSession(this);
	}
}