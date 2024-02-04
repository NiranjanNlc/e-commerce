package org.nlc.ncommerce.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserRegistrationViewModel(private val authRepo: AuthRepo) : ViewModel() {
    val registrationState = MutableStateFlow<Result<Boolean>>(Result.success(false))
    fun registerUser(email: String, password: String) {
        viewModelScope.launch {
            authRepo.registerUser(email, password).collect { result ->
                registrationState.value = result
            }
        }
    }
}
