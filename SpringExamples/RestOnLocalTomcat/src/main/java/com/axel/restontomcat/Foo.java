package com.axel.restontomcat;

public class Foo {

	private final long id;
	private final String name;

	public Foo(long id, String content) {
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
