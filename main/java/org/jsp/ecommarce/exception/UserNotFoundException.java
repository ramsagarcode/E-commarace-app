package org.jsp.ecommarce.exception;

public class UserNotFoundException extends RuntimeException {
	@Override
	public String getMessage() {
		return "User Not Found";

}
}