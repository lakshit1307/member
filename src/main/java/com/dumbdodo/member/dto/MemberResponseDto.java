package com.dumbdodo.member.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberResponseDto {

    private Long id;

    private String name;

    private String email;

    private String description;

    private String password;

    private Set<RoleResponseDto> roles;
}
