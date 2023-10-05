package de.telran.g240123mbemapstruct.service;

import de.telran.g240123mbemapstruct.domain.dto.UserDto;
import de.telran.g240123mbemapstruct.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMappingService {

    // UserMappingServiceImpl implements UserMappingService

    @Mapping(source = "user.name", target = "username")
    @Mapping(target = "password", constant = "")
    @Mapping(source = "user.details", target = "details")
    UserDto mapToDto(User user);

    @Mapping(source = "dto.username", target = "name")
    @Mapping(target = "id", constant = "0")
    @Mapping(target = "password", expression = "java(String.valueOf(dto.getPassword().hashCode()))")
    User mapToEntity(UserDto dto);
}