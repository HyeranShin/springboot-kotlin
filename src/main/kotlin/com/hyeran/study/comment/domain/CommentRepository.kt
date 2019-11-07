package com.hyeran.study.comment.domain

import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long> {
    fun findAllByPostId(postId: Long): List<Comment>
}