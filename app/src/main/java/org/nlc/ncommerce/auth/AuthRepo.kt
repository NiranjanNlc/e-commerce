package org.nlc.ncommerce.auth

import kotlinx.coroutines.flow.Flow

interface AuthRepo {
    suspend fun registerUser(email: String, password: String): Flow<Result<Boolean>>
}
