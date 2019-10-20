package com.hyeran.study.user

data class ReqSignUpDto(
        val userId: String,
        val password: String,
        val name: String)