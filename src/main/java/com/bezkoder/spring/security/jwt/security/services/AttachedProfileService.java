package com.bezkoder.spring.security.jwt.security.services;

import com.bezkoder.spring.security.jwt.models.AttachedProfile;
import com.bezkoder.spring.security.jwt.models.GeneralProfile;
import com.bezkoder.spring.security.jwt.models.TemporaryResidenceProfile;
import com.bezkoder.spring.security.jwt.payload.request.AttachedProfileRequest;
import com.bezkoder.spring.security.jwt.payload.response.MessageResponse;
import com.bezkoder.spring.security.jwt.repository.AttachedProfileResponsitory;
import com.bezkoder.spring.security.jwt.repository.GeneralProfileResponsitory;
import com.bezkoder.spring.security.jwt.repository.TemporaryResidenceProfileResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachedProfileService {

    @Autowired
    AttachedProfileResponsitory attachedProfileResponsitory;

    @Autowired
    GeneralProfileResponsitory generalProfileResponsitory;

    @Autowired
    TemporaryResidenceProfileResponsitory temporaryResidenceProfileResponsitory;

    public AttachedProfile infoAttachedProfile(Long id){
        return attachedProfileResponsitory.findByIdAndIsDelete(id, 0).orElseThrow(()->new RuntimeException("Không tìm thấy"));
    }
    public List<AttachedProfile> listAttachedProfile(){
        return attachedProfileResponsitory.findAllByIsDelete(0);
    }
    public Boolean addAttachedProfile(AttachedProfileRequest attachedProfileRequest){
        try {
            AttachedProfile attachedProfile = AttachedProfile.builder()
                    .name(attachedProfileRequest.getName())
                    .note(attachedProfileRequest.getNote())
                    .path(attachedProfileRequest.getPath())
                    .isCopy(attachedProfileRequest.getIsCopy())
                    .isDelete(0)
                    .generalProfile(attachedProfileRequest.getGeneralProfileId() == null ? null : generalProfileResponsitory.findByIdAndIsDelete(attachedProfileRequest.getGeneralProfileId(), 0).orElse(null))
                    .temporaryResidenceProfile(attachedProfileRequest.getTemporaryResidenceProfileId() == null ? null : temporaryResidenceProfileResponsitory.findByIdAndIsDelete(attachedProfileRequest.getTemporaryResidenceProfileId(), 0).orElse(null))
                    .build();
            attachedProfileResponsitory.save(attachedProfile);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public Boolean updateAttachedProfile(Long id, AttachedProfileRequest attachedProfileRequest){
        try {
            AttachedProfile attachedProfile = attachedProfileResponsitory.findByIdAndIsDelete(id, 0).orElseThrow(()->new RuntimeException("Không tìm thấy"));

            attachedProfile.setGeneralProfile(
                    attachedProfileRequest.getGeneralProfileId() == null ?
                            attachedProfile.getGeneralProfile() :
                            generalProfileResponsitory
                                    .findByIdAndIsDelete(attachedProfileRequest.getGeneralProfileId(), 0).orElse(attachedProfile.getGeneralProfile())
            );

            attachedProfile.setTemporaryResidenceProfile(
                    attachedProfileRequest.getTemporaryResidenceProfileId() == null ?
                            attachedProfile.getTemporaryResidenceProfile() :
                            temporaryResidenceProfileResponsitory
                                    .findByIdAndIsDelete(attachedProfileRequest.getTemporaryResidenceProfileId(), 0).orElse(attachedProfile.getTemporaryResidenceProfile())
            );

            attachedProfile.setName(attachedProfileRequest.getName() == null ? attachedProfile.getName() : attachedProfileRequest.getName());
            attachedProfile.setNote(attachedProfileRequest.getNote() == null ? attachedProfile.getNote() : attachedProfileRequest.getNote());
            attachedProfile.setPath(attachedProfileRequest.getPath() == null ? attachedProfile.getPath() : attachedProfileRequest.getPath());


            attachedProfileResponsitory.save(attachedProfile);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public Boolean deleteAttachedProfile(Long id){
        try {
            AttachedProfile attachedProfile = attachedProfileResponsitory.findByIdAndIsDelete(id, 0).orElseThrow(()->new RuntimeException("Không tìm thấy"));
            attachedProfile.setIsDelete(1);
            attachedProfileResponsitory.save(attachedProfile);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }


}
