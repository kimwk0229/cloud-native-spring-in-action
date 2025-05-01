package com.polarbookshop.catalog_service.webapi

import com.polarbookshop.catalog_service.domain.exception.AlreadyExistsException
import com.polarbookshop.catalog_service.domain.exception.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class BookRestApiAdvice {
    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(ex: NotFoundException): String {
        return ex.message ?: "Not Found"
    }

    @ExceptionHandler(AlreadyExistsException::class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    fun handleAlreadyExists(ex: AlreadyExistsException): String {
        return ex.message ?: "Already Exists"
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidation(ex: MethodArgumentNotValidException): String {
        return ex.bindingResult.fieldErrors.joinToString(", ") { "${it.field}: ${it.defaultMessage}" }
    }
}