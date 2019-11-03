package com.hyeran.study.like

import com.hyeran.study.post.PostRepository
import com.hyeran.study.user.UserRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import javax.transaction.Transactional

@Service
class LikeService(val likeRepository: LikeRepository, val userRepository: UserRepository, val postRepository: PostRepository) {

    @Transactional
    fun requestLike(userId: Long, postId: Long, reqLikeDto: ReqLikeDto) {
        val like = likeRepository.save(Like(type = reqLikeDto.type, user = userRepository.findById(userId).orElseThrow { RuntimeException() },
                post = postRepository.findById(postId).orElseThrow { RuntimeException() }))
        if(like.type == Type.LIKE) {
            like.post.likeCnt++
        }
        else {
            like.post.dislikeCnt++
        }
    }

    @Transactional
    fun cancelLike(userId: Long, postId: Long): Type {
        val like = likeRepository.findByUserAndPost(userRepository.findById(userId).orElseThrow { RuntimeException() },
                postRepository.findById(postId).orElseThrow { RuntimeException() })
                .orElseThrow { RuntimeException() }
        if(like.type == Type.LIKE) {
            like.post.likeCnt--
        }
        else {
            like.post.dislikeCnt--
        }
        likeRepository.delete(like)
        return like.type
    }
}