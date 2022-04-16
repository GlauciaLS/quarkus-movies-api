package com.example.resources

import com.example.model.dto.UserDTO
import com.example.service.UserService
import javax.inject.Inject
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.core.Response

@Path("/users")
class UserResource {

    @Inject
    lateinit var userService: UserService

    @POST
    fun create(userDTO: UserDTO): Response? {
        userService.create(userDTO)
        return Response.status(Response.Status.CREATED).entity(userDTO).build()
    }
}