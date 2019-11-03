package com.hyeran.study.post

data class ResMyPostsDto (
        val id: Long,
        val title: String,
        val content: String,
        val like_cnt: Long,
        val dislike_cnt: Long
)