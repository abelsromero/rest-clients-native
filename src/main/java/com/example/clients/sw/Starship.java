package com.example.clients.sw;

import java.util.Set;

public record Starship (
	String name,
	String manufacturer,
	String length,
	String crew,
	String passengers,
	String starship_class,
	Set<String> films
) {
}
