package com.microservices.kotlin.controllers

import com.microservices.kotlin.models.User
import com.microservices.kotlin.repositories.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users/")
class UserController(private val userRepository: UserRepository) {

    @GetMapping("")
    fun getUsers(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(this.userRepository.findAll())
    }

    @GetMapping("{id}")
    fun getUser(@PathVariable id: String): ResponseEntity<User> {
        return ResponseEntity.ok(this.userRepository.findById(id).orElse(null))
    }

    @PostMapping("")
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity.ok(this.userRepository.save(user))
    }

    @PutMapping("{id}")
    fun updateUser(@PathVariable id: String, @RequestBody user: User): ResponseEntity<User> {
        var oldUser = this.userRepository.findById(id).orElse(null)
        oldUser.name = user.name
        oldUser.email = user.email
        oldUser.password = user.password

        return ResponseEntity.ok(this.userRepository.save(oldUser))
    }

    @DeleteMapping("{id}")
    fun deleteUser(@PathVariable id: String): ResponseEntity<String> {
        this.userRepository.deleteById(id)
        return ResponseEntity.ok(id)

    }

}