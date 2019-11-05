package com.hyeran.study.like.service

import com.hyeran.study.like.dto.ReqLikeDto
import com.hyeran.study.like.domain.Type
import com.hyeran.study.like.domain.Like
import com.hyeran.study.like.domain.LikeRepository
import com.hyeran.study.post.domain.PostRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import javax.transaction.Transactional

@Service
class LikeService(val likeRepository: LikeRepository, val postRepository: PostRepository) {

    @Transactional
    fun requestLike(reqLikeDto: ReqLikeDto): Type {
        val like = likeRepository.save(Like(type = reqLikeDto.type, userId = reqLikeDto.userId, postId = reqLikeDto.postId))
        val post = postRepository.findById(reqLikeDto.postId)
                .orElseThrow { RuntimeException() }
        if (like.type == Type.LIKE) {
            post.increaseLikeCnt()
        } else {
            post.increaseDislikeCnt()
        }
        return like.type
    }

    @Transactional
    fun cancelLike(userId: Long, postId: Long): Type {
        val like = likeRepository.findByUserIdAndPostId(userId, postId)
                .orElseThrow { RuntimeException() }
        val post = postRepository.findById(postId)
                .orElseThrow { RuntimeException() }
        if (like.type == Type.LIKE) {
            post.decreaseLikeCnt()
        } else {
            post.decreaseDislikeCnt()
        }
        likeRepository.delete(like)
        return like.type
    }
}