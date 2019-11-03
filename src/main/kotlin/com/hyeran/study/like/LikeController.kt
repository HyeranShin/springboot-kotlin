package com.hyeran.study.like

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/like")
class LikeController(val likeService: LikeService) {

    @PostMapping("/request/{userId}/{postId}")
    fun requestLike(@PathVariable userId: Long, @PathVariable postId: Long, @RequestBody reqLikeDto: ReqLikeDto): ResponseEntity<String> {
        val likeType = if (reqLikeDto.type == Type.LIKE) {
            "좋아요"
        } else {
            "싫어요"
        }
        likeService.requestLike(userId, postId, reqLikeDto)
        return ResponseEntity.status(HttpStatus.CREATED).body("$likeType 요청 성공")
    }

    @DeleteMapping("/cancel/{userId}/{postId}")
    fun cancelLike(@PathVariable userId: Long, @PathVariable postId: Long): ResponseEntity<String> {
        val likeType = if (likeService.cancelLike(userId, postId) == Type.LIKE) {
            "좋아요"
        } else {
            "싫어요"
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("$likeType 취소 성공")
    }
}