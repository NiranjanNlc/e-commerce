package org.nlc.ncommerce.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.nlc.ncommerce.R

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        // Load the UserRegistrationFragment into the fragment container
        supportFragmentManager.beginTransaction()
            .replace(R.id.auth_container, UserRegistrationFragment())
            .commit()
    }
}