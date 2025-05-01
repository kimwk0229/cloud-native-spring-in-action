package com.polarbookshop.catalog_service.repository

import com.polarbookshop.catalog_service.domain.Book
import org.springframework.stereotype.Repository

@Repository
class InMemoryBookRepository : BookRepository {
    private val books = mutableListOf<Book>()

    override fun findAll(): List<Book> {
        return books
    }

    override fun findByIsbn(isbn: String): Book? {
        return books.find { it.isbn == isbn }
    }

    override fun existsByIsbn(isbn: String): Boolean {
        return books.any { it.isbn == isbn }
    }

    override fun save(book: Book): Book {
        books.removeIf { it.isbn == book.isbn }
        books.add(book)
        return book
    }

    override fun deleteByIsbn(isbn: String) {
        books.removeIf { it.isbn == isbn }
    }
}