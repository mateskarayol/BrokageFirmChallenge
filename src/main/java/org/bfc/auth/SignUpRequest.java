package org.bfc.auth;

public record SignUpRequest(String username, String password, UserRole role) {

}
