package bg.fmi.javaweb.racemanagement.mapper;

import bg.fmi.javaweb.racemanagement.models.Team;
import bg.fmi.javaweb.racemanagement.models.TeamDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    @Mapping(source = "name", target = "name")
    @Mapping(source = "racers", target = "racers")
    Team dtoToEntity(TeamDTO teamDTO);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "racers", target = "racers")
    TeamDTO entityToDto(Team team);
}
