package com.hyeran.study.user

import org.springframework.stereotype.Service
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
}
