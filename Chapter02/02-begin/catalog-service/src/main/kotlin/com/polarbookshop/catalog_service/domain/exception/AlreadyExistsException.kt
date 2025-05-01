package com.polarbookshop.catalog_service.domain.exception

class AlreadyExistsException : RuntimeException {
    constructor(id: String) : super("$id already exists")
    constructor(id: String, cause: Throwable) : super("$id already exists", cause)
}