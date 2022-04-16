package com.example.repository

import com.example.model.User
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserRepository: PanacheRepository<User> {

    fun findByEmail(email: String): User? {
        return find("email", email).firstResult()
    }
}