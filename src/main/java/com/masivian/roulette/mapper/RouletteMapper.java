package com.masivian.roulette.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.masivian.roulette.dto.RouletteDto;
import com.masivian.roulette.model.Roulette;

@Mapper(componentModel = "spring", uses = BetMapper.class)
public interface RouletteMapper {
	
	RouletteDto getDto(Roulette roulette);
	
	@Mappings({
		@Mapping(target = "id", ignore = true),
		@Mapping(target = "bets", ignore = true)
	})
	Roulette getModel(RouletteDto rouletteDto);
	
	List<RouletteDto> getDtos(List<Roulette> roulettes);
	
	List<Roulette> getModels(List<RouletteDto> rouletteDtos);

}
