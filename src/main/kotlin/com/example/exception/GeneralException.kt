package com.example.exception

import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
class GeneralException: ExceptionMapper<Exception> {

    @Produces(MediaType.APPLICATION_JSON)
    override fun toResponse(exception: Exception?): Response {

        if(exception is BusinessException)
            return Response.status(Response.Status.BAD_REQUEST).entity(MessageError(exception.message)).build()

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(MessageError("Erro: Favor entrar em contato com o suporte")).build()
    }
}