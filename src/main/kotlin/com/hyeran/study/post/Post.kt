package com.hyeran.study.post

import com.hyeran.study.BaseTimeEntity
import com.hyeran.study.comment.Comment
import com.hyeran.study.like.LikeRepository
import com.hyeran.study.user.User
import javax.persistence.*

@Entity
@Table(name = "posts_hyeran")
class Post(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
           var title: String,
           var content: String,
           var writer: String,
           var likeCnt: Long = 0,
           var dislikeCnt: Long = 0,
           var userId: Long) : BaseTimeEntity() {

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