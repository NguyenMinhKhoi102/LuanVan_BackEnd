package com.bezkoder.spring.security.jwt.components;

import com.bezkoder.spring.security.jwt.models.TypeNotification;
import com.bezkoder.spring.security.jwt.repository.TypeNotificationResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TypeNotificationDataLoader implements CommandLineRunner {

    final private TypeNotificationResponsitory typeNotificationResponsitory;

    @Autowired
    public TypeNotificationDataLoader(TypeNotificationResponsitory typeNotificationResponsitory){
        this.typeNotificationResponsitory = typeNotificationResponsitory;
    }

    @Override
    public void run(String... args) throws Exception {
        long count = typeNotificationResponsitory.count();

        if(count == 0){
            TypeNotification typeNotification = new TypeNotification("Qua email");
            TypeNotification typeNotification1 = new TypeNotification("Qua cổng tạm trú");
            typeNotificationResponsitory.save(typeNotification);
            typeNotificationResponsitory.save(typeNotification1);
        }

    }
}
