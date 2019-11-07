package com.hyeran.study.like.dto

import com.hyeran.study.like.domain.LikeType

data class ReqLikeDto(
        val userId: Long,
        val postId: Long,
        val likeType: LikeType
)