package com.bezkoder.spring.security.jwt.repository;

import com.bezkoder.spring.security.jwt.models.MemberChangeTogether;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberChangeTogetherResponsitory extends JpaRepository<MemberChangeTogether, Long> {
    Boolean existsByCmndCccd(String cmndCccd);

    List<MemberChangeTogether> findAllByIsDelete(Integer isDelete);

    Optional<MemberChangeTogether> findByIdAndIsDelete(Long id, Integer isDelete);
}
