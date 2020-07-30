package com.masivian.roulette.dto;

import java.util.List;

import com.masivian.roulette.model.RouletteResult;

public class RouletteBetResultsDto {

	private RouletteResult result;
	private List<BetResultDto> bets;

	public RouletteBetResultsDto() {
		super();
	}

	public RouletteBetResultsDto(RouletteResult result, List<BetResultDto> bets) {
		super();
		this.result = result;
		this.bets = bets;
	}

	public RouletteResult getResult() {
		return result;
	}

	public void setResult(RouletteResult result) {
		this.result = result;
	}

	public List<BetResultDto> getBets() {
		return bets;
	}

	public void setBets(List<BetResultDto> bets) {
		this.bets = bets;
	}

}
