package com.dumbdodo.member.controller;

import com.dumbdodo.member.common.Constants;
import com.dumbdodo.member.dto.BaseResponse;
import com.dumbdodo.member.dto.CreateMemberDto;
import com.dumbdodo.member.dto.MemberResponseDto;
import com.dumbdodo.member.service.MemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/member")
@Api(value = "Member", description = "Rest endpoints for member management apis")
public class MemberController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;

    @PutMapping("/")
    @ApiOperation(value = "Create member")
    public @ResponseBody
    ResponseEntity<BaseResponse> addMember(@RequestBody CreateMemberDto memberDto) throws JsonProcessingException {
        memberService.saveMember(memberDto);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(Constants.SUCCESS);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/")
    @ApiOperation(value = "Get a list of all member")
    public @ResponseBody
    ResponseEntity<List<MemberResponseDto>> getMembers() {
        return new ResponseEntity<>(memberService.getAllMembers(), HttpStatus.OK);
    }

    @GetMapping("/{memberId}")
    @ApiOperation(value = "Get member by its memberId")
    public @ResponseBody
    ResponseEntity<MemberResponseDto> getMemberById(@ApiParam(name = "memberId", value = "Member Id", required = true, defaultValue = "")
                                                    @PathVariable(value = "memberId") Long memberId,
                                                    @RequestHeader(value = "tenantId", required = false) Long tenantId
    )

    {
        return new ResponseEntity<>(memberService.getMemberById(memberId), HttpStatus.OK);
    }

}
