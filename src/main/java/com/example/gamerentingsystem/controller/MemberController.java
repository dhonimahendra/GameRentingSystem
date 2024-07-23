package com.example.gamerentingsystem.controller;

import com.example.gamerentingsystem.model.Member;
import com.example.gamerentingsystem.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteMember(@PathVariable Long id) {
    String responseMessage = memberService.deleteMember(id);
    return ResponseEntity.ok(responseMessage);
}


    @PostMapping("/{memberId}/loan/{gameId}")
    public Member loanGame(@PathVariable Long memberId, @PathVariable Long gameId) {
        return memberService.loanGame(memberId, gameId);
    }

    @PostMapping("/{memberId}/return/{gameId}")
    public Member returnGame(@PathVariable Long memberId, @PathVariable Long gameId) {
        return memberService.returnGame(memberId, gameId);
    }
}
