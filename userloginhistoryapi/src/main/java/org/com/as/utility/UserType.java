package org.com.as.utility;


public enum UserType {
	Select(0),Omnitivity_Admin(1), Device_Admin(2);
	private final int value;
	
	private String userType;
	
	private UserType(int value) {
		this.value = value;
	}

	public int toInteger() {
		return value;
	}

	public String getUserType() {
		return userType;
	}	
}
