package com.hyeran.study.comment

import com.hyeran.study.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "comments_hyeran")
class Comment(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
              var content: String,
              var writer: String,
              var userId: Long,
              var postId: Long) : BaseTimeEntity()