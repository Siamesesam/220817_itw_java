package com.pro.sbs01.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pro.sbs01.domain.Team;
import com.pro.sbs01.dto.TeamDto;
import com.pro.sbs01.service.TeamService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping
public class HomeController {

    private final TeamService teamService;
    
    @GetMapping("/")
    public String home(Model model) {
        log.info("home()");
        // 방목록 전체리스트
        List<Team> list = teamService.read(); 
        log.info("컨트롤러 리스트 불러옴 ");
        // 전체리스트 
        model.addAttribute("list", list);
        log.info("모델로 html에 보냄 ㅇㅇ ");
        
        return "home"; 
    }
    
    @GetMapping("/search")
    public String search(String keyword, Model model) {
        log.info("search(keyword={})", keyword);
        
        List<Team> list = teamService.search(keyword);
        model.addAttribute("list", list);
        
        return "home";
    }
    
    
}
