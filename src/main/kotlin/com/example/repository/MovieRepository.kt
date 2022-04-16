package com.example.repository

import com.example.model.Movie
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class MovieRepository: PanacheRepository<Movie> {

    fun list(): List<Movie> = listAll()

    fun findByIMBDID(imdbID: String): Movie? = find("imdbId", imdbID).firstResult()
}