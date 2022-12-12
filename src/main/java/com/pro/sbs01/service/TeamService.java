package com.pro.sbs01.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pro.sbs01.domain.Team;
import com.pro.sbs01.dto.TeamDto;
import com.pro.sbs01.repository.TeamRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class TeamService {

    private final TeamRepository teamRepository;
    
    
    @Transactional(readOnly = true) 
    public List<Team> read() {
        log.info("read()");
        
        return teamRepository.findByOrderByTeamIdDesc();
    }
    
    @Transactional(readOnly = true)
    public Team read(Integer id) {
        log.info("teamService readId={}", id);
        
        return teamRepository.findById(id).get();
    }
    
    @Transactional(readOnly = true) 
    public List<TeamDto> readMain() {
        log.info("teamRepository readCategory()");
        
        return teamRepository.findGetCategory(); // 여기 join 쿼리문
    }
    
    public List<Team> search(String keyword) {
        log.info("search(keyword={})", keyword);
        
        List<Team> list = new ArrayList<>();
        
        list = teamRepository.searchByKeyword(keyword);
        
        return list;
    }

    
    
    
    
}
