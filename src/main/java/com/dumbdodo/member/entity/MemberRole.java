package com.dumbdodo.member.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "M_MEMBER_ROLE")
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
public class MemberRole extends BaseEntity {

    @Id
    @Column(name = "MEMBER_ROLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID")
    private Member member;

}
