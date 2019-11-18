package com.imaginea.collectvalue.auth;

import java.util.Base64;

import com.imaginea.collectvalue.constants.CollectValueConstants;

public class AuthHeader {

	public static String constructAuthHeaderValue(AuthType authType, String credentials) {

		String authHeaderValue = "";
		if (AuthType.BASIC_AUTH.equals(authType)) {
			authHeaderValue = CollectValueConstants.BASIC_AUTH_PREFIX
					+ Base64.getEncoder().encodeToString(credentials.getBytes());
		}
		return authHeaderValue;
	}

}
