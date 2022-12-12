package com.pro.sbs01.dto;

import java.time.LocalDateTime;

import com.pro.sbs01.domain.Activity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ActivityReadDto {

    private Integer activityId;
    private Integer teamId;
    private String play;
    private Integer budget;
    private LocalDateTime startTime;
    
//    public static ActivityReadDto fromEntity(Activity entity) {
//        
//        return ActivityReadDto.builder()
//                .activityId(entity.getActivityId())
//                .teamId(entity.getTeam().getTeamId())
//                .play(entity.getPlay())
//                .budget(entity.getBudget())
//                .startTime(entity.getStartTime())
//                .build();
//    }
}
