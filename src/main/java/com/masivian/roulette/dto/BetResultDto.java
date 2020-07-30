package com.masivian.roulette.dto;

public class BetResultDto {

	private String bet;
	private double amount;
	private boolean winner;

	public BetResultDto() {
		super();
	}

	public BetResultDto(String bet, double amount, boolean winner) {
		super();
		this.bet = bet;
		this.amount = amount;
		this.winner = winner;
	}

	public String getBet() {
		return bet;
	}

	public void setBet(String bet) {
		this.bet = bet;
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
