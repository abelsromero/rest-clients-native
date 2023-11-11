package com.example.clients.sw;

import java.util.List;

public record PlanetsList(
	Integer count,
	String next,
	String previous,
	List<Planet> results
) {
}
