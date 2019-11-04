package com.hyeran.study.like

import com.hyeran.study.BaseTimeEntity
import com.hyeran.study.post.Post
import com.hyeran.study.user.User
import javax.persistence.*

@Entity
@Table(name = "likes_hyeran")
class Like(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
           var type: Type,
           var userId: Long,
           var postId: Long) : BaseTimeEntity()