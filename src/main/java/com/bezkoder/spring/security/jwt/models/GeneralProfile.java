package com.bezkoder.spring.security.jwt.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "general_profiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeneralProfile extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Thuộc tính chung hồ sơ
    @NotBlank
    @NotNull
    private Integer districtId;

    @NotBlank
    @NotNull
    private Integer wardId;

    private Integer isCopy;
    private Integer isHistory;

    private Integer status;
    private Integer isDelete;


    //Thuộc tính người đăng ký tạm trú
    @NotBlank
    private String name;

    @NotBlank
    private Date birthday;

    @NotBlank
    @Size(min = 9, max = 12)
    private String cmndCccd;

    @NotBlank
    private Integer gender;

    @Size(min = 10, max = 10)
    @Pattern(regexp = "\\d{10}", message = "Số điện thoại không hợp lệ")
    private String phone;

    @Email
    private String email;

    @NotBlank
    private String permanentAddress;

    @NotBlank
    private String currentAddress;

    private String job;

    private String workspace;

    //Thuộc tính tạm trú
    @NotBlank
    private String temperaryAddress;

    @NotBlank
    private Date temporaryResidenceExpiration;

    @NotBlank
    @Size(max = 50)
    private String hostName;

    @NotBlank
    @Size(min = 9, max = 12)
    private String cmndCccdHost;

    @NotBlank
    @Size(max = 50)
    private String relationshipHost;

    @NotBlank
    @Size(max = 50)
    private String relationshipDeclarent;

    private String noteDeclarent;

    //---------khoá ngoại

    @ManyToOne
    @JoinColumn(name = "type_profile_id")
    private TypeProfile typeProfile;

    @NotBlank
    private String caseProfile;

    @ManyToOne
    @JoinColumn(name = "receive_result_id")
    private ReceiveResult receiveResult;

    @ManyToOne
    @JoinColumn(name = "type_notification_id")
    private TypeNotification typeNotification;
}
