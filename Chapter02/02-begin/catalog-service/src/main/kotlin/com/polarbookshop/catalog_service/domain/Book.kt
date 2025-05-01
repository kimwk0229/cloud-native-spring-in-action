package com.polarbookshop.catalog_service.domain

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Positive


data class Book(
    @NotBlank(message = "ISBN must not be blank")
    @Pattern(regexp = "^(978|979)[0-9]{10}$", message = "ISBN must be a valid ISBN-13")
    val isbn: String,

    @NotBlank(message = "Title must not be blank")
    val title: String,

    @NotBlank(message = "Author must not be blank")
    val author: String,

    @NotNull(message = "Price must not be null")
    @Positive(message = "Price must be positive")
    val price: Double
)