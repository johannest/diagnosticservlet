package org.vaadin.johannest.diagnosticservlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.atmosphere.config.service.AtmosphereInterceptorService;
import org.atmosphere.cpr.Action;
import org.atmosphere.cpr.AtmosphereConfig;
import org.atmosphere.cpr.AtmosphereInterceptor;
import org.atmosphere.cpr.AtmosphereResource;

@AtmosphereInterceptorService
public class DiagnosticInterceptor implements AtmosphereInterceptor {

	private static final String LINE_END = "\n";
	private static final String PAUSE_PREFIX = "%%%pause";
	private static Map<Date,String> requestMap = new HashMap<Date, String>(); 
	
	public DiagnosticInterceptor() {
	}
	
	@Override
	public void configure(AtmosphereConfig config) {
	}
	

	@Override
	public Action inspect(AtmosphereResource r) {
		Logger.getLogger(DiagnosticInterceptor.class.getName()).info(r.getRequest().body().asString());
		requestMap.put(new Date(), r.getRequest().body().asString());
		return Action.CONTINUE;
	}

	@Override
	public void postInspect(AtmosphereResource r) {
	}
	
	public static void clearRecordedRequests() {
		requestMap.clear();
	}
	
	public static String getRecordedRequesWithPauses() {
		StringBuilder sb = new StringBuilder();
		List<Date> keyList = new ArrayList<Date>();
		keyList.addAll(requestMap.keySet());
		java.util.Collections.sort(keyList);
		
		Date prevKey = null;
		for (Date key : keyList) {
			if (prevKey!=null) {
				sb.append(PAUSE_PREFIX);
				sb.append(key.getTime()-prevKey.getTime());
				sb.append(LINE_END);
			}
			sb.append(requestMap.get(key));
			sb.append(LINE_END);
			prevKey = key;
		}
		return sb.toString();
	}

}
