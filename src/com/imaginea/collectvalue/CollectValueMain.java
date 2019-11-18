package com.imaginea.collectvalue;

import java.io.IOException;

import com.imaginea.collectvalue.auth.AuthHeader;
import com.imaginea.collectvalue.auth.AuthType;
import com.imaginea.collectvalue.response.ApiClient;
import com.imaginea.collectvalue.response.RestApiClient;

public class CollectValueMain {

	public static void main(String[] args) throws IOException {

		String url = "https://jsonplaceholder.typicode.com/todos/1";

		ApiClient client = new RestApiClient();

		client.getResponse(url, AuthHeader.constructAuthHeaderValue(AuthType.BASIC_AUTH, "guru:passw0rd"));

	}
}
