package com.hyeran.study.post.domain

import com.hyeran.study.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "posts_hyeran")
class Post private constructor(id: Long?, title: String, content: String, writer: String, likeCnt: Long, disLikeCnt: Long, userId: Long) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = id
    private set
    var title: String = title
        private set
    var content: String = content
        private set
    var writer: String = writer
        private set
    var likeCnt: Long = likeCnt
        private set
    var dislikeCnt: Long = disLikeCnt
        private set
    var userId: Long = userId

    constructor(title: String, content: String, writer: String, userId: Long): this(null, title, content, writer, 0, 0, userId)

    fun increaseLikeCnt() {
        this.likeCnt++
    }

    fun decreaseLikeCnt() {
        this.likeCnt--
    }

    fun increaseDislikeCnt() {
        this.dislikeCnt++
    }

    fun decreaseDislikeCnt() {
        this.dislikeCnt--
    }
}