package com.bezkoder.spring.security.jwt.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeneralProfileRequest {
    //Thuộc tính chung hồ sơ
    private Integer districtId;
    private Integer wardId;
    private Integer isCopy;
    private Integer isHistory;
    private Integer status;
    private Integer isDelete;
    //Thuộc tính người đăng ký tạm trú
    private String name;
    private Date birthday;
    private String cmndCccd;
    private Integer gender;
    private String phone;
    private String email;
    private String permanentAddress;
    private String currentAddress;
    private String job;
    private String workspace;
    //Thuộc tính tạm trú
    private String temperaryAddress;
    private Date temporaryResidenceExpiration;
    private String hostName;
    private String cmndCccdHost;
    private String relationshipHost;
    private String relationshipDeclarent;
    private String noteDeclarent;

    //---------khoá ngoại

    private Integer typeProfileId;
    private String caseProfile;
    private Integer receiveResultId;
    private Integer typeNotificationId;
}
