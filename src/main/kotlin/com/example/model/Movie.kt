package com.example.model

import com.example.restclient.model.Search
import javax.persistence.*

@Entity
@Table(name = "movie")
class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null;

    lateinit var name: String

    @Column(name = "imdb_id")
    lateinit var imdbId: String

    @Column(name = "image_url")
    lateinit var imagemUrl: String

    lateinit var qualifier: String

    var year: String? = null

    constructor()

    constructor(searchDB: Search) {
        val search = searchDB.copy()

        this.name = search.Title
        this.imdbId = search.imdbID
        this.imagemUrl = search.Poster
        this.qualifier = search.Type
        this.year = search.Year
    }
}