package com.example.service

import com.example.model.User
import com.example.model.dto.UserDTO
import com.example.repository.UserRepository
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.transaction.Transactional

@ApplicationScoped
class UserService {

    @Inject
    lateinit var userRepository: UserRepository

    @Transactional
    fun create(userDTO: UserDTO) {
        userRepository.persist(User(userDTO))
    }
}