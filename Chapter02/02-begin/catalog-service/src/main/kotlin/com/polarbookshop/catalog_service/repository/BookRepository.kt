package com.polarbookshop.catalog_service.repository

import com.polarbookshop.catalog_service.domain.Book
import org.springframework.stereotype.Repository

@Repository
interface BookRepository {
    fun findAll(): List<Book>
    fun findByIsbn(isbn: String): Book?
    fun existsByIsbn(isbn: String): Boolean
    fun save(book: Book): Book
    fun deleteByIsbn(isbn: String)
}
