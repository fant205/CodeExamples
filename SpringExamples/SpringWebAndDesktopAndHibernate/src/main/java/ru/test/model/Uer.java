package ru.test.model;

public class Uer {
	
	private final long id;
	private final String name;

	public Uer(long id, String content) {
		this.id = id;
		this.name = content;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
