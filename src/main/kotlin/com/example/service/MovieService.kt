package com.example.service

import com.example.model.Movie
import com.example.repository.MovieRepository
import com.example.restclient.IMDBRestClient
import com.example.restclient.model.MovieIMDB
import com.example.restclient.model.Search
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.eclipse.microprofile.rest.client.inject.RestClient
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.transaction.Transactional

@ApplicationScoped
class MovieService {

    @ConfigProperty(name = "x-rapidapi-key")
    lateinit var xRapidApiKey: String;

    @ConfigProperty(name = "x-rapidapi-host")
    lateinit var xRapidApiHost: String;

    @Inject
    lateinit var movieRepository: MovieRepository

    @Inject
    @field: RestClient
    internal lateinit var imdbRestClient: IMDBRestClient

    @Transactional
    fun search(query: String): MovieIMDB {

        val movieIMDB = imdbRestClient.search(xRapidApiKey, xRapidApiHost, query)

        saveMovie(movieIMDB)

        return movieIMDB
    }

    fun saveMovie(movieIMDB: MovieIMDB) {
        var movies: MutableList<Movie> = mutableListOf()

        movieIMDB.Search?.forEach {
            val movieDB = movieRepository.findByIMBDID(it.imdbID)

            if (movieDB == null) {
                movies.add(Movie(it))
            }

            movieRepository.persist(movies)
        }

    }
}