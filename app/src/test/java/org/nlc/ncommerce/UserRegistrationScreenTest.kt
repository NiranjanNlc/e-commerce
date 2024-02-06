package org.nlc.ncommerce

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.nlc.ncommerce.auth.UserRegistrationScreen
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class UserRegistrationScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testUserRegistrationScreen() {
        composeTestRule.setContent {
            UserRegistrationScreen(onRegisterClick = {})
        }
        composeTestRule.onNodeWithText("User Registration").assertIsDisplayed()
        composeTestRule.onNodeWithText("Email").assertIsDisplayed()
        composeTestRule.onNodeWithText("Password").assertIsDisplayed()
        composeTestRule.onNodeWithText("Confirm Password").assertIsDisplayed()
        composeTestRule.onNodeWithText("Register").assertIsDisplayed()
    }


}