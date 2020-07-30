package com.masivian.roulette.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Roulette")
public class Roulette implements Serializable {

	private static final long serialVersionUID = -297341782441583521L;
	public static final int MIN_NUMBER = 0;
	public static final int MAX_NUMBER = 36;
	public static final String ODD_COLOR = "BLACK";
	public static final String EVEN_COLOR = "RED";
	public static final double MAX_AMOUNT = 10000;

	@Id
	private String id;
	private Boolean open;
	private RouletteResult result;
	private List<Bet> bets;

	public Roulette() {
	}

	public Roulette(String id, Boolean open) {
		this.id = id;
		this.open = open;
	}

	public void open() {
		this.open = true;
		this.bets = new ArrayList<Bet>();
		this.result = null;
	}

	public void close() {
		this.open = false;
	}
	
	public boolean hasBets() {
		return bets != null;
	}
	
	public void initializeBets() {
		bets = new ArrayList<Bet>();
	}

	public void spin() {
		Random randomNumber = new Random();
		int winnerNumber = randomNumber.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
		String winnerColor = winnerNumber % 2 == 0 ? EVEN_COLOR : ODD_COLOR;
		this.result = new RouletteResult(winnerNumber, winnerColor);
	}

	public void checkBets() {
		for (Bet bet : bets) {
			bet.check(result);
		}
	}

	public void bet(Bet newBet) {
		this.bets.add(newBet);
	}

	public boolean isNumberValid(int number) {
		return number >= MIN_NUMBER && number <= MAX_NUMBER;
	}

	public boolean isColorValid(String color) {
		return ODD_COLOR.equals(color) || EVEN_COLOR.equals(color);
	}

	public boolean isAmountValid(double amount) {
		return amount <= MAX_AMOUNT;
	}

	public String getId() {
		return id;
	}

	public Boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public List<Bet> getBets() {
		return bets;
	}

	public RouletteResult getResult() {
		return result;
	}

	public void setResult(RouletteResult result) {
		this.result = result;
	}

}
