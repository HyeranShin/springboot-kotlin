package com.hyeran.study.like.service

import com.hyeran.study.like.dto.ReqLikeDto
import com.hyeran.study.like.domain.LikeType
import com.hyeran.study.like.domain.Like
import com.hyeran.study.like.domain.LikeRepository
import com.hyeran.study.post.domain.PostRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import javax.transaction.Transactional

@Service
class LikeService(val likeRepository: LikeRepository, val postRepository: PostRepository) {

    @Transactional
    fun requestLike(reqLikeDto: ReqLikeDto): LikeType {
        val like = likeRepository.save(Like(likeType = reqLikeDto.likeType, userId = reqLikeDto.userId, postId = reqLikeDto.postId))
        val post = postRepository.findById(reqLikeDto.postId)
                .orElseThrow { RuntimeException() }

        if (like.isLike()) {
            post.increaseLikeCnt()
        } else {
            post.increaseDislikeCnt()
        }

        return like.likeType
    }

    @Transactional
    fun cancelLike(userId: Long, postId: Long): LikeType {
        val like = likeRepository.findByUserIdAndPostId(userId, postId)
                .orElseThrow { RuntimeException() }
        val post = postRepository.findById(postId)
                .orElseThrow { RuntimeException() }

        if (like.isLike()) {
            post.decreaseLikeCnt()
        } else {
            post.decreaseDislikeCnt()
        }

        likeRepository.delete(like)
        return like.likeType
    }
}