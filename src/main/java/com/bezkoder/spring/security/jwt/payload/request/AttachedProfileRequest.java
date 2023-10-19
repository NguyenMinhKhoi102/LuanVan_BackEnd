package com.bezkoder.spring.security.jwt.payload.request;

import com.bezkoder.spring.security.jwt.models.GeneralProfile;
import com.bezkoder.spring.security.jwt.models.TemporaryResidenceProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttachedProfileRequest {
    private String name;
    private String path;
    private String note;
    private Integer isCopy;
    private Long generalProfileId;
    private Long temporaryResidenceProfileId;
}
