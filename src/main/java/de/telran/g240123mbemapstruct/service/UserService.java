package de.telran.g240123mbemapstruct.service;

import de.telran.g240123mbemapstruct.domain.dto.UserDto;
import de.telran.g240123mbemapstruct.domain.entity.User;
import de.telran.g240123mbemapstruct.domain.entity.UserDetails;
import de.telran.g240123mbemapstruct.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMappingService mappingService;

    public List<UserDto> getAll() {
        return repository.findAll().stream().map(x -> mappingService.mapToDto(x)).toList();
    }

    public UserDto getById(int id) {
        User user = repository.findById(id).orElse(null);
        return user == null ? null : mappingService.mapToDto(user);
    }

    public UserDto add(UserDto user) {
        User newUser = mappingService.mapToEntity(user);
        UserDetails details = new UserDetails();
        details.setAddress("Test address");
        details.setEmail("Test email");
        details.setPhone("Test phone");
        newUser.setDetails(details);
        details.setUser(newUser);
        newUser = repository.save(newUser);
        return mappingService.mapToDto(newUser);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}