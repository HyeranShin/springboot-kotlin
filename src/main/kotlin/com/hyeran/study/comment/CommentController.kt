package com.hyeran.study.comment

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/comments")
class CommentController(val commentService: CommentService) {

    @PostMapping("")
    fun writeComment(@RequestBody reqWriteDto: ReqWriteDto): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.CREATED).body("댓글 작성 성공 (id=${commentService.writeComment(reqWriteDto)})")
    }

    @DeleteMapping("/{commentId}")
    fun deleteComment(@PathVariable commentId: Long): ResponseEntity<String> {
        commentService.deleteComment(commentId)
        return ResponseEntity.status(HttpStatus.OK).body("댓글 삭제 성공")
    }
}