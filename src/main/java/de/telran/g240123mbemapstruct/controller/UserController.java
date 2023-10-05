package de.telran.g240123mbemapstruct.controller;

import de.telran.g240123mbemapstruct.domain.dto.UserDto;
import de.telran.g240123mbemapstruct.domain.entity.User;
import de.telran.g240123mbemapstruct.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "Контроллер пользователей", description = "Контроллер для различных операций над пользователями")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    @Operation(
            summary = "Получение пользователей",
            description = "Получение списка всех пользователей, хранящихся в БД"
    )
    public List<UserDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Получение конкретного пользователя",
            description = "Получение пользователя, соответствующего переданному идентификатору"
    )
    public UserDto getById(@PathVariable @Parameter(description = "Идентификатор пользователя") int id) {
        return service.getById(id);
    }

    @PostMapping
    @Operation(
            summary = "Добавление пользователя",
            description = "Сохранение в БД пользователя, переданного в теле запроса"
    )
    public UserDto add(@RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Объект пользователя") UserDto user) {
        return service.add(user);
    }

    @Operation(
            summary = "Удаление конкретного пользователя",
            description = "Удаление пользователя, соответствующего переданному идентификатору"
    )
    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Parameter(description = "Идентификатор пользователя") int id) {
        service.delete(id);
    }
}