package com.pro.sbs01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pro.sbs01.domain.Team;
import com.pro.sbs01.dto.TeamDto;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    
    List<Team> findByOrderByTeamIdDesc();
    
    @Query(
"select t from TEAMS t where lower(t.purpose) like lower('%' || :keyword || '%') order by t.teamId desc"
    )
    List<Team> searchByKeyword(@Param(value = "keyword") String keyword);

    
    
    @Query(
"SELECT t.teamId, t.teamName, t.purpose, c.categoryName, t.teamMax FROM TEAMS t LEFT JOIN CATEGORYS c ON c.categoryId = t.categoryId"
    )
    List<TeamDto> findGetCategory();

    List<Team> findByCategoryIdOrderByCategoryIdDesc(Integer categoryId);
    
    
    
    
}


