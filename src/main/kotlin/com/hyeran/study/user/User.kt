package com.hyeran.study.user

import com.hyeran.study.BaseTimeEntity
import com.hyeran.study.comment.Comment
import com.hyeran.study.post.Post
import javax.persistence.*

@Entity
@Table(name = "users_hyeran")
class User(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
           var userId: String,
           var password: String,
           var name: String,
           var age: Int,
           @OneToMany(mappedBy = "user", fetch = FetchType.LAZY) var posts: MutableList<Post>? = null,
           @OneToMany(mappedBy = "user") var comments: MutableList<Comment>? = null) : BaseTimeEntity()