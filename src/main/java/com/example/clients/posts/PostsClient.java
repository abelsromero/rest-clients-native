package com.example.clients.posts;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class PostsClient {

	private final RestClient restClient;

	public PostsClient() {
		restClient = RestClient
			.builder()
			.baseUrl("https://jsonplaceholder.typicode.com")
			.build();
	}

	public PostResponse create(PostRequest post) {
		return restClient.post()
			.uri("/posts")
			.contentType(MediaType.APPLICATION_JSON)
			.body(post)
			.retrieve()
			.body(PostResponse.class);
	}

}
