package com.example.security.token

interface TokenService {
    fun gennerate(
        config: TokenConfig,
        vararg claims: TokenClaim
    ): String
}