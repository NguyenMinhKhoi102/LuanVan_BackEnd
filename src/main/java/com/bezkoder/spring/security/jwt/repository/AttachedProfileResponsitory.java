package com.bezkoder.spring.security.jwt.repository;

import com.bezkoder.spring.security.jwt.models.AttachedProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AttachedProfileResponsitory extends JpaRepository<AttachedProfile, Long> {
    List<AttachedProfile> findAllByIsDelete(Integer isDelete);

    Optional<AttachedProfile> findByIdAndIsDelete(Long id, Integer isDelete);
}
