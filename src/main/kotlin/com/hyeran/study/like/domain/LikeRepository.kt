package com.hyeran.study.like.domain

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface LikeRepository : JpaRepository<Like, Long> {
    fun findByUserIdAndPostId(userId: Long, postId: Long): Optional<Like>
    fun findAllByPostId(postId: Long): List<Like>
}