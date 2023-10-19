package com.bezkoder.spring.security.jwt.security.services;

import com.bezkoder.spring.security.jwt.models.TypeNotification;
import com.bezkoder.spring.security.jwt.payload.request.TypeNotificationRequest;
import com.bezkoder.spring.security.jwt.repository.TypeNotificationResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeNotificationService {

    @Autowired
    TypeNotificationResponsitory typeNotificationResponsitory;

    public TypeNotification infoTypeNotification(Integer id){
        return typeNotificationResponsitory.findByIdAndIsDelete(id, 0).orElseThrow(() -> new RuntimeException("Không tìm thấy"));
    }

    public List<TypeNotification> listTypeNotification(Boolean active){
        return active ?
                typeNotificationResponsitory.findAllByIsDeleteAndIsActive(0, 1) :
                typeNotificationResponsitory.findAllByIsDelete(0);
    }

    public Boolean addTypeNotification(TypeNotificationRequest typeNotificationRequest){
        try{
            TypeNotification typeNotification = TypeNotification.builder()
                    .name(typeNotificationRequest.getName())
                    .isActive(1)
                    .isDelete(0)
                    .build();
            typeNotificationResponsitory.save(typeNotification);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public Boolean updateTypeNotification(Integer id, TypeNotificationRequest typeNotificationRequest){
        try{
            TypeNotification typeNotification = typeNotificationResponsitory.findByIdAndIsDelete(id, 0).orElseThrow(() -> new RuntimeException("Không tìm thấy"));
            typeNotification.setName(typeNotificationRequest.getName() == null ? typeNotification.getName() : typeNotificationRequest.getName());
            typeNotification.setIsActive(typeNotificationRequest.getIsActive() == null ? typeNotification.getIsActive() : typeNotificationRequest.getIsActive());
            typeNotificationResponsitory.save(typeNotification);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public Boolean deleteTypeNotification(Integer id){
        try{
            TypeNotification typeNotification = typeNotificationResponsitory.findByIdAndIsDelete(id, 0).orElseThrow(() -> new RuntimeException("Không tìm thấy"));
            typeNotification.setIsDelete(1);
            typeNotificationResponsitory.save(typeNotification);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

}
