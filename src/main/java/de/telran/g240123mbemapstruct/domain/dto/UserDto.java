package de.telran.g240123mbemapstruct.domain.dto;

import de.telran.g240123mbemapstruct.domain.entity.UserDetails;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "ДТО объект пользователя")
public class UserDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Идентификатор пользователя", example = "777")
    private int id;

    @Schema(description = "Имя пользователя", example = "Vasya")
    private String username;

    @Schema(description = "Пароль пользователя", example = "qwerty")
    private String password;

    @Schema(description = "Детальная информация о пользователе")
    private UserDetails details;

    public UserDto() {
    }

    public UserDetails getDetails() {
        return details;
    }

    public void setDetails(UserDetails details) {
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}