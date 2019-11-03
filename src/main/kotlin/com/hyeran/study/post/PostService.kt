package com.hyeran.study.post

import com.hyeran.study.user.UserRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.stream.Collectors
import javax.transaction.Transactional

@Service
class PostService(val postRepository: PostRepository, val userRepository: UserRepository) {

    fun getPostList(): MutableList<ResListDto>? {
        return postRepository.findAll()
                .stream()
                .map { post: Post -> ResListDto(post.id!!, post.title, post.content, post.writer, post.likeCnt, post.dislikeCnt) }
                .collect(Collectors.toList())
    }

    @Transactional
    fun writePost(userId: Long, reqWriteDto: ReqWriteDto): Long {
        val user = userRepository.findById(userId)
                .orElseThrow { RuntimeException() }
        val post = Post(title = reqWriteDto.title, content = reqWriteDto.content, writer = user.name, user = user)
        return postRepository.save(post).id!!
    }

    @Transactional
    fun deletePost(userId: Long, postId: Long) {
        val post = postRepository.findById(postId)
                .orElseThrow { RuntimeException() }
        if(post.user.id == userId) {
            postRepository.delete(post)
        }
        else {
            RuntimeException()
        }
    }

    fun getMyPosts(userId: Long): MutableList<ResMyPostsDto>? {
        return userRepository.findById(userId).orElseThrow { RuntimeException() }.posts!!
                .stream()
                .map { post: Post ->  ResMyPostsDto(post.id!!, post.title, post.content, post.likeCnt, post.dislikeCnt) }
                .collect(Collectors.toList())
    }
}