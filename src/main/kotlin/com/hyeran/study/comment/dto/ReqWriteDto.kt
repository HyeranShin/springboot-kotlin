package com.hyeran.study.comment.dto

data class ReqWriteDto(
        val userId: Long,
        val postId: Long,
        val writer: String,
        val content: String
)