package com.microservices.kotlin.repositories

import com.microservices.kotlin.models.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String> {
}