package com.masivian.roulette.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "Bet")
public class Bet implements Serializable {

	private static final long serialVersionUID = 4882560471236320764L;

	@Id
	private String id;
	private String type;
	private double amount;
	private String value;
	private String user;
	protected boolean winner;

	public Bet() {
		super();
	}

	public Bet(String id, String type, double amount, String value, String user) {
		super();
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.value = value;
		this.user = user;
	}

	public void check(RouletteResult rouletteResult) {
		if (BetType.NUMBER.getName().equals(type)) {
			int number = Integer.parseInt(this.getValue()); 
			this.winner = number == rouletteResult.getWinnerNumber();
		} else if (BetType.COLOR.getName().equals(type)) {
			this.winner = this.getValue().equals(rouletteResult.getWinnerColor());
		} else {
			this.winner = false;
		}
	}

	public String getId() {
		return id;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isWinner() {
		return winner;
	}
	
	public void setWinner(boolean winner) {
		this.winner = winner;
	}

}
