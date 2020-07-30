package com.masivian.roulette.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Roulette")
public class RouletteResult implements Serializable {

	private static final long serialVersionUID = 8909636976831177895L;

	private int winnerNumber;
	private String winnerColor;

	public RouletteResult() {}

	public RouletteResult(int winnerNumber, String winnerColor) {
		this.winnerNumber = winnerNumber;
		this.winnerColor = winnerColor;
	}

	public int getWinnerNumber() {
		return winnerNumber;
	}

	public String getWinnerColor() {
		return winnerColor;
	}

}
