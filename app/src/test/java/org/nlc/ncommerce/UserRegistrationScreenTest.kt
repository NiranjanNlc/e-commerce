package org.nlc.ncommerce

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Assert
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
            UserRegistrationScreen(onRegisterClick = {_, _, _ -> })
        }
        composeTestRule.onNodeWithText("User Registration").assertIsDisplayed()
        composeTestRule.onNodeWithText("Email").assertIsDisplayed()
        composeTestRule.onNodeWithText("Password").assertIsDisplayed()
        composeTestRule.onNodeWithText("Confirm Password").assertIsDisplayed()
        composeTestRule.onNodeWithText("Register").assertIsDisplayed()
    }
    @Test
    fun testEmptyFieldsErrorMessages() {
        // Set content to the UserRegistrationScreen
        composeTestRule.setContent {
            UserRegistrationScreen(onRegisterClick = {_, _, _ -> })
        }

        // Ensure error messages are displayed for empty fields
        composeTestRule.onNodeWithText("Register").performClick()
        composeTestRule.onNodeWithText("Email cannot be empty").assertIsDisplayed()
        composeTestRule.onNodeWithText("Password cannot be empty").assertIsDisplayed()
//        composeTestRule.onNodeWithText("Confirm Password cannot be empty").assertIsDisplayed()
    }

    @Test
    fun testInvalidEmailFormatErrorMessage() {
        // Set content to the UserRegistrationScreen
        composeTestRule.setContent {
            UserRegistrationScreen(onRegisterClick = {_, _, _ -> })
        }

        // Enter an invalid email format
        composeTestRule.onNodeWithText("Email").performTextInput("invalid_email")
        composeTestRule.onNodeWithText("Register").performClick()
        composeTestRule.onNodeWithText("Invalid email format").assertIsDisplayed()
    }

// Add similar tests for other error messages (password length, password complexity, passwords match)

    @Test
    fun testSuccessfulRegistrationClick() {
        var registrationClicked = false
        // Set content to the UserRegistrationScreen with a lambda function that updates the flag when clicked
        composeTestRule.setContent {
            UserRegistrationScreen(onRegisterClick = { _, _, _ ->
                registrationClicked = true
            })
        }

        // Enter valid email, password, and confirm password
        composeTestRule.onNodeWithText("Email").performTextInput("test@example.com")
        composeTestRule.onNodeWithText("Password").performTextInput("Test@123")
        composeTestRule.onNodeWithText("Confirm Password").performTextInput("Test@123")
        composeTestRule.onNodeWithText("Register").performClick()

        // Verify that the lambda function was invoked
        Assert.assertTrue(registrationClicked)
    }


}