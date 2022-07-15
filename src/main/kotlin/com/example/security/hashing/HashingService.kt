package com.example.security.hashing

interface HashingService {
    fun generateSaltedHash(value: String, saltLength: Int = 32): String
    fun verify(value: String, saltedHash: SaltedHash): Boolean
}