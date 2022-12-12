package com.pro.sbs01.dto;

import com.pro.sbs01.domain.Category;
import com.pro.sbs01.domain.Team;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TeamDto {

    private Integer teamId;
    private String teamName;
    private String purpose;
    private String categoryName;
    private Integer teamMax;
    
    public static TeamDto fromEntity(Team t, Category c) {
        
        return TeamDto.builder()
                .teamId(t.getTeamId())
                .teamName(t.getTeamName())
                .purpose(t.getPurpose())
                .categoryName(c.getCategoryName())
                .teamMax(t.getTeamMax())
                .build();
    }
    
}
