package com.polarbookshop.catalog_service

import com.polarbookshop.catalog_service.domain.Book
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {
	@Autowired
	var webTestClient : WebTestClient? = null

//	@Test
//	fun contextLoads() {
//	}

	@Test
	fun 책을_POST시_DB에_등록되야함() {
		webTestClient!!.post()
            .uri("/api/v1/books")
			.contentType(MediaType.APPLICATION_JSON)
            .bodyValue(
                """
                    {
                        "isbn": "1234567890",
                        "title": "Test Book",
                        "author": "Test Author",
                        "price": 9.99
                    }
                    """.trimIndent()
            )
			.exchange()

			.expectStatus().isCreated
			.expectBody()
			.jsonPath("$.isbn").isEqualTo("1234567890")
			.jsonPath("$.title").isEqualTo("Test Book")
			.jsonPath("$.author").isEqualTo("Test Author")
			.jsonPath("$.price").isEqualTo(9.99)

	}
}



//var expectedBook = Book("1234567890","Test Book","Test Author",9.99)
//
//		webTestClient!!.post()
//			.uri("/api/v1/books")
//			.contentType(MediaType.APPLICATION_JSON)
//			.bodyValue(expectedBook)
//			.exchange()
//
//			.expectStatus().isCreated
//			.extectBody(Book::class.java).value({ book ->
//				assertThat(book.isbn).isEqualTo(expectedBook.isbn)
//				assertThat(book.title).isEqualTo(expectedBook.title)
//				assertThat(book.author).isEqualTo(expectedBook.author)
//				assertThat(book.price).isEqualTo(expectedBook.price)
//			})
