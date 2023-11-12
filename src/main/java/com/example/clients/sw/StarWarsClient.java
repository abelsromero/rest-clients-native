package com.example.clients.sw;


import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;


@Component
public class StarWarsClient {

	private final RestClient restClient;


	public StarWarsClient() {
		restClient = RestClient.builder()
			.baseUrl("https://swapi.dev/api")
			.build();
	}

	public PlanetsList listPlanets() {
		final PlanetsList planets = restClient.get()
			.uri("/planets")
			.retrieve()
			.body(PlanetsList.class);

		return planets;
	}

}
