package com.hyeran.study.user

data class ReqEditDto(
        val userId: String,
        val passwordToChange: String?,
        val nameToChange: String?)