package com.example.loginflow

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppContent()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppContent() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var Title by remember {
            mutableStateOf("Login")
        }

        Text(
            text = Title, // Use the Title variable here
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 16.dp)
        )


        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        Text(
            text = "Username",
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(bottom = 8.dp)
                .padding(start = 43.dp)
                .align(Alignment.Start)
        )

        TextField(
            value = username,
            onValueChange = { newUsername ->
                username = newUsername
            },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.baseline_email_24),
                    contentDescription = "Email Icon"
                )
            },
            label = {
                Text(text = "Username")
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                containerColor = Color.Transparent
            ),
        )

        Text(
            text = "Password",
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(bottom = 8.dp)
                .padding(start = 43.dp)
                .align(Alignment.Start)
        )

        TextField(
            modifier = Modifier,
            value = password,
            onValueChange = { newPassword ->
                password = newPassword
            },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.baseline_lock_24),
                    contentDescription = "Lock Icon"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done

            ),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                containerColor = Color.Transparent
            ),
            placeholder = {
                Text(text = "Password")
            }

        )

        Button(
            onClick = { /TODO/ },
            modifier = Modifier
                .fillMaxWidth() // Button occupies the full width
                .padding(top = 16.dp), // Add space between Button and TextField
            colors = ButtonDefaults.buttonColors
                (
                containerColor = Color.Black,
                contentColor = Color.White),
        ) {
            Text(text = "Sign In")
        }


        Text(
            text = "-----------------------OR------------------------",
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Light),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .padding(top = 15.dp)
        )

        Button(
            onClick = { /TODO/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
                .border(1.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black),
        )
        {
            Text(
                text = "Sign in with Google",
            )

        }

        Button(
            onClick = { /TODO/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
                .border(1.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black),
        )
        {
            Text(
                text = "Sign in with Github",
            )
        }

        Button(
            onClick = { /TODO/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
                .border(1.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black),
        )
        {
            Text(
                text = "Sign in with Twitter",
            )

        }
    }
}