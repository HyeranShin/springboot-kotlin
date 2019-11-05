package com.hyeran.study.post.dto

data class ReqWriteDto(
        val userId: Long,
        val title: String,
        val content: String
)