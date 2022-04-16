package com.example.model

import com.example.model.dto.UserDTO
import javax.persistence.*

@Entity
@Table(name = "users")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null;

    @Column(unique = true)
    lateinit var email: String

    lateinit var name: String
    lateinit var password: String

    constructor()

    constructor(userDTO: UserDTO) {
        this.name = userDTO.name
        this.email = userDTO.email
        this.password = userDTO.password
    }
}