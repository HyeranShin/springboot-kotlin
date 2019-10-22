package com.hyeran.study.user

import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.stream.Collectors
import javax.transaction.Transactional


@Service
class UserService(val userRepository: UserRepository) {
    fun signUp(reqSignUpDto: ReqSignUpDto) {
        val user = User(reqSignUpDto.userId, reqSignUpDto.password, reqSignUpDto.name)
        userRepository.save(user)
    }

    fun signIn(reqSignInDto: ReqSignInDto): String {
        val user = userRepository.findByUserIdAndPassword(reqSignInDto.userId, reqSignInDto.password)
                .orElseThrow { RuntimeException() }
        return user.name
    }

    @Transactional
    fun edit(id: Long, reqEditDto: ReqEditDto) {
        val user = userRepository.findById(id)
                .orElseThrow { RuntimeException() }
        reqEditDto.name?.let {
            user.name = it
        }
        reqEditDto.password?.let {
            user.password = it
        }
    }

    @Transactional
    fun delete(id: Long) {
        val user = userRepository.findById(id)
                .orElseThrow { RuntimeException() }
        userRepository.delete(user)
    }

    fun getUserList() : List<ResUserListDto> {
        return userRepository.findAll()
                .stream()
                .map { user: User -> ResUserListDto(user.id!!, user.userId, user.name) }
                .collect(Collectors.toList())
    }
}
