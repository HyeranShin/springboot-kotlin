package com.hyeran.study.post.service

import com.hyeran.study.comment.domain.CommentRepository
import com.hyeran.study.like.domain.LikeRepository
import com.hyeran.study.post.dto.ReqWriteDto
import com.hyeran.study.post.dto.ResPostsDto
import com.hyeran.study.post.domain.Post
import com.hyeran.study.post.domain.PostRepository
import com.hyeran.study.user.domain.UserRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.stream.Collectors

@Service
class PostService(val postRepository: PostRepository, val userRepository: UserRepository,
                  val commentRepository: CommentRepository, val likeRepository: LikeRepository) {

    fun getAllPosts(): MutableList<ResPostsDto>? {
        return postRepository.findAll()
                .stream()
                .map { post: Post -> ResPostsDto(post.id!!, post.title, post.content, post.writer, post.likeCnt, post.dislikeCnt) }
                .collect(Collectors.toList())
    }

    fun getMy10Posts(userId: Long, page: Int): MutableList<ResPostsDto>? {
        val pageable: Pageable = PageRequest.of(page, 10)   // Sort.Direction.DESC, "createTime" 추가하면 최신순
        return postRepository.findAllByUserId(userId, pageable)
                .stream()
                .map { post: Post -> ResPostsDto(post.id!!, post.title, post.content, post.writer, post.likeCnt, post.dislikeCnt) }
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
        deleteRelatedComments(postId)
        deleteRelatedLikes(postId)
    }

    fun deleteRelatedComments(postId: Long) {
        val comments = commentRepository.findAllByPostId(postId)
        for(comment in comments) {
            commentRepository.delete(comment)
        }
    }

    fun deleteRelatedLikes(postId: Long) {
        val likes = likeRepository.findAllByPostId(postId)
        for(like in likes) {
            likeRepository.delete(like)
        }
    }
}