package com.example.openapi

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition
import org.eclipse.microprofile.openapi.annotations.info.Contact
import org.eclipse.microprofile.openapi.annotations.info.Info
import org.eclipse.microprofile.openapi.annotations.info.License
import org.eclipse.microprofile.openapi.annotations.tags.Tag
import javax.ws.rs.core.Application

@OpenAPIDefinition(
    tags = [
        Tag(name = "movie", description = "Movies and Series"),
        Tag(name = "user", description = "Users")
    ],
    info = Info(
        title = "Quarkus Movie API",
        version = "1.0.0",
        contact = Contact(
            name = "GS  - Quarkus Movie API Support",
            url = "http://quarkusmovie-api.com/contact",
            email = "contact@example.com"
        ),
        license = License(
            name = "Apache 2.0",
            url = "http://www.apache.org/licenses/LICENSE-2.0.html"
        )
    )
    )
class QuarkusMovieOpenAPI: Application() {
}