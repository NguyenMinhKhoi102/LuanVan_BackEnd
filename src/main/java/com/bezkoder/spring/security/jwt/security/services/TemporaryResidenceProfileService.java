package com.bezkoder.spring.security.jwt.security.services;

import com.bezkoder.spring.security.jwt.models.TemporaryResidenceProfile;
import com.bezkoder.spring.security.jwt.payload.request.TemporaryResidenceProfileRequest;
import com.bezkoder.spring.security.jwt.repository.TemporaryResidenceProfileResponsitory;
import com.bezkoder.spring.security.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemporaryResidenceProfileService {

    @Autowired
    TemporaryResidenceProfileResponsitory temporaryResidenceProfileResponsitory;

    @Autowired
    UserRepository userRepository;

    public TemporaryResidenceProfile infoTemporaryResidenceProfile(Long id){
        return temporaryResidenceProfileResponsitory.findByIdAndIsDelete(id, 0).orElseThrow(()->new RuntimeException("Không tìm thấy"));
    }

    public List<TemporaryResidenceProfile> listTemporaryResidenceProfiles(){
        return temporaryResidenceProfileResponsitory.findAllByIsDelete(0);
    }

    public Boolean addTemporaryResidenceProfile(TemporaryResidenceProfileRequest temporaryResidenceProfileRequest){
        try{
            TemporaryResidenceProfile temporaryResidenceProfile = TemporaryResidenceProfile.builder()
                    .isExpired(0)
                    .isDelete(0)
                    .name(temporaryResidenceProfileRequest.getName())
                    .birthday(temporaryResidenceProfileRequest.getBirthday())
                    .cmndCccd(temporaryResidenceProfileRequest.getCmndCccd())
                    .gender(temporaryResidenceProfileRequest.getGender())
                    .phone(temporaryResidenceProfileRequest.getPhone())
                    .email(temporaryResidenceProfileRequest.getEmail())
                    .permanentAddress(temporaryResidenceProfileRequest.getPermanentAddress())
                    .currentAddress(temporaryResidenceProfileRequest.getCurrentAddress())
                    .job(temporaryResidenceProfileRequest.getJob())
                    .workspace(temporaryResidenceProfileRequest.getWorkspace())
                    .temperaryAddress(temporaryResidenceProfileRequest.getTemperaryAddress())
                    .temporaryResidenceExpiration(temporaryResidenceProfileRequest.getTemporaryResidenceExpiration())
                    .hostName(temporaryResidenceProfileRequest.getHostName())
                    .cmndCccd(temporaryResidenceProfileRequest.getCmndCccd())
                    .relationshipHost(temporaryResidenceProfileRequest.getRelationshipHost())
                    .relationshipDeclarent(temporaryResidenceProfileRequest.getRelationshipDeclarent())
                    .user(temporaryResidenceProfileRequest.getUserId() == null ?
                            null :
                            userRepository.findById(temporaryResidenceProfileRequest.getUserId()).orElse(null))
                    .build();
            temporaryResidenceProfileResponsitory.save(temporaryResidenceProfile);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public Boolean updateTemporaryResidenceProfile(Long id, TemporaryResidenceProfileRequest temporaryResidenceProfileRequest){
        try{
            TemporaryResidenceProfile temporaryResidenceProfile = temporaryResidenceProfileResponsitory.findByIdAndIsDelete(id, 0).orElseThrow(()->new RuntimeException("Không tìm thấy"));
            if(temporaryResidenceProfileRequest.getIsExpired() != null)
                temporaryResidenceProfile.setIsExpired(temporaryResidenceProfileRequest.getIsExpired());
            if(temporaryResidenceProfileRequest.getName() != null)
                temporaryResidenceProfile.setName(temporaryResidenceProfileRequest.getName());
            if(temporaryResidenceProfileRequest.getBirthday() != null)
                temporaryResidenceProfile.setBirthday(temporaryResidenceProfileRequest.getBirthday());
            if(temporaryResidenceProfileRequest.getCmndCccd() != null)
                temporaryResidenceProfile.setCmndCccd(temporaryResidenceProfileRequest.getCmndCccd());
            if(temporaryResidenceProfileRequest.getGender() != null)
                temporaryResidenceProfile.setGender(temporaryResidenceProfileRequest.getGender());
            if(temporaryResidenceProfileRequest.getPhone() != null)
                temporaryResidenceProfile.setPhone(temporaryResidenceProfileRequest.getPhone());
            if(temporaryResidenceProfileRequest.getEmail() != null)
                temporaryResidenceProfile.setEmail(temporaryResidenceProfileRequest.getEmail());
            if(temporaryResidenceProfileRequest.getPermanentAddress() != null)
                temporaryResidenceProfile.setPermanentAddress(temporaryResidenceProfileRequest.getPermanentAddress());
            if(temporaryResidenceProfileRequest.getCurrentAddress() != null)
                temporaryResidenceProfile.setCurrentAddress(temporaryResidenceProfileRequest.getCurrentAddress());
            if(temporaryResidenceProfileRequest.getHostName() != null)
                temporaryResidenceProfile.setHostName(temporaryResidenceProfileRequest.getHostName());
            if(temporaryResidenceProfileRequest.getCmndCccdHost() != null)
                temporaryResidenceProfile.setCmndCccdHost(temporaryResidenceProfileRequest.getCmndCccdHost());
            if(temporaryResidenceProfileRequest.getRelationshipHost() != null)
                temporaryResidenceProfile.setRelationshipHost(temporaryResidenceProfileRequest.getRelationshipHost());
            if(temporaryResidenceProfileRequest.getRelationshipDeclarent() != null)
                temporaryResidenceProfile.setRelationshipDeclarent(temporaryResidenceProfileRequest.getRelationshipDeclarent());
            if(temporaryResidenceProfileRequest.getUserId() != null)
                temporaryResidenceProfile.setUser(userRepository.findById(temporaryResidenceProfileRequest.getUserId()).orElse(temporaryResidenceProfile.getUser()));
            temporaryResidenceProfileResponsitory.save(temporaryResidenceProfile);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public Boolean deleteTemporaryResidenceProfile(Long id){
        try{
            TemporaryResidenceProfile temporaryResidenceProfile = temporaryResidenceProfileResponsitory.findByIdAndIsDelete(id, 0).orElseThrow(()->new RuntimeException("Không tìm thấy"));
            temporaryResidenceProfile.setIsDelete(1);
            temporaryResidenceProfileResponsitory.save(temporaryResidenceProfile);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
