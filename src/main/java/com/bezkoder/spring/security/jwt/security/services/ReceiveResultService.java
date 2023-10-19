package com.bezkoder.spring.security.jwt.security.services;

import com.bezkoder.spring.security.jwt.models.ReceiveResult;
import com.bezkoder.spring.security.jwt.payload.request.ReceiveResultRequest;
import com.bezkoder.spring.security.jwt.repository.ReceiveResultsResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiveResultService {

    @Autowired
    ReceiveResultsResponsitory receiveResultsResponsitory;

    public ReceiveResult infoReceiveResult(Integer id){
        return receiveResultsResponsitory.findByIdAndIsDelete(id, 0).orElseThrow(()->new RuntimeException("Không tìm thấy"));
    }

    public List<ReceiveResult> listReceiveResults(Boolean active){
        return active ?
                receiveResultsResponsitory.findAllByIsDeleteAndIsActive(0, 1) :
                receiveResultsResponsitory.findAllByIsDelete(0);
    }

    public Boolean addReceiveResults(ReceiveResultRequest receiveResultRequest){
        try {
            ReceiveResult receiveResult = ReceiveResult.builder()
                    .name(receiveResultRequest.getName())
                    .isDelete(0)
                    .isActive(1)
                    .build();
            receiveResultsResponsitory.save(receiveResult);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public Boolean updateReceiveResults(Integer id, ReceiveResultRequest receiveResultRequest){
        try {
            ReceiveResult receiveResult = receiveResultsResponsitory.findByIdAndIsDelete(id, 0).orElseThrow(()->new RuntimeException("Không tìm thấy"));
            receiveResult.setName(receiveResultRequest.getName() == null ? receiveResult.getName() : receiveResultRequest.getName());
            receiveResult.setIsActive(receiveResultRequest.getIsActive() == null ? receiveResult.getIsActive() : receiveResultRequest.getIsActive());
            receiveResultsResponsitory.save(receiveResult);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public Boolean deleteReceiveResults(Integer id){
        try {
            ReceiveResult receiveResult = receiveResultsResponsitory.findByIdAndIsDelete(id, 0).orElseThrow(()->new RuntimeException("Không tìm thấy"));
            receiveResult.setIsDelete(1);
            receiveResultsResponsitory.save(receiveResult);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

}
