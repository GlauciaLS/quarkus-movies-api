package com.example.resources

import com.example.restclient.IMDBRestClient
import com.example.restclient.model.MovieIMDB
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.eclipse.microprofile.openapi.annotations.tags.Tag
import org.eclipse.microprofile.rest.client.inject.RestClient
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/movies")
class MovieResource() {

    @ConfigProperty(name = "x-rapidapi-key")
    lateinit var xRapidApiKey: String;

    @ConfigProperty(name = "x-rapidapi-host")
    lateinit var xRapidApiHost: String;

    @Inject
    @field: RestClient
    internal lateinit var imdbRestClient: IMDBRestClient

    @Tag(name = "movie")
    @GET
    @Path("/search/{query}")
    @Produces(MediaType.APPLICATION_JSON)
    fun hello(@PathParam("query") query: String): MovieIMDB {
        return imdbRestClient.search(xRapidApiKey, xRapidApiHost, query)
    }
}