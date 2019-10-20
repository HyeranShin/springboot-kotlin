package com.hyeran.study.user

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(val userService: UserService) {

    @PostMapping("/sign-up")
    fun signUp(@RequestBody reqSignUpDto: ReqSignUpDto): ResponseEntity<String> {
        userService.signUp(reqSignUpDto)
        return ResponseEntity.status(HttpStatus.OK).body("회원가입 성공")
    }

    @PostMapping("/sign-in")
    fun signIn(@RequestBody reqSignInDto: ReqSignInDto): ResponseEntity<String> {
        val name: String = userService.signIn(reqSignInDto)
        return ResponseEntity.status(HttpStatus.OK).body("${name}님 로그인 성공")
    }
}