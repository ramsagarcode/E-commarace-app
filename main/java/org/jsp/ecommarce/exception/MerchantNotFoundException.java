package org.jsp.ecommarce.exception;

public class MerchantNotFoundException extends RuntimeException {
	public String getMessage() {
		return "Merchant Not Found";

}
}