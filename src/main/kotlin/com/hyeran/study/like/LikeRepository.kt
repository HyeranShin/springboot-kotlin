package com.hyeran.study.like

import com.hyeran.study.post.Post
import com.hyeran.study.user.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface LikeRepository : JpaRepository<Like, Long> {
    fun findByUserAndPost(user: User, post: Post) : Optional<Like>
}