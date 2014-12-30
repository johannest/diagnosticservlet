package org.vaadin.johannest.diagnosticservlet;

import com.vaadin.server.ClientConnector;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Component;

public class DiagnosticAndTestServletSession extends VaadinSession {
	private static final long serialVersionUID = 4596901275146146127L;

	public DiagnosticAndTestServletSession(VaadinService service) {
		super(service);
	}

	@Override
	public String createConnectorId(ClientConnector connector) {
		if (connector instanceof Component) {
			Component component = (Component) connector;
			return component.getId() == null ? super
					.createConnectorId(connector) : component.getId();
		}
		return super.createConnectorId(connector);
	}
}