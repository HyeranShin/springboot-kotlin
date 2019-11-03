package com.hyeran.study.user

import com.hyeran.study.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "users_hyeran")
class User(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
           var userId: String,
           var password: String,
           var name: String,
           var age: Int) : BaseTimeEntity() {

    // 부생성자 → id에 일일이 null을 넣어주지 않아도 됨
    constructor(userId: String, password: String, name: String, age: Int) : this(null, userId, password, name, age)
}