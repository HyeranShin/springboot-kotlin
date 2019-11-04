package com.hyeran.study.post

import com.hyeran.study.user.UserRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.stream.Collectors

@Service
class PostService(val postRepository: PostRepository, val userRepository: UserRepository) {

    fun getAllPosts(): MutableList<ResAllPostsDto>? {
        return postRepository.findAll()
                .stream()
                .map { post: Post -> ResAllPostsDto(post.id!!, post.title, post.content, post.writer, post.likeCnt, post.dislikeCnt) }
                .collect(Collectors.toList())
    }

    fun writePost(reqWriteDto: ReqWriteDto): Long {
        val user = userRepository.findById(reqWriteDto.userId)
                .orElseThrow { RuntimeException() }
        val post = Post(title = reqWriteDto.title, content = reqWriteDto.content, writer = user.name, userId = user.id!!)
        return postRepository.save(post).id!!
    }

    fun deletePost(postId: Long) {
        postRepository.deleteById(postId)
    }
}