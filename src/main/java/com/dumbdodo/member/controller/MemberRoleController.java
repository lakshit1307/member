package com.dumbdodo.member.controller;

import com.dumbdodo.member.common.Constants;
import com.dumbdodo.member.dto.*;
import com.dumbdodo.member.service.MemberRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/memberrole")
public class MemberRoleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberRoleController.class);

    @Autowired
    private MemberRoleService memberRoleService;

    @PutMapping("/")
    public @ResponseBody
    ResponseEntity<BaseResponse> addMemberRole(@RequestBody CreateMemberRoleDto createMemberRoleDto) {
        memberRoleService.saveMemberRoles(createMemberRoleDto);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(Constants.SUCCESS);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/")
    public @ResponseBody
    ResponseEntity<List<MemberRoleResponseDto>> getMemberRoles() {
        return new ResponseEntity<>(memberRoleService.getAllMemberRoles(), HttpStatus.OK);
    }

    @GetMapping("/{memberRoleId}")
    public @ResponseBody
    ResponseEntity<MemberRoleResponseDto> getMemberRoleById(@PathVariable(value = "memberRoleId") Long memberRoleId) {
        return new ResponseEntity<>(memberRoleService.getMemberRolesById(memberRoleId), HttpStatus.OK);
    }
}
