package com.polarbookshop.catalog_service.domain.exception

class NotFoundException : RuntimeException {
    constructor(id: String) : super("$id not found")
    constructor(id: String, cause: Throwable) : super("$id not found", cause)
}