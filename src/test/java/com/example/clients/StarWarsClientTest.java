package com.example.clients;

import com.example.clients.sw.PlanetsList;
import com.example.clients.sw.StarWarsClient;
import com.example.clients.sw.StarshipsList;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StarWarsClientTest {


	@Test
	void shouldListPlanets() {
		final var restClient = new StarWarsClient();

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

	// Test responses with 'Set' properties
	@Test
	void shouldListStarships() {
		final var restClient = new StarWarsClient();

		StarshipsList starships = restClient.listStarships();

		assertThat(starships.count()).isGreaterThan(25);
		assertThat(starships.next()).isEqualTo("https://swapi.dev/api/starships/?page=2");
		assertThat(starships.previous()).isNull();

		assertThat(starships.results()).hasSize(10);
		assertThat(starships.results()).allSatisfy(planet -> {
			assertThat(planet.name()).isNotBlank();
			assertThat(planet.manufacturer()).isNotBlank();
			assertThat(planet.length()).isNotBlank();
			assertThat(planet.crew()).isNotBlank();
			assertThat(planet.passengers()).isNotBlank();
			assertThat(planet.starship_class()).isNotBlank();
			assertThat(planet.films()).isNotEmpty();
		});
	}

}
