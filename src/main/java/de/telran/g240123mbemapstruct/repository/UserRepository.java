package de.telran.g240123mbemapstruct.repository;

import de.telran.g240123mbemapstruct.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}