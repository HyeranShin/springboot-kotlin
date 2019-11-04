package com.hyeran.study.like

data class ReqLikeDto(
        val userId: Long,
        val postId: Long,
        val type: Type
)