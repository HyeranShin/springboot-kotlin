package com.hyeran.study.post.controller

import com.hyeran.study.post.service.PostService
import com.hyeran.study.post.dto.ReqWriteDto
import com.hyeran.study.post.dto.ResPostsDetailDto
import com.hyeran.study.post.dto.ResPostsDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class PostController(val postService: PostService) {

    @GetMapping("/posts")
    fun getAllPosts(): ResponseEntity<MutableList<ResPostsDto>> {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts())
    }

    @GetMapping("/users/{userId}/posts/detail/paging")
    fun get10PostsDetail(@PathVariable userId: Long,
                         @RequestParam page: Int): ResponseEntity<MutableList<ResPostsDetailDto>> {
        return ResponseEntity.status(HttpStatus.OK).body(postService.get10PostsDetail(userId, page))
    }

    @GetMapping("/users/{userId}/my-posts/paging")
    fun getMy10Posts(@PathVariable userId: Long,
                     @RequestParam page: Int): ResponseEntity<MutableList<ResPostsDto>> {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getMy10Posts(userId, page))
    }

    @PostMapping("/posts")
    fun writePost( @RequestBody reqWriteDto: ReqWriteDto): ResponseEntity<String> {
        val postId = postService.writePost(reqWriteDto)
        return ResponseEntity.status(HttpStatus.CREATED).body("게시글 작성 성공 (id=$postId)")
    }

    @DeleteMapping("/posts/{postId}")
    fun deletePost(@PathVariable postId: Long): ResponseEntity<String> {
        postService.deletePost(postId)
        return ResponseEntity.status(HttpStatus.OK).body("게시글 삭제 완료")
    }
}
