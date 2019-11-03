package com.hyeran.study.comment

import com.hyeran.study.BaseTimeEntity
import com.hyeran.study.post.Post
import com.hyeran.study.user.User
import javax.persistence.*

@Entity
@Table(name = "comments_hyeran")
class Comment(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
              var content: String,
              var writer: String,
              @ManyToOne @JoinColumn(name = "userId") var user: User,
              @ManyToOne @JoinColumn(name = "postId") var post: Post) : BaseTimeEntity()