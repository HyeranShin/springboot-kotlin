package com.hyeran.study.user

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(val userService: UserService) {

    @PostMapping("/sign-up")
    fun signUp(@RequestBody reqSignUpDto: ReqSignUpDto): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공 (id=${userService.signUp(reqSignUpDto)})")
    }

    @PostMapping("/sign-in")
    fun signIn(@RequestBody reqSignInDto: ReqSignInDto): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.OK).body("로그인 성공 (id=${userService.signIn(reqSignInDto)})")
    }
}