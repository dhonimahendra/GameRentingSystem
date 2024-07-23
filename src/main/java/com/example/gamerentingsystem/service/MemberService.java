package com.example.gamerentingsystem.service;

import com.example.gamerentingsystem.model.Game;
import com.example.gamerentingsystem.model.Member;
import com.example.gamerentingsystem.repository.GameRepository;
import com.example.gamerentingsystem.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private GameRepository gameRepository;

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Transactional
    public String deleteMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
        memberRepository.deleteById(id);
        return "Member '" + member.getName() + "' was deleted successfully.";
    }
    
    @Transactional
    public Member loanGame(Long memberId, Long gameId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
        if (member.getLoanedGames().size() >= 3) {
            throw new RuntimeException("Cannot loan more than 3 games!");
        }

        Game game = gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found"));
        member.getLoanedGames().add(game);

        return memberRepository.save(member);
    }

    @Transactional
    public Member returnGame(Long memberId, Long gameId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found"));

        member.getLoanedGames().remove(game);
        return memberRepository.save(member);
    }
}
