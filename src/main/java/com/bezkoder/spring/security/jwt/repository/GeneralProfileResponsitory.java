package com.bezkoder.spring.security.jwt.repository;

import com.bezkoder.spring.security.jwt.models.GeneralProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GeneralProfileResponsitory extends JpaRepository<GeneralProfile, Long> {

    Optional<GeneralProfile> findByIdAndIsDelete(Long id, Integer isDelete);

    List<GeneralProfile> findAllByIsDelete(Integer isDelete);

}
