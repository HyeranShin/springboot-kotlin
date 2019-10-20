package com.hyeran.study.user

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @PutMapping("/edit")
    fun edit(@RequestBody reqEditDto: ReqEditDto): ResponseEntity<String> {
        userService.edit(reqEditDto)
        return ResponseEntity.status(HttpStatus.OK).body("회원정보 수정 성공")
    }

    @DeleteMapping("/delete")
    fun delete(@RequestBody reqDeleteDto: ReqDeleteDto): ResponseEntity<String> {
        userService.delete(reqDeleteDto)
        return ResponseEntity.status(HttpStatus.OK).body("회원탈퇴 성공")
    }

    @GetMapping("/user-list")
    fun getUserList(): ResponseEntity<List<ResUserListDto>> {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserList())
    }
}