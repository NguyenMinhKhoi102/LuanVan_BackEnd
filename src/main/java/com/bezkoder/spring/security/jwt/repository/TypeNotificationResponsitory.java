package com.bezkoder.spring.security.jwt.repository;

import com.bezkoder.spring.security.jwt.models.TypeNotification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TypeNotificationResponsitory extends JpaRepository<TypeNotification, Integer> {

    Optional<TypeNotification> findByIdAndIsDelete(Integer id, Integer isDelete);

    Boolean existsByName(String name);

    List<TypeNotification> findAllByIsDelete(Integer isDelete);

    List<TypeNotification> findAllByIsDeleteAndIsActive(Integer isDelete, Integer isActive);
}
