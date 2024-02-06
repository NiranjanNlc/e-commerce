package org.nlc.ncommerce.auth

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserRegistrationScreen(
// Callback function for register button click
    onRegisterClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var emailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }
    var confirmPasswordError by remember { mutableStateOf("") }

    var showButton by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
         horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "User Registration",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        TextField(
            value = email,
            onValueChange = {
                email = it
                emailError = ""
            },
            label = { Text(text = "Email", style = TextStyle(color = Color.Gray)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            textStyle = TextStyle(color = Color.Black),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(
//                backgroundColor = Color.LightGray,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { /* Move focus to next field */ }
            )
        )

        if (emailError.isNotEmpty()) {
            Text(
                text = emailError,
                style = TextStyle(color = Color.Red, fontSize = 12.sp)
            )
        }

        TextField(
            value = password,
            onValueChange = {
                password = it
                passwordError = ""
            },
            label = { Text(text = "Password", style = TextStyle(color = Color.Gray)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            textStyle = TextStyle(color = Color.Black),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(
//                backgroundColor = Color.LightGray,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { /* Move focus to next field */ }
            )
        )

        if (passwordError.isNotEmpty()) {
            Text(
                text = passwordError,
                style = TextStyle(color = Color.Red, fontSize = 12.sp)
            )
        }

        TextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
                confirmPasswordError = ""
            },
            label = { Text(text = "Confirm Password", style = TextStyle(color = Color.Gray)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            textStyle = TextStyle(color = Color.Black),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(
//                backgroundColor = Color.LightGray,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { onRegisterClick() }
            )
        )

        if (confirmPasswordError.isNotEmpty()) {
            Text(
                text = confirmPasswordError,
                style = TextStyle(color = Color.Red, fontSize = 12.sp)
            )
        }

        AnimatedVisibility(visible = showButton) {
            Button(
                onClick = {
                    onRegisterClick()
                    showButton = false
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                contentPadding = PaddingValues(vertical = 12.dp)
            ) {
                Text(
                    text = "Register",
                    style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold)
                )
            }
        }
    }
}

@Preview
@Composable
fun UserRegistrationScreenPreview() {
    UserRegistrationScreen(onRegisterClick = {})
}
