package org.jsp.ecommarce.exception;

public class InvalidCredentialException extends RuntimeException  {
	@Override
	public String getMessage() {
		return "Invalid Credential";


}
}
