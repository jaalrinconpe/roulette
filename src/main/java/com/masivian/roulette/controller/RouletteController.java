package com.masivian.roulette.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masivian.roulette.dto.BetDto;
import com.masivian.roulette.dto.RouletteBetResultsDto;
import com.masivian.roulette.dto.RouletteDto;
import com.masivian.roulette.service.RouletteService;

@RestController
@RequestMapping(value = "/roulette")
public class RouletteController {
	
	@Autowired
	private RouletteService rouletteService;
	
	@PostMapping
	public String createRoulette(@RequestBody RouletteDto rouletteDto) {
		return rouletteService.createRoulette(rouletteDto);
	}
	
	@GetMapping("/open/{id}")
	public boolean openRouletteById(@PathVariable(name = "id") String id) {
		return rouletteService.openRoulette(id);
	}
	
	@PostMapping(value = "/bet")
	public void makeBet(@RequestHeader("user") String idUser, @RequestBody BetDto betDto) {
		betDto.setUser(idUser);
		rouletteService.makeBet(betDto);
	}
	
	@GetMapping("/close/{id}")
	public RouletteBetResultsDto closeBetsOnRoulette(@PathVariable(name = "id") String idRoulette) {
		return rouletteService.closeBetsOnRoulette(idRoulette);
	}
	
	@GetMapping("/{id}")
	public RouletteDto findRouletteById(@PathVariable(name = "id") String id) {
		return rouletteService.findRouletteById(id);
	}
	
	@GetMapping
	public List<RouletteDto> findAllRoulettes() {
		return rouletteService.findAllRoulettes();
	}

}
