package com.polarbookshop.catalog_service.webapi

import com.polarbookshop.catalog_service.domain.Book
import com.polarbookshop.catalog_service.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/books")
class BookRestApi {
    var bookService : BookService? = null

    constructor(bookService: BookService) {
        this.bookService = bookService
    }

    @GetMapping
    fun getAllBooks(): List<Book> {
        return bookService?.getAllBooks() ?: emptyList()
    }

    @GetMapping("/{isbn}")
    fun getBookByIsbn(isbn: String): Book? {
        return bookService?.getBookByIsbn(isbn)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addBook(@Validated @RequestBody book: Book): Book? {
        return bookService?.addBook(book)
    }

    @PutMapping("/{isbn}")
    fun updateBook(@PathVariable isbn: String, @Validated @RequestBody book: Book): Book? {
        return bookService?.updateBook(isbn, book)
    }

    @DeleteMapping("/{isbn}")
    fun deleteBook(@PathVariable isbn: String) {
        bookService?.deleteBook(isbn)
    }

    @GetMapping("/error")
    fun getError(): String {
        throw RuntimeException("An error occurred")
    }

    @GetMapping("/error/404")
    fun getError404(): String {
        throw RuntimeException("Not Found")
    }
}