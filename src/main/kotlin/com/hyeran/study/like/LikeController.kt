package com.hyeran.study.like

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/likes")
class LikeController(val likeService: LikeService) {

    @PostMapping("")
    fun requestLike(@RequestBody reqLikeDto: ReqLikeDto): ResponseEntity<String> {
        val likeType = likeService.requestLike(reqLikeDto)
        return ResponseEntity.status(HttpStatus.CREATED).body("$likeType 요청 성공")
    }

    @DeleteMapping("/{postId}/{userId}")
    fun cancelLike(@PathVariable userId: Long, @PathVariable postId: Long): ResponseEntity<String> {
        val likeType = likeService.cancelLike(userId, postId)
        return ResponseEntity.status(HttpStatus.CREATED).body("$likeType 취소 성공")
    }
}