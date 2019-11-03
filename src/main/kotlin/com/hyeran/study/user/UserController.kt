package com.hyeran.study.user

import com.hyeran.study.post.Post
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException

@RestController
@RequestMapping("/user")
class UserController(val userService: UserService, val userRepository: UserRepository) {

    @PostMapping("/sign-up")
    fun signUp(@RequestBody reqSignUpDto: ReqSignUpDto): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공 (id=${userService.signUp(reqSignUpDto)})")
    }

    @PostMapping("/sign-in")
    fun signIn(@RequestBody reqSignInDto: ReqSignInDto): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.OK).body("로그인 성공 (id=${userService.signIn(reqSignInDto)})")
    }

    @GetMapping("/{id}")
    fun test(@PathVariable id: Long): MutableList<Post>? {
        return userRepository.findById(id).orElseThrow { RuntimeException() }.posts
    }
}