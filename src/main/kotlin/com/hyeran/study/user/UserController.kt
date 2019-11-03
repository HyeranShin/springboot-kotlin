package com.hyeran.study.user

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class UserController(val userService: UserService) {

    @PostMapping("/sign-up")
    fun signUp(@RequestBody reqSignUpDto: ReqSignUpDto): ResponseEntity<String> {
        val user = userService.signUp(reqSignUpDto)
        return ResponseEntity.status(HttpStatus.OK).body("회원가입 성공 (id=${user.id})")
    }

    @PostMapping("/sign-in")
    fun signIn(@RequestBody reqSignInDto: ReqSignInDto): ResponseEntity<String> {
        val user = userService.signIn(reqSignInDto)
        return ResponseEntity.status(HttpStatus.OK).body("로그인 성공 (id=${user.id})")
    }
}