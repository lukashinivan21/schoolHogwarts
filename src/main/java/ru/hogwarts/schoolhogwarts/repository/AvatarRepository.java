package ru.hogwarts.schoolhogwarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.schoolhogwarts.model.Avatar;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

    Optional<Avatar> findByStudentId(Long studentId);

}
