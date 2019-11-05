package com.hyeran.study.user.dto

data class ReqSignUpDto(
        val userId: String,
        val password: String,
        val name: String,
        val age: Int
)