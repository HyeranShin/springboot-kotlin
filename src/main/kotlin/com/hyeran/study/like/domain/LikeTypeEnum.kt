package com.hyeran.study.like.domain

enum class Type {
    LIKE {
        override fun isLike() = true
    },
    DISLIKE {
        override fun isLike() = false
    };
    abstract fun isLike(): Boolean
}