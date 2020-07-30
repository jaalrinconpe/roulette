package com.masivian.roulette.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.masivian.roulette.dto.BetResultDto;
import com.masivian.roulette.model.Bet;

@Mapper(componentModel = "spring")
public interface BetResultMapper {
	
	@Mapping(target = "bet", source = "value")
	public BetResultDto getBetResultDto(Bet bet);

}
