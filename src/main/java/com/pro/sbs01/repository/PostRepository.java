package com.pro.sbs01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pro.sbs01.domain.Post;
import com.pro.sbs01.dto.PostCreateDto;
import com.pro.sbs01.dto.PostCreateDto.PostCreateDtoBuilder;

public interface PostRepository  extends JpaRepository<Post, Integer>{

    // select * from POSTS order by ID desc
    List<Post> findByOrderByPostIdDesc();
    
    List<Post> findByTeamTeamIdOrderByPostIdDesc(Integer teamId);

    
    
//    @Query(
//"insert into POSTS (title, content, author, teamTeamId) VALUES ('test', 'test', 'test', 2)"            
//    )
//    Post saveDto(PostCreateDto dto);
//    
    
}
