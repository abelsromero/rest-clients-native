package com.example.clients;

import com.example.clients.sw.PlanetsList;
import com.example.clients.sw.StarWarsRestClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StarWarsRestClientTest {


	@Test
	void shouldListPlanets() {
		final var restClient = new StarWarsRestClient();

		PlanetsList planetsList = restClient.listPlanets();

		assertThat(planetsList.count()).isGreaterThan(50);
		assertThat(planetsList.next()).isEqualTo("https://swapi.dev/api/planets/?page=2");
		assertThat(planetsList.previous()).isNull();

		assertThat(planetsList.results()).hasSize(10);
		assertThat(planetsList.results()).allSatisfy(planet -> {
			assertThat(planet.name()).isNotBlank();
			assertThat(planet.rotation_period()).isNotNull();
			assertThat(planet.orbital_period()).isNotNull();
			assertThat(planet.diameter()).isNotNull();
			assertThat(planet.climate()).isNotBlank();
			assertThat(planet.gravity()).isNotBlank();
			assertThat(planet.terrain()).isNotBlank();
			// Some are empty
			// assertThat(planet.residents()).isNotEmpty();
		});
	}

}
