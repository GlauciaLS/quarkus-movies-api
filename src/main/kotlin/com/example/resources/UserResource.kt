package com.example.resources

import com.example.model.dto.UserDTO
import com.example.service.UserService
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse
import org.eclipse.microprofile.openapi.annotations.tags.Tag
import javax.inject.Inject
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/users")
class UserResource {

    @Inject
    lateinit var userService: UserService

    @Tag(name = "user")
    @Operation(summary = "Método para cadastrar usuário")
    @APIResponse(responseCode = "201",
        content = [Content(
            mediaType = MediaType.APPLICATION_JSON,
            schema = Schema(implementation = UserDTO::class, type = SchemaType.ARRAY)
        )]
    )
    @POST
    fun create(userDTO: UserDTO): Response? {
        userService.create(userDTO)
        return Response.status(Response.Status.CREATED).entity(userDTO).build()
    }
}