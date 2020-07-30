package com.masivian.roulette.dto;

public class BetDto {

	private double amount;
	private String type;
	private String value;
	private String user;
	private String idRoulette;

	public BetDto() {}

	public BetDto(double amount, String type, String value, String user) {
		this.amount = amount;
		this.type = type;
		this.value = value;
		this.user = user;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getIdRoulette() {
		return idRoulette;
	}

	public void setIdRoulette(String idRoulette) {
		this.idRoulette = idRoulette;
	}

}
