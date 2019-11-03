package com.hyeran.study.comment

import com.hyeran.study.post.PostRepository
import com.hyeran.study.user.UserRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CommentService(val commentRepository: CommentRepository, val userRepository: UserRepository, val postRepository: PostRepository) {

    fun writeComment(userId: Long, postId: Long, reqWriteDto: ReqWriteDto): Long {
        val user = userRepository.findById(userId)
                .orElseThrow { RuntimeException() }
        return commentRepository.save(Comment(content = reqWriteDto.content, writer = user.name, user = user,
                post = postRepository.findById(postId).orElseThrow { RuntimeException() })).id!!
    }

    fun deleteComment(userId: Long, postId: Long, commentId: Long) {
        val comment = commentRepository.findById(commentId)
                .orElseThrow { RuntimeException() }
        if(comment.user.id == userId && comment.post.id == postId) {
            commentRepository.delete(comment)
        }
        else {
            RuntimeException()
        }
    }
}