package com.hyeran.study.post

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/post")
class PostController(val postService: PostService) {

    @GetMapping("/all-list/{userId}")
    fun getPostList(@PathVariable userId: Long): ResponseEntity<MutableList<ResListDto>> {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostList())
    }

    @PostMapping("/write/{userId}")
    fun writePost(@PathVariable userId: Long, @RequestBody reqWriteDto: ReqWriteDto): ResponseEntity<String> {
        val postId = postService.writePost(userId, reqWriteDto)
        return ResponseEntity.status(HttpStatus.CREATED).body("게시글 작성 성공 (id=$postId)")
    }

    @DeleteMapping("/delete/{userId}/{postId}")
    fun deletePost(@PathVariable userId: Long, @PathVariable postId: Long): ResponseEntity<String> {
        postService.deletePost(userId, postId)
        return ResponseEntity.status(HttpStatus.OK).body("게시글 삭제 완료")
    }

    @GetMapping("/my-posts/{userId}")
    fun getMyPosts(@PathVariable userId: Long): ResponseEntity<MutableList<ResMyPostsDto>> {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getMyPosts(userId))
    }
}
