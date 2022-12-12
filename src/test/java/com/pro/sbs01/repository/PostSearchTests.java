package com.pro.sbs01.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pro.sbs01.domain.Team;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@SpringBootTest
public class PostSearchTests {
    
    @Autowired
    private TeamRepository teamRepository;
    
//    @Test
    public void testSearch() {
        String keyword = "여행";
        
        List<Team> list = teamRepository.searchByKeyword(keyword);
        
        
        
        
        for (Team t : list) {
            
            Assertions.assertTrue(t.getPurpose().toLowerCase().contains(keyword.toLowerCase()));
            log.info(t.toString());
        }
        
    }
    
//    @Test 
//    public void getCategory() {
//        List<Team> list = teamRepository.findGetCategory();
//        log.info("test 까지옴 ");
//        for (Team t : list) {
//            log.info("test for each문 반복중!!!!");
//            log.info(t.toString());
//        }
//        
//    }
    

}
