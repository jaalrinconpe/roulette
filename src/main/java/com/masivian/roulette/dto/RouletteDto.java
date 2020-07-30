package com.masivian.roulette.dto;

public class RouletteDto {

	private String id;
	private String open;

	public RouletteDto() {
	}

	public RouletteDto(String id, String open) {
		this.id = id;
		this.open = open;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

}
