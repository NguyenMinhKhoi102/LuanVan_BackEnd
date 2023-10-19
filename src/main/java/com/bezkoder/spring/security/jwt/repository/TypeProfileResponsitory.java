package com.bezkoder.spring.security.jwt.repository;


import com.bezkoder.spring.security.jwt.models.TypeProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface TypeProfileResponsitory extends JpaRepository<TypeProfile,Integer> {

    Optional<TypeProfile> findByIdAndIsDelete(Integer id, Integer isDelete);
    Boolean existsByName(String name);

    List<TypeProfile> findAllByIsDelete(Integer isDelete);
    List<TypeProfile> findAllByIsDeleteAndIsActive(Integer isDelete, Integer isActive);
}
