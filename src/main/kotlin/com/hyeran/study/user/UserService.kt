package com.hyeran.study.user

import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.stream.Collectors
import javax.transaction.Transactional


@Service
class UserService(val userRepository: UserRepository) {
    fun signUp(reqSignUpDto: ReqSignUpDto): User {
        val user = User(reqSignUpDto.userId, reqSignUpDto.password, reqSignUpDto.name, reqSignUpDto.age)
        return userRepository.save(user)
    }

    fun signIn(reqSignInDto: ReqSignInDto): User {
        return userRepository.findByUserIdAndPassword(reqSignInDto.userId, reqSignInDto.password)
                .orElseThrow { RuntimeException() }
    }
}
