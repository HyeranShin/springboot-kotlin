package com.hyeran.study.user

import com.hyeran.study.post.Post
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException

@Service
class UserService(val userRepository: UserRepository) {

    fun signUp(reqSignUpDto: ReqSignUpDto): Long {
        val user = User(userId = reqSignUpDto.userId, password = reqSignUpDto.password, name = reqSignUpDto.name, age = reqSignUpDto.age)
        return userRepository.save(user).id!!
    }

    fun signIn(reqSignInDto: ReqSignInDto): Long {
        return userRepository.findByUserIdAndPassword(reqSignInDto.userId, reqSignInDto.password)
                .orElseThrow { RuntimeException() }.id!!
    }

    @Transactional
    fun test(id: Long): MutableList<Post>? {
        return userRepository.findById(id).orElseThrow { RuntimeException() }.posts
    }
}
