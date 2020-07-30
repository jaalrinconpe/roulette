package com.masivian.roulette.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.masivian.roulette.dto.RouletteBetResultsDto;
import com.masivian.roulette.model.Roulette;

@Mapper(uses = BetResultMapper.class, componentModel = "spring")
public interface RouletteBetResultsMapper {
	
	@Mapping(target = "result", source = "result")
	public RouletteBetResultsDto getDto(Roulette roulette);

}
