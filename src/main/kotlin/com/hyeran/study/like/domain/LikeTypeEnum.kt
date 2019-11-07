package com.hyeran.study.like.domain

enum class LikeType {
    LIKE {
        override fun isLike() = true
    },
    DISLIKE {
        override fun isLike() = false
    };
    abstract fun isLike(): Boolean
}