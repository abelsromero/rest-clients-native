package com.example.clients;

import com.example.clients.posts.PostRequest;
import com.example.clients.posts.PostResponse;
import com.example.clients.posts.PostsClient;
import com.example.clients.sw.Planet;
import com.example.clients.sw.PlanetsList;
import com.example.clients.sw.StarWarsClient;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RegisterReflectionForBinding({PlanetsList.class, Planet.class})
public class RestClientsNativeApplication implements ApplicationRunner {

	private final StarWarsClient swClient;
	private final PostsClient postsClient;

	public RestClientsNativeApplication(StarWarsClient restClient, PostsClient postsClient) {
		this.swClient = restClient;
		this.postsClient = postsClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(RestClientsNativeApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		getSwApi();
		postPostsApi();
	}

	private void postPostsApi() {
		System.out.println("\n");
		System.out.println("Calling Posts API:");

		PostRequest postToCreate = new PostRequest("my-title", "my-content", 1);
		PostResponse response = postsClient.create(postToCreate);
		System.out.println("  Post create: " + response);
	}

	private void getSwApi() {
		System.out.println("\n");
		System.out.println("Calling Star Wars API:");

		swClient.listPlanets()
			.results()
			.stream()
			.forEach(planet -> {
				System.out.println("  Planet found: " + planet.name());
			});
	}

}
