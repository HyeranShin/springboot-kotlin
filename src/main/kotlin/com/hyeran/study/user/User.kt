package com.hyeran.study.user

import javax.persistence.*

@Entity
@Table(name = "UserHyeran")
class User(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
           var userId: String,
           var password: String,
           var name: String) {

    // 부생성자 → id에 일일이 null을 넣어주지 않아도 됨
    constructor(userId: String, password: String, name: String) : this(null, userId, password, name)
}