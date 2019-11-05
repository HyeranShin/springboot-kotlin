package com.hyeran.study.comment.service

import com.hyeran.study.comment.domain.Comment
import com.hyeran.study.comment.domain.CommentRepository
import com.hyeran.study.comment.dto.ReqWriteDto
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CommentService(val commentRepository: CommentRepository) {

    fun writeComment(reqWriteDto: ReqWriteDto): Long {
        val comment = Comment(content = reqWriteDto.content, writer = reqWriteDto.writer, userId = reqWriteDto.userId, postId = reqWriteDto.postId)
        return commentRepository.save(comment).id!!
    }

    fun deleteComment(commentId: Long) {
        val comment = commentRepository.findById(commentId)
                .orElseThrow { RuntimeException() }
        commentRepository.delete(comment)
    }
}