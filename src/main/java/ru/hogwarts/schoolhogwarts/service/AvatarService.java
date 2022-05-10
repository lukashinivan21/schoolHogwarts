package ru.hogwarts.schoolhogwarts.service;

import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.schoolhogwarts.model.Avatar;

import java.io.IOException;

public interface AvatarService {

    void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException;

    Avatar findAvatar(Long id);
}
