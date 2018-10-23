package com.dumbdodo.member.controller;

import com.dumbdodo.member.common.Constants;
import com.dumbdodo.member.dto.BaseResponse;
import com.dumbdodo.member.dto.CreateRoleDto;
import com.dumbdodo.member.dto.RoleResponseDto;
import com.dumbdodo.member.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @PutMapping("/")
    public @ResponseBody
    ResponseEntity<BaseResponse> addRole(@RequestBody CreateRoleDto roleDto) {
        roleService.saveRole(roleDto);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(Constants.SUCCESS);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/")
    public @ResponseBody
    ResponseEntity<List<RoleResponseDto>> getRoles() {
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }

    @GetMapping("/{roleId}")
    public @ResponseBody
    ResponseEntity<RoleResponseDto> getRoleById(@PathVariable(value = "roleId") Long roleId) {
        return new ResponseEntity<>(roleService.getRoleById(roleId), HttpStatus.OK);
    }

}
