package com.hyeran.study.post

import com.hyeran.study.BaseTimeEntity
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
           @ManyToOne @JoinColumn(name = "userId") var user: User) : BaseTimeEntity() {
}