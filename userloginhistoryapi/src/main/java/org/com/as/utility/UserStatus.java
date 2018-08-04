package org.com.as.utility;

public enum UserStatus {
	Basic(1), Pro(2), Corp(3);
	private final int value;

	private UserStatus(int value) {
		this.value = value;
	}

	public int toInteger() {
		return value;
	}
}
