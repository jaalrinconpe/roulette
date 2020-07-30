package com.masivian.roulette.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masivian.roulette.dto.BetDto;
import com.masivian.roulette.dto.RouletteBetResultsDto;
import com.masivian.roulette.dto.RouletteDto;
import com.masivian.roulette.exception.InvalidBetException;
import com.masivian.roulette.exception.NotFoundException;
import com.masivian.roulette.mapper.BetMapper;
import com.masivian.roulette.mapper.RouletteBetResultsMapper;
import com.masivian.roulette.mapper.RouletteMapper;
import com.masivian.roulette.model.Bet;
import com.masivian.roulette.model.BetType;
import com.masivian.roulette.model.Roulette;
import com.masivian.roulette.repository.RouletteRepository;

@Service
public class RouletteService {

	@Autowired
	private RouletteRepository rouletteRepository;

	@Autowired
	private RouletteMapper rouletteMapper;
	
	@Autowired
	private BetMapper betMapper;
	
	@Autowired
	private RouletteBetResultsMapper resultsMapper;

	public String createRoulette(RouletteDto rouletteDto) {
		Roulette newRoulette = rouletteMapper.getModel(rouletteDto);
		Roulette createdRoulette = rouletteRepository.save(newRoulette);
		
		return createdRoulette.getId();
	}

	public Boolean openRoulette(String idRoulette) {
		Roulette foundRoulette = findRouletteModelById(idRoulette);
		foundRoulette.open();
		rouletteRepository.save(foundRoulette);
		
		return true;
	}

	public RouletteBetResultsDto closeBetsOnRoulette(String idRoulette) {
		Roulette foundRoulette = findRouletteModelById(idRoulette);
		if (foundRoulette.isOpen()) {
			foundRoulette.close();
			playBetsOnRoulette(foundRoulette);
			rouletteRepository.save(foundRoulette);
		}
		RouletteBetResultsDto resultsDto = resultsMapper.getDto(foundRoulette);
		
		return resultsDto;
	}
	
	private void playBetsOnRoulette(Roulette roulette) {
		roulette.spin();
		roulette.checkBets();
	}

	private Roulette findRouletteModelById(String id) {
		Optional<Roulette> foundRoulette = rouletteRepository.findById(id);
		if (!foundRoulette.isPresent() || foundRoulette.get() == null || foundRoulette.get().getId() == null) {
			throw new NotFoundException("Roulette not found!");
		}
		Roulette roulette = foundRoulette.get(); 
		if (!roulette.hasBets()) {
			roulette.initializeBets();
		}
		
		return roulette;
	}

	public RouletteDto findRouletteById(String id) {
		Roulette foundRoulette = findRouletteModelById(id);
		RouletteDto foundRouletteDto = rouletteMapper.getDto(foundRoulette);

		return foundRouletteDto;
	}

	public void makeBet(BetDto bet) {
		String idRoulette = bet.getIdRoulette();
		Bet betModel = betMapper.getModel(bet);
		betOnRoulette(betModel, idRoulette);
	}

	private void betOnRoulette(Bet newBet, String idRoulette) {
		Roulette roulette = findRouletteModelById(idRoulette);
		double betAmount = newBet.getAmount();
		if (roulette.isOpen() && roulette.isAmountValid(betAmount) && isBetValid(roulette, newBet)) {
			roulette.bet(newBet);
			rouletteRepository.save(roulette);
		} else {
			throw new InvalidBetException("Bet couldnt be made.");
		}
	}

	private boolean isBetValid(Roulette roulette, Bet bet) {
		if (BetType.COLOR.getName().equals(bet.getType())) {
			String betColor = bet.getValue();
			return roulette.isColorValid(betColor);
		} else if (BetType.NUMBER.getName().equals(bet.getType())) {
			int betNumber = Integer.parseInt(bet.getValue());
			return roulette.isNumberValid(betNumber);
		} else {
			return false;
		}
	}

	public List<RouletteDto> findAllRoulettes() {
		List<Roulette> foundRoulettes = (List<Roulette>) rouletteRepository.findAll();
		List<RouletteDto> foundRoulettesDto = rouletteMapper.getDtos(foundRoulettes);

		return foundRoulettesDto;
	}

}
