package com.masivian.roulette.model;

public enum BetType {
	
	NUMBER("NUMBER"), COLOR("COLOR");
	
	private String name;
	
	BetType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}
