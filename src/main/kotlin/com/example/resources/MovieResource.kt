package com.example.resources

import com.example.restclient.model.MovieIMDB
import com.example.service.MovieService
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse
import org.eclipse.microprofile.openapi.annotations.tags.Tag
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/movies")
class MovieResource() {

    @Inject
    lateinit var movieService: MovieService

    @Tag(name = "movie")
    @Operation(summary = "Método para buscar filmes")
    @APIResponse(responseCode = "200",
        content = [Content(
            mediaType = MediaType.APPLICATION_JSON,
            schema = Schema(implementation = MovieIMDB::class, type = SchemaType.ARRAY)
        )]
    )
    @GET
    @Path("/search/{query}")
    @Produces(MediaType.APPLICATION_JSON)
    fun search(@PathParam("query") query: String): MovieIMDB {
        return movieService.search(query)
    }

}