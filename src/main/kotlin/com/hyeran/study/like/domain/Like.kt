package com.hyeran.study.like.domain

import com.hyeran.study.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "likes_hyeran")
class Like private constructor(id: Long?, likeType: LikeType, userId: Long, postId: Long) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = id
        private set
    var likeType: LikeType = likeType
        private set
    var userId: Long = userId
        private set
    var postId: Long = postId
        private set

    constructor(likeType: LikeType, userId: Long, postId: Long) : this(null, likeType, userId, postId)

    fun isLike() = likeType.isLike()
}