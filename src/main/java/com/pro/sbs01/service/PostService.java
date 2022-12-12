package com.pro.sbs01.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pro.sbs01.domain.Post;
import com.pro.sbs01.domain.Team;
import com.pro.sbs01.dto.PostCreateDto;
import com.pro.sbs01.dto.PostReadDto;
import com.pro.sbs01.dto.PostUpdateDto;
import com.pro.sbs01.repository.PostRepository;
import com.pro.sbs01.repository.TeamRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor // final 필드를 초기화하는 생성자.
@Service // 스프링 컨텍스트에 Service 컴포넌트로 등록.
@Slf4j
public class PostService {

    private final TeamRepository teamRepository;
    
    private final PostRepository postRepository; // 생성자에 의한 의존성 주입.
    
    @Transactional(readOnly = true)
    public List<PostReadDto> read(Integer teamId) {
        log.info("postService read()");
        
        List<Post> list = postRepository.findByTeamTeamIdOrderByPostIdDesc(teamId);
        
        return list.stream().map(PostReadDto::fromEntity).toList();
    }
    
    @Transactional(readOnly = true)
    public Post readIndex(Integer id) {
        log.info("postService readIndex(Id) = {}", id);
        
        Post index = postRepository.findById(id).get();
        log.info("PostService readIndex index ={}", index);
        
        return index;
    }
    
    
    public Post create(PostCreateDto dto, Integer id) {
        log.info("PostService create(dto={}", dto);
        
        Team team = teamRepository.findById(dto.getTeamId()).get();
        log.info("PostService create(team = {}", team);
        
        Post post = Post.builder().team(team)
                .title(dto.getTitle())
                .content(dto.getContent())
                .author(dto.getAuthor())
                .build();
        log.info("PostService create(post = {}", post);
        
        Post entity = postRepository.save(post);
        
        log.info("PostService create(entity = {}", entity);
        
        return entity;
    }

    @Transactional
    public Integer update(PostUpdateDto dto) {
        log.info("postService update(dto={})", dto);
        
        Post entity = postRepository.findById(dto.getId()).get(); // (1)
        entity.update(dto.getTitle(), dto.getContent()); // (2)
        
        return entity.getPostId();
    }
    
    public Integer delete(Integer id) {
        log.info("postService delete(id={})", id);
        
        postRepository.deleteById(id);
        
        return id;
    }
    
}
