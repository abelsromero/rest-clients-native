package com.example.clients;

import com.example.clients.posts.PostRequest;
import com.example.clients.posts.PostResponse;
import com.example.clients.posts.PostsClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostsClientTest {


	@Test
	void shouldListPlanets() {
		final var client = new PostsClient();

		PostRequest postToCreate = new PostRequest("my-title", "my-content", 1);
		PostResponse response = client.create(postToCreate);

		assertThat(response.id()).isNotNull();
	}

}
