package com.polarbookshop.catalog_service.service

import com.polarbookshop.catalog_service.domain.Book
import com.polarbookshop.catalog_service.domain.exception.AlreadyExistsException
import com.polarbookshop.catalog_service.domain.exception.NotFoundException
import com.polarbookshop.catalog_service.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService {
    val bookRepository : BookRepository

    constructor(bookRepository: BookRepository) {
        this.bookRepository = bookRepository
    }

    fun getAllBooks(): List<Book> {
        return bookRepository.findAll()
    }

    fun getBookByIsbn(isbn: String): Book? {
        return bookRepository.findByIsbn(isbn)
            ?: throw NotFoundException("Book with ISBN $isbn not found")
    }

    fun addBook(book: Book): Book {
        if(bookRepository.existsByIsbn(book.isbn)) {
            throw AlreadyExistsException("Book with ISBN ${book.isbn} already exists")
        }
        return bookRepository.save(book)
    }

    fun deleteBook(isbn: String) {
        bookRepository.deleteByIsbn(isbn)
    }

    fun updateBook(isbn: String, book: Book): Book {
        val existingBook = bookRepository.findByIsbn(isbn)
            ?: throw IllegalArgumentException("Book with ISBN $isbn not found")
        return bookRepository.save(book.copy(isbn = existingBook.isbn))
    }

}