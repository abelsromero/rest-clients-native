package com.example.clients.sw;

import java.util.List;

public record Planet(
	String name,
	Integer rotation_period,
	Integer orbital_period,
	Integer diameter,
	String climate,
	String gravity,
	String terrain,
	List<String> residents
) {
}
