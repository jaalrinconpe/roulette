package com.masivian.roulette.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.masivian.roulette.dto.BetDto;
import com.masivian.roulette.model.Bet;

@Mapper(componentModel = "spring")
public interface BetMapper {
	
	@Mappings({
		@Mapping(target = "id", ignore = true),
		@Mapping(target = "winner", ignore = true)})
	public Bet getModel(BetDto betDto);
	
	@Mapping(target = "idRoulette", ignore = true)
	public BetDto getDto(Bet bet);

}
