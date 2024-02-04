package org.nlc.ncommerce.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
                UserRegistrationScreen(userRegistrationViewModel)
            }
        }
    }

    @Preview
    @Composable
    fun UserRegistrationScreenPreview() {
        UserRegistrationScreen(onRegisterClick = userRegistrationViewModel)
    }

}