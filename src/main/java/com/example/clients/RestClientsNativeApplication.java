package com.example.clients;

import com.example.clients.sw.StarWarsRestClient;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestClientsNativeApplication implements ApplicationRunner {

	private final StarWarsRestClient restClient;

	public RestClientsNativeApplication(StarWarsRestClient restClient) {
		this.restClient = restClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(RestClientsNativeApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("Calling Star Wars API:");

		restClient.listPlanets()
			.results()
			.stream()
			.forEach(planet -> {
				System.out.println("  Planet found: " + planet.name());
			});
	}

}
