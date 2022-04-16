package com.example.model

import javax.persistence.*

@Entity
@Table(name = "user_movie")
class UserMovie {

    @EmbeddedId
    lateinit var userMoviePK: UserMoviePK

    @JoinColumn(name="movie_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    lateinit var movie: Movie

    var rate: Int = 0
    var watchlist: Boolean = false
    var isAlreadyWatched: Boolean = false

}