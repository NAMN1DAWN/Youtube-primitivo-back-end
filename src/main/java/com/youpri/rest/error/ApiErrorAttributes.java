package com.youpri.rest.error;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

public class ApiErrorAttributes extends DefaultErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
		Map<String, Object> allErrorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);

		Map<String, Object> errorAttributes = new HashMap<>();
		int statusCode = (int) allErrorAttributes.get("status");
		errorAttributes.put("estado", HttpStatus.valueOf(statusCode));
		errorAttributes.put("fecha", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

		String mensaje = "";
		
		Throwable throwable = getError(webRequest);
		
		if (throwable instanceof ResponseStatusException) {
			ResponseStatusException responseStatusException = (ResponseStatusException) throwable;
			mensaje = responseStatusException.getReason() == null ? "" : responseStatusException.getReason(); 
		} else {
			if (throwable.getCause() != null)
				mensaje = throwable.getCause().getMessage() == null ? throwable.getCause().toString() : throwable.getCause().getMessage();
			else
				mensaje = throwable.toString();
		}
		
		errorAttributes.put("mensaje", mensaje);
		
		return errorAttributes;
	}

}
