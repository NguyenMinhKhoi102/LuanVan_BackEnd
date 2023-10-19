package com.bezkoder.spring.security.jwt.security.services;

import com.bezkoder.spring.security.jwt.models.TypeProfile;
import com.bezkoder.spring.security.jwt.payload.request.TypeProfileRequest;
import com.bezkoder.spring.security.jwt.repository.TypeProfileResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProfileService {

    @Autowired
    TypeProfileResponsitory typeProfileResponsitory;

    public TypeProfile infoTypeProfile(Integer id){
        return typeProfileResponsitory.findByIdAndIsDelete(id, 0).orElseThrow(() -> new RuntimeException("Không tìm thấy"));
    }

    public List<TypeProfile> listTypeProfile(Boolean active){
        return active ?
                typeProfileResponsitory.findAllByIsDeleteAndIsActive(0, 1) :
                typeProfileResponsitory.findAllByIsDelete(0);
    }

    public Boolean addTypeProfile(TypeProfileRequest typeProfileRequest){
        try {
            TypeProfile typeProfile = TypeProfile.builder()
                    .name(typeProfileRequest.getName())
                    .isActive(1)
                    .isDelete(0)
                    .build();
            typeProfileResponsitory.save(typeProfile);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public Boolean updateTypeProfile(Integer id, TypeProfileRequest typeProfileRequest){
        try {
            TypeProfile typeProfile = typeProfileResponsitory.findByIdAndIsDelete(id, 0).orElseThrow(() -> new RuntimeException("Không tìm thấy"));
            typeProfile.setName(typeProfileRequest.getName() == null ? typeProfile.getName() : typeProfileRequest.getName());
            typeProfile.setIsActive(typeProfileRequest.getIsActive() == null ? typeProfile.getIsActive() : typeProfileRequest.getIsActive());
            typeProfileResponsitory.save(typeProfile);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public Boolean deleteTypeProfile(Integer id){
        try {
            TypeProfile typeProfile = typeProfileResponsitory.findByIdAndIsDelete(id, 0).orElseThrow(() -> new RuntimeException("Không tìm thấy"));
            typeProfile.setIsDelete(1);
            typeProfileResponsitory.save(typeProfile);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
