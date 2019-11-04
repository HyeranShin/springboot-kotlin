package com.hyeran.study.comment

data class ReqWriteDto(
        val userId: Long,
        val postId: Long,
        val writer: String,
        val content: String
)