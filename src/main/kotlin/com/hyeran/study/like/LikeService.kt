package com.hyeran.study.like

import com.hyeran.study.post.PostRepository
import com.hyeran.study.user.UserRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class LikeService(val likeRepository: LikeRepository, val userRepository: UserRepository, val postRepository: PostRepository) {

    fun requestLike(userId: Long, postId: Long, reqLikeDto: ReqLikeDto) {
        likeRepository.save(Like(type = reqLikeDto.type, user = userRepository.findById(userId).orElseThrow { RuntimeException() },
                post = postRepository.findById(postId).orElseThrow { RuntimeException() }))
    }

    fun cancelLike(userId: Long, postId: Long): Type {
        val like = likeRepository.findByUserAndPost(userRepository.findById(userId).orElseThrow { RuntimeException() },
                postRepository.findById(postId).orElseThrow { RuntimeException() })
                .orElseThrow { RuntimeException() }
        likeRepository.delete(like)
        return like.type
    }
}