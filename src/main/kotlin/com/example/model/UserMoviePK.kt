package com.example.model

import javax.persistence.Embeddable
import java.io.Serializable

@Embeddable
class UserMoviePK(
    var userId: Long = 0,
    var movieId: Long = 0
) : Serializable