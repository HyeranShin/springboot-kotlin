package com.hyeran.study.comment.domain

import com.hyeran.study.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "comments_hyeran")
class Comment private constructor(id: Long?, content: String, writer: String, userId: Long, postId: Long) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = id
        private set
    var content: String = content
        private set
    var writer: String = writer
        private set
    var userId: Long = userId
        private set
    var postId: Long = postId
        private set

    constructor(content: String, writer: String, userId: Long, postId: Long) : this(null, content, writer, userId, postId)
}