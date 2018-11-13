package com.dumbdodo.member.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberResponseDto implements Serializable {

    private Long id;

    private String name;

    private String email;

    private String description;

    private String password;

    private Set<RoleResponseDto> roles;


}
