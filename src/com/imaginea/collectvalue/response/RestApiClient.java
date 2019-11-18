package com.imaginea.collectvalue.response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.imaginea.collectvalue.constants.CollectValueConstants;

public class RestApiClient implements ApiClient, CollectValueConstants {

	@Override
	public String getResponse(String apiUrl, String authHeaderValue) {
		String response = "";

		try {
			URL url = new URL(apiUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			if (authHeaderValue != null && !authHeaderValue.isEmpty() && !authHeaderValue.isBlank())
				con.setRequestProperty(HEADER_AUTHORIZATION, authHeaderValue);
			if (HttpURLConnection.HTTP_OK == con.getResponseCode()) {
				response = readResponse(con);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	private String readResponse(HttpURLConnection con) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();
	}

}
