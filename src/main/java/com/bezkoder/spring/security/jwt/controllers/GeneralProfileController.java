package com.bezkoder.spring.security.jwt.controllers;

import com.bezkoder.spring.security.jwt.common.UrlConstants;
import com.bezkoder.spring.security.jwt.payload.request.GeneralProfileRequest;
import com.bezkoder.spring.security.jwt.payload.response.MessageResponse;
import com.bezkoder.spring.security.jwt.security.services.GeneralProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(UrlConstants.HO_SO_CHUNG)
public class GeneralProfileController{

    @Autowired
    GeneralProfileService generalProfileService;

    @GetMapping(UrlConstants.INFO)
    @PreAuthorize("hasRole('USER') or hasRole('PROVINCE') or hasRole('DISTRICT') or hasRole('WARD') or hasRole('ADMIN')")
    public ResponseEntity infoGeneralProfile(@RequestParam Long id){
        return ResponseEntity.ok(generalProfileService.infoGeneralProfile(id));
    }

    @GetMapping(UrlConstants.LIST)
    @PreAuthorize("hasRole('USER') or hasRole('PROVINCE') or hasRole('DISTRICT') or hasRole('WARD') or hasRole('ADMIN')")
    public ResponseEntity listGeneralProfiles(){
        return ResponseEntity.ok(generalProfileService.listGeneralProfiles());
    }

    @PostMapping(UrlConstants.ADD)
    @PreAuthorize("hasRole('USER') or hasRole('PROVINCE') or hasRole('DISTRICT') or hasRole('WARD') or hasRole('ADMIN')")
    public ResponseEntity addGeneralProfile(@RequestBody GeneralProfileRequest generalProfileRequest){
        Boolean result = generalProfileService.addGeneralProfile(generalProfileRequest);
        return result ?
                ResponseEntity.ok(new MessageResponse("Thêm thành công")) :
                ResponseEntity.badRequest().build();
    }

    @PutMapping(UrlConstants.UPDATE)
    @PreAuthorize("hasRole('USER') or hasRole('PROVINCE') or hasRole('DISTRICT') or hasRole('WARD') or hasRole('ADMIN')")
    public ResponseEntity updateGeneralProfile(@RequestParam Long id, @RequestBody GeneralProfileRequest generalProfileRequest){
        Boolean result = generalProfileService.updateGeneralProfile(id, generalProfileRequest);
        return result ?
                ResponseEntity.ok(new MessageResponse("Cập nhật thành công")) :
                ResponseEntity.badRequest().build();
    }

    @DeleteMapping(UrlConstants.DELETE)
    @PreAuthorize("hasRole('USER') or hasRole('PROVINCE') or hasRole('DISTRICT') or hasRole('WARD') or hasRole('ADMIN')")
    public ResponseEntity deleteGeneralProfile(@RequestParam Long id){
        Boolean result = generalProfileService.deleteGeneralProfile(id);
        return result ?
                ResponseEntity.ok(new MessageResponse("Xoá thành công")) :
                ResponseEntity.badRequest().build();
    }
}
