package ChatFlatAPI;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class APIRequester {

	public static HttpResponse<String> sendGet(String baseUrl, String endpoint)
			throws IOException, InterruptedException {
		
		String url = baseUrl + endpoint;
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = (HttpRequest) HttpRequest.newBuilder(URI.create(url))
				.header("Accept", "application/json")
				.build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

		return response;
	}

	public static HttpResponse<String> sendPost(String baseUrl, String endpoint, Map<String, String> payload)
			throws IOException, InterruptedException {
		String url = baseUrl + endpoint;
		String jsonPayload = new ObjectMapper().writeValueAsString(payload);

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = (HttpRequest) HttpRequest.newBuilder(URI.create(url))
				.header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.POST(BodyPublishers.ofString(jsonPayload))
				.build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

		return response;

	}

}
