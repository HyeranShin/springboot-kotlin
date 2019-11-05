package com.hyeran.study.post.dto

data class ResAllPostsDto(
        val id: Long,
        val title: String,
        val content: String,
        val writer: String,
        val like_cnt: Long,
        val dislike_cnt: Long
)