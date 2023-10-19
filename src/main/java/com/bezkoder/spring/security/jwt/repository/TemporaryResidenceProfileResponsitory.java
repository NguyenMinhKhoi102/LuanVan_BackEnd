package com.bezkoder.spring.security.jwt.repository;

import com.bezkoder.spring.security.jwt.models.TemporaryResidenceProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TemporaryResidenceProfileResponsitory extends JpaRepository<TemporaryResidenceProfile, Long> {

    Optional<TemporaryResidenceProfile> findByIdAndIsDelete(Long id, Integer isDelete);

    List<TemporaryResidenceProfile> findAllByIsDelete(Integer isDelete);
}
