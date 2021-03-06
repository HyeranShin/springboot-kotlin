package com.hyeran.study.user.controller

import com.hyeran.study.user.service.UserService
import com.hyeran.study.user.dto.ReqSignInDto
import com.hyeran.study.user.dto.ReqSignUpDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
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