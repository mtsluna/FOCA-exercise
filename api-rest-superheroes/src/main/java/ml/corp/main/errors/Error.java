package ml.corp.main.errors;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Error {

	public static ResponseEntity<Object> getErrorMessage(String message) {
		
		HashMap<String, Object> responseError = new HashMap<String, Object>();
		HashMap<String, Object> responseMessage = new HashMap<String, Object>();
		responseMessage.put("code", 404);
		responseMessage.put("message", message);
		responseError.put("error", responseMessage);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseError);
		
	}
	
}
