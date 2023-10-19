package com.bezkoder.spring.security.jwt.security.services;

import com.bezkoder.spring.security.jwt.models.GeneralProfile;
import com.bezkoder.spring.security.jwt.payload.request.GeneralProfileRequest;
import com.bezkoder.spring.security.jwt.repository.GeneralProfileResponsitory;
import com.bezkoder.spring.security.jwt.repository.ReceiveResultsResponsitory;
import com.bezkoder.spring.security.jwt.repository.TypeNotificationResponsitory;
import com.bezkoder.spring.security.jwt.repository.TypeProfileResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralProfileService {

    @Autowired
    GeneralProfileResponsitory generalProfileResponsitory;

    @Autowired
    TypeProfileResponsitory typeProfileResponsitory;

    @Autowired
    TypeNotificationResponsitory typeNotificationResponsitory;

    @Autowired
    ReceiveResultsResponsitory receiveResultsResponsitory;

    public GeneralProfile infoGeneralProfile(Long id){
        return generalProfileResponsitory.findByIdAndIsDelete(id, 0).orElseThrow(()->new RuntimeException("Không tìm thấy"));
    }

    public List<GeneralProfile> listGeneralProfiles(){
        return generalProfileResponsitory.findAllByIsDelete(0);
    }

    public Boolean addGeneralProfile(GeneralProfileRequest generalProfileRequest){
        try{
            GeneralProfile generalProfile = GeneralProfile.builder()
                    .districtId(generalProfileRequest.getDistrictId())
                    .wardId(generalProfileRequest.getWardId())
                    .isCopy(generalProfileRequest.getIsCopy())
                    .isHistory(generalProfileRequest.getIsHistory())
                    .status(0)
                    .isDelete(0)
                    .name(generalProfileRequest.getName())
                    .birthday(generalProfileRequest.getBirthday())
                    .cmndCccd(generalProfileRequest.getCmndCccd())
                    .gender(generalProfileRequest.getGender())
                    .phone(generalProfileRequest.getPhone())
                    .email(generalProfileRequest.getEmail())
                    .permanentAddress(generalProfileRequest.getPermanentAddress())
                    .currentAddress(generalProfileRequest.getCurrentAddress())
                    .job(generalProfileRequest.getJob())
                    .workspace(generalProfileRequest.getWorkspace())
                    .temperaryAddress(generalProfileRequest.getTemperaryAddress())
                    .temporaryResidenceExpiration(generalProfileRequest.getTemporaryResidenceExpiration())
                    .hostName(generalProfileRequest.getHostName())
                    .cmndCccdHost(generalProfileRequest.getCmndCccdHost())
                    .relationshipHost(generalProfileRequest.getRelationshipHost())
                    .relationshipDeclarent(generalProfileRequest.getRelationshipDeclarent())
                    .noteDeclarent(generalProfileRequest.getNoteDeclarent())
                    .caseProfile(generalProfileRequest.getCaseProfile())
                    .typeProfile(generalProfileRequest.getTypeProfileId() == null ? null : typeProfileResponsitory.findByIdAndIsDelete(generalProfileRequest.getTypeProfileId(), 0).orElse(null))
                    .typeNotification(generalProfileRequest.getTypeNotificationId() == null ? null : typeNotificationResponsitory.findByIdAndIsDelete(generalProfileRequest.getTypeNotificationId(), 0).orElse(null))
                    .receiveResult(generalProfileRequest.getReceiveResultId() == null ? null : receiveResultsResponsitory.findByIdAndIsDelete(generalProfileRequest.getReceiveResultId(), 0).orElse(null))
                    .build();
            generalProfileResponsitory.save(generalProfile);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public Boolean updateGeneralProfile(Long id, GeneralProfileRequest generalProfileRequest){
        try{
            GeneralProfile generalProfile = generalProfileResponsitory.findByIdAndIsDelete(id, 0).orElseThrow(()-> new RuntimeException("Không tìm thấy"));
            if(generalProfileRequest.getTypeProfileId() != null)
                generalProfile.setTypeProfile(typeProfileResponsitory.findByIdAndIsDelete(generalProfileRequest.getTypeProfileId(), 0).orElse(generalProfile.getTypeProfile()));
            if(generalProfileRequest.getTypeNotificationId() != null)
                generalProfile.setTypeNotification(typeNotificationResponsitory.findByIdAndIsDelete(generalProfileRequest.getTypeNotificationId(), 0).orElse(generalProfile.getTypeNotification()));
            if(generalProfileRequest.getReceiveResultId() != null)
                generalProfile.setReceiveResult(receiveResultsResponsitory.findByIdAndIsDelete(generalProfileRequest.getReceiveResultId(), 0).orElse(generalProfile.getReceiveResult()));
            if(generalProfileRequest.getDistrictId() != null)
                generalProfile.setDistrictId(generalProfileRequest.getDistrictId());
            if(generalProfileRequest.getWardId() != null)
                generalProfile.setWardId(generalProfileRequest.getWardId());
            if(generalProfileRequest.getIsCopy() != null)
                generalProfile.setIsCopy(generalProfileRequest.getIsCopy());
            if(generalProfileRequest.getIsHistory() != null)
                generalProfile.setIsHistory(generalProfileRequest.getIsHistory());
            if(generalProfileRequest.getStatus() != null)
                generalProfile.setStatus(generalProfileRequest.getStatus());
            if(generalProfileRequest.getName() != null)
                generalProfile.setName(generalProfileRequest.getName());
            if(generalProfileRequest.getBirthday() != null)
                generalProfile.setBirthday(generalProfileRequest.getBirthday());
            if(generalProfileRequest.getCmndCccd() != null)
                generalProfile.setCmndCccd(generalProfileRequest.getCmndCccd());
            if(generalProfileRequest.getGender() != null)
                generalProfile.setGender(generalProfileRequest.getGender());
            if(generalProfileRequest.getPhone() != null)
                generalProfile.setPhone(generalProfileRequest.getPhone());
            if(generalProfileRequest.getEmail() != null)
                generalProfile.setEmail(generalProfileRequest.getEmail());
            if(generalProfileRequest.getPermanentAddress() != null)
                generalProfile.setPermanentAddress(generalProfileRequest.getPermanentAddress());
            if(generalProfileRequest.getCurrentAddress() != null)
                generalProfile.setCurrentAddress(generalProfileRequest.getCurrentAddress());
            if(generalProfileRequest.getJob() != null)
                generalProfile.setJob(generalProfileRequest.getJob());
            if(generalProfileRequest.getWorkspace() != null)
                generalProfile.setWorkspace(generalProfileRequest.getWorkspace());
            if(generalProfileRequest.getTemperaryAddress() != null)
                generalProfile.setTemperaryAddress(generalProfileRequest.getTemperaryAddress());
            if(generalProfileRequest.getTemporaryResidenceExpiration() != null)
                generalProfile.setTemporaryResidenceExpiration(generalProfileRequest.getTemporaryResidenceExpiration());
            if(generalProfileRequest.getHostName() != null)
                generalProfile.setHostName(generalProfile.getHostName());
            if(generalProfileRequest.getCmndCccdHost() != null)
                generalProfile.setCmndCccdHost(generalProfileRequest.getCmndCccdHost());
            if(generalProfileRequest.getRelationshipHost() != null)
                generalProfile.setRelationshipHost(generalProfileRequest.getRelationshipHost());
            if(generalProfileRequest.getRelationshipDeclarent() != null)
                generalProfile.setRelationshipDeclarent(generalProfileRequest.getRelationshipDeclarent());
            if(generalProfileRequest.getCaseProfile() != null)
                generalProfile.setCaseProfile(generalProfileRequest.getCaseProfile());
            generalProfileResponsitory.save(generalProfile);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public Boolean deleteGeneralProfile(Long id){
        try{
            GeneralProfile generalProfile = generalProfileResponsitory.findByIdAndIsDelete(id, 0).orElseThrow(()->new RuntimeException("Không tìm thấy"));
            generalProfile.setIsDelete(1);
            generalProfileResponsitory.save(generalProfile);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
