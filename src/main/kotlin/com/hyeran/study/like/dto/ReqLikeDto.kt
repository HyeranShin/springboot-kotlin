package com.hyeran.study.like.dto

import com.hyeran.study.like.domain.Type

data class ReqLikeDto(
        val userId: Long,
        val postId: Long,
        val type: Type
)