package com.hyeran.study.post.dto

import com.hyeran.study.like.domain.LikeType

data class ResPostsDetailDto(
        val id: Long,
        val title: String,
        val content: String,
        val writer: String,
        val like_cnt: Long,
        val dislike_cnt: Long,
        val i_liked: LikeType?,
        val comments: MutableList<ResPostsDetailCommentsDto>
)

data class ResPostsDetailCommentsDto(
        val writer: String,
        val content: String
)