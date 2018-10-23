package com.dumbdodo.member.controller;

import com.dumbdodo.member.common.Constants;
import com.dumbdodo.member.dto.BaseResponse;
import com.dumbdodo.member.dto.CreateMemberDto;
import com.dumbdodo.member.dto.MemberResponseDto;
import com.dumbdodo.member.service.MemberService;
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
public class MemberController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;

    @PutMapping("/")
    public @ResponseBody
    ResponseEntity<BaseResponse> addMember(@RequestBody CreateMemberDto memberDto) {
        memberService.saveMember(memberDto);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(Constants.SUCCESS);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/")
    public @ResponseBody
    ResponseEntity<List<MemberResponseDto>> getMembers() {
        return new ResponseEntity<>(memberService.getAllMembers(), HttpStatus.OK);
    }

    @GetMapping("/{memberId}")
    public @ResponseBody
    ResponseEntity<MemberResponseDto> getMemberById(@PathVariable(value = "memberId") Long memberId) {
        return new ResponseEntity<>(memberService.getMemberById(memberId), HttpStatus.OK);
    }

}
