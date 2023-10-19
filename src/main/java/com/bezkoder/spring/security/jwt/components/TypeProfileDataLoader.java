package com.bezkoder.spring.security.jwt.components;

import com.bezkoder.spring.security.jwt.models.TypeProfile;
import com.bezkoder.spring.security.jwt.repository.TypeProfileResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TypeProfileDataLoader implements CommandLineRunner {

    private final TypeProfileResponsitory typeProfileResponsitory;

    @Autowired
    public TypeProfileDataLoader(TypeProfileResponsitory typeProfileResponsitory){
        this.typeProfileResponsitory = typeProfileResponsitory;
    }

    @Override
    public void run(String... args) throws Exception {
        long count = typeProfileResponsitory.count();

        if(count == 0){
            TypeProfile typeProfile1 = new TypeProfile("Đăng ký tạm trú");
            TypeProfile typeProfile2 = new TypeProfile("Gia hạn tạm trú");
            TypeProfile typeProfile3 = new TypeProfile("Trích lục tạm trú");
            typeProfileResponsitory.save(typeProfile1);
            typeProfileResponsitory.save(typeProfile2);
            typeProfileResponsitory.save(typeProfile3);
        }
    }
}
