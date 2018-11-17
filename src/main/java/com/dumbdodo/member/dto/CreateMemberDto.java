package com.dumbdodo.member.dto;

import com.dumbdodo.member.common.ErrorCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
public class CreateMemberDto implements Serializable {

    @ApiModelProperty(value = "Name of the member", required = true)
    @NotNull(message = ErrorCode.MEMBER_NAME_REQUIRED)
    @NotBlank(message = ErrorCode.MEMBER_NAME_REQUIRED)
    private String name;

    @ApiModelProperty(value = "Email of the member", required = true)
    @NotNull(message = ErrorCode.MEMBER_EMAIL_REQUIRED)
    @NotBlank(message = ErrorCode.MEMBER_EMAIL_REQUIRED)
    private String email;

    @ApiModelProperty(value = "Password of the member", required = true)
    @NotNull(message = ErrorCode.MEMBER_PASSWORD_REQUIRED)
    @NotBlank(message = ErrorCode.MEMBER_PASSWORD_REQUIRED)
    private String password;

    @ApiModelProperty(value = "Description of the member", required = true)
    private String description;

}
