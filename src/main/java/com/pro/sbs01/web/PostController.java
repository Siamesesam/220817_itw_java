package com.pro.sbs01.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pro.sbs01.domain.Post;
import com.pro.sbs01.domain.Team;
import com.pro.sbs01.dto.PostCreateDto;
import com.pro.sbs01.dto.PostUpdateDto;
import com.pro.sbs01.service.PostService;
import com.pro.sbs01.service.TeamService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping
public class PostController {
    
    private final TeamService teamService;
    
    private final PostService postService;
    
    @GetMapping({"/post/detail", "/post/modify"})
    // 컨트롤러 메서드가 2개 이상의 요청 주소를 처리할 때는 mapping에서 요청 주소를 배열로 설정.
    public void detail(Integer id, Model model) {
        log.info("postController datail(id={})", id);
        log.info("postController modify(id={})", id);
        
            Post post = postService.readIndex(id);
        
        model.addAttribute("post", post);
        
    }
    
    @GetMapping("/post/create")
    public void create(Integer id, Model model) {
        log.info("PostController Get create()");
        
    }
    
    @PostMapping("/post/create")
    public String create(PostCreateDto dto, RedirectAttributes attrs, Integer id) {
        log.info("PostController Post create() dto = {}", dto);
        log.info("PostController create teamId = {}", id);
        
        dto.getAddTeamId(id);
        log.info("PostController Post create() dto2 = {}", dto);
        log.info("PostController Post create() dto.getTeamId = {}", dto.getTeamId());
        Post entity = postService.create(dto, id);
        log.info("PostController Post create() entity = {}", entity);
        attrs.addFlashAttribute("createdId", entity.getPostId());
        
        return "redirect:/team/list?id=" + id;
    }
    
    @PostMapping("/post/update")
    public String update(PostUpdateDto dto) {
        log.info("PostController update(dto = {})",dto);
        
        Integer postId = postService.update(dto);
        
        log.info("PostController postId={}", postId);
        
        return "redirect:/post/detail?id=" + dto.getId();
    }
    
    @PostMapping("/post/delete")
    public String delete(Integer id, RedirectAttributes attrs) {
        log.info("PostController delete(id={})", id);
        
        Integer postId = postService.delete(id);
        attrs.addFlashAttribute("deletedPostId", postId);
        log.info("postController delete postId = {}", postId);
        
        // 삭제 완료 후에는 목록 페이지로 이동(redirect) - PRG 패턴
        return "redirect:/";
    }
    
    
    
}
