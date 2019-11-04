package com.hyeran.study.post

data class ReqWriteDto(
        val userId: Long,
        val title: String,
        val content: String
)