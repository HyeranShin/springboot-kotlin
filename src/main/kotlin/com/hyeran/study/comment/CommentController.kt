package com.hyeran.study.comment

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/comment")
class CommentController(val commentService: CommentService) {

    @PostMapping("/write/{userId}/{postId}")
    fun writeComment(@PathVariable userId: Long, @PathVariable postId: Long, @RequestBody reqWriteDto: ReqWriteDto) : ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.CREATED).body("댓글 작성 성공 (id=${commentService.writeComment(userId, postId, reqWriteDto)})")
    }

    @DeleteMapping("/write/{userId}/{postId}/{commentId}")
    fun deleteComment(@PathVariable userId: Long, @PathVariable postId: Long, @PathVariable commentId: Long) : ResponseEntity<String> {
        commentService.deleteComment(userId, postId, commentId)
        return ResponseEntity.status(HttpStatus.OK).body("댓글 삭제 성공")
    }
}