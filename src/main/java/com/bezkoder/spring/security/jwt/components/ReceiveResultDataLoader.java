package com.bezkoder.spring.security.jwt.components;

import com.bezkoder.spring.security.jwt.models.ReceiveResult;
import com.bezkoder.spring.security.jwt.repository.ReceiveResultsResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReceiveResultDataLoader implements CommandLineRunner {
    final private ReceiveResultsResponsitory receiveResultsResponsitory;

    @Autowired
    public ReceiveResultDataLoader(ReceiveResultsResponsitory receiveResultsResponsitory){
        this.receiveResultsResponsitory = receiveResultsResponsitory;
    }

    @Override
    public void run(String... args) throws Exception {
        long count = receiveResultsResponsitory.count();

        if(count == 0){
            ReceiveResult receiveResult = new ReceiveResult("Nhận qua cổng tạm trú");
            ReceiveResult receiveResult1 = new ReceiveResult("Nhận trực tiếp");
            ReceiveResult receiveResult2 = new ReceiveResult("Nhận qua email");
            receiveResultsResponsitory.save(receiveResult);
            receiveResultsResponsitory.save(receiveResult1);
            receiveResultsResponsitory.save(receiveResult2);
        }
    }
}
