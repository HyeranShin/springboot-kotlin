package com.hyeran.study.user

import com.hyeran.study.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "users_hyeran")
class User(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
           var userId: String,
           var password: String,
           var name: String,
           var age: Int) : BaseTimeEntity()