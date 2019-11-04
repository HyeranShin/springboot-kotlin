package com.hyeran.study.post

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
class PostController(val postService: PostService) {

    @GetMapping("")
    fun getAllPosts(): ResponseEntity<MutableList<ResAllPostsDto>> {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts())
    }

    @PostMapping("")
    fun writePost( @RequestBody reqWriteDto: ReqWriteDto): ResponseEntity<String> {
        val postId = postService.writePost(reqWriteDto)
        return ResponseEntity.status(HttpStatus.CREATED).body("게시글 작성 성공 (id=$postId)")
    }

    @DeleteMapping("/{postId}")
    fun deletePost(@PathVariable postId: Long): ResponseEntity<String> {
        postService.deletePost(postId)
        return ResponseEntity.status(HttpStatus.OK).body("게시글 삭제 완료")
    }
}
