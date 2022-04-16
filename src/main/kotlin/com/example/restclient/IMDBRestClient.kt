package com.example.restclient

import com.example.restclient.model.MovieIMDB
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.ws.rs.GET
import javax.ws.rs.HeaderParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@RegisterRestClient(configKey = "restclient-imdb-api")
@Produces(MediaType.APPLICATION_JSON)
interface IMDBRestClient {

    @GET
    fun search(
        @HeaderParam("x-rapidapi-key") xRapidApiKey: String,
        @HeaderParam("x-rapidapi-host") xRapidApiHost: String,
        @QueryParam("s") query: String
    ): MovieIMDB
}