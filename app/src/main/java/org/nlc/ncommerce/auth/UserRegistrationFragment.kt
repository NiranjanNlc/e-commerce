package org.nlc.ncommerce.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class UserRegistrationFragment : Fragment()
{
    private val userRegistrationViewModel by viewModels<UserRegistrationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     return ComposeView(requireContext()).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            setContent {
                UserRegistrationScreen({ email, password, confirmPassword ->
                    onRegisterClick(email, password, confirmPassword) })
            }
        }
    }


    private fun onRegisterClick(email: String, password: String, confirmPassword: String) {
      if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
          // check for hardcoded email and password
            if (email == "nlc@gmaiil.com" && password == "12345678" && confirmPassword == "12345678") {
                Toast.makeText(requireContext(), "Register  sucessful ...", Toast.LENGTH_SHORT).show()
            } else {
                // show error message in the form of toast
                Toast.makeText(requireContext(), "Invalid email or password", Toast.LENGTH_SHORT).show()

            }
        }
    }

}