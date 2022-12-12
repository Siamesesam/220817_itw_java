package com.pro.sbs01.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pro.sbs01.service.ActivityService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping
public class ActivityController {

    private final ActivityService activityService;
    
    
    
}
