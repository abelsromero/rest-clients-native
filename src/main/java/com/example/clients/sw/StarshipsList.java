package com.example.clients.sw;

import java.util.List;

public record StarshipsList(
	Integer count,
	String next,
	String previous,
	List<Starship> results
) {
}
