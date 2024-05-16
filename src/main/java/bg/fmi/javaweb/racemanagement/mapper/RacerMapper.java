package bg.fmi.javaweb.racemanagement.mapper;

import bg.fmi.javaweb.racemanagement.models.Racer;
import bg.fmi.javaweb.racemanagement.dtos.RacerDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RacerMapper {

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "team", target = "team")
    Racer dtoToEntity(RacerDTO racerDTO);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "team", target = "team")
    RacerDTO entityToDto(Racer racer);

}
