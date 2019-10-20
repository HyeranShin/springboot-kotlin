package com.hyeran.study.user

import org.springframework.stereotype.Service
import java.lang.RuntimeException
import javax.persistence.NoResultException
import java.util.stream.Collectors



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

    fun edit(reqEditDto: ReqEditDto) {
        val user = userRepository.findByUserId(reqEditDto.userId)
                .orElseThrow { RuntimeException() }
        reqEditDto.nameToChange?.let {
            user.name = it
        }
        reqEditDto.passwordToChange?.let {
            user.password = it
        }
        userRepository.save(user)
    }

    fun delete(reqDeleteDto: ReqDeleteDto) {
        val user = userRepository.findByUserIdAndPassword(reqDeleteDto.userId, reqDeleteDto.password)
                .orElseThrow { RuntimeException() }
        userRepository.delete(user)
    }

    fun getUserList() : List<ResUserListDto> {
        return userRepository.findAll()
                .stream()
                .map { user: User -> ResUserListDto(user.userId, user.name) }
                .collect(Collectors.toList())
    }
}
