package com.dumbdodo.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "M_MEMBER")
@AttributeOverrides({
        @AttributeOverride(name = "createdDate", column =
        @Column(name = "CREATED_DATE")),
        @AttributeOverride(name = "createdBy", column =
        @Column(name = "CREATED_BY")),
        @AttributeOverride(name = "updatedDate", column =
        @Column(name = "UPDATED_DATE")),
        @AttributeOverride(name = "updatedBy", column =
        @Column(name = "UPDATED_BY")),
        @AttributeOverride(name = "tenantId", column =
        @Column(name = "TENANT_ID")),
        @AttributeOverride(name = "guid", column =
        @Column(name = "GLOBAL_ID"))})

@Getter
@Setter
@NoArgsConstructor
public class Member extends BaseEntity{

    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MEMBER_NAME")
    private String name;

    @Column(name = "MEMBER_EMAIL")
    private String email;

    @Column(name = "MEMBER_DESCRIPTION")
    private String description;

    @Column(name = "MEMBER_PASSWORD")
    private String password;
}
