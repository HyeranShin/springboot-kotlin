package com.hyeran.study.like.domain

import com.hyeran.study.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "likes_hyeran")
class Like private constructor(id: Long?, type: Type, userId: Long, postId: Long) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = id
        private set
    var type: Type = type
        private set
    var userId: Long = userId
        private set
    var postId: Long = postId
        private set

    constructor(type: Type, userId: Long, postId: Long) : this(null, type, userId, postId)

    fun isLike() = type.isLike()
}