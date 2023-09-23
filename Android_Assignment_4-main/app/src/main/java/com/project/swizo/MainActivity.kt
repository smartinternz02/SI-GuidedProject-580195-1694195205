package com.project.swizo

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    Navigation()
               }
    }
}


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "LoginPage",
    )
    {
        composable("LoginPage"){
            LoginPage(navController = navController)
        }

        composable("Screen2"){
            Screen2(navController= navController)
        }

        composable("Screen3/{text}"){
            backStackEntry -> val restaurantName = backStackEntry.arguments?.getString("text")
            Screen3(navController = navController , text = restaurantName)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavController)
{

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Image(
            painter = painterResource(id = R.drawable.background_img),
            contentDescription = "Background Image", Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Spacer(modifier = Modifier.padding(20.dp))

        Icon(painter = painterResource(id = R.drawable.login_icon), contentDescription = null,
            modifier = Modifier.size(70.dp),
           tint = Color.White
        )

        Spacer(modifier = Modifier.padding(20.dp))

        Text(
            text = "Login",
            fontSize = 50.sp,
            fontWeight = FontWeight.ExtraBold,
            color=Color.White,)

        Spacer(modifier = Modifier.padding(20.dp))

        var username by remember { mutableStateOf("")}
        var password by remember { mutableStateOf("")}
        var showPassword by remember { mutableStateOf(value = false)}

        TextField(value = username,
            onValueChange = {newUsername -> username = newUsername},
            label = {
                Text("Username", color=Color.Black)
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent
            ),
            leadingIcon = {
                Image(painter = painterResource(id = R.drawable.baseline_email_24), contentDescription = null)
            }
        )

        Spacer(modifier = Modifier.padding(20.dp))



            TextField(
            value = password,
            onValueChange = {newPassword -> password = newPassword},
            label = {
                Text("Password", color=Color.Black)
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor= Color.Transparent
            ),

            leadingIcon = {
                Image(painter = painterResource(id = R.drawable.baseline_lock_24), contentDescription = null)
            },
                visualTransformation = if (showPassword) {

                    VisualTransformation.None

                } else {

                    PasswordVisualTransformation()

                },

                keyboardOptions = KeyboardOptions.Default.copy
                    (
                        keyboardType= KeyboardType.Password
                ),

                        trailingIcon = {
                    if (showPassword) {
                        IconButton(onClick = { showPassword = false }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_visibility_24),
                                contentDescription = "hide_password"
                            )
                        }
                    } else {
                        IconButton(
                            onClick = { showPassword = true }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_visibility_off_24),
                                contentDescription = "hide_password"
                            )
                        }
                    }
                },

        )

        var showNotification by remember { mutableStateOf(false)}
        val context = LocalContext.current
        if(showNotification){
            Text(
                text = "Fill username and password!",
                color = Color.Red,
            )
        }

        Spacer(modifier = Modifier.padding(20.dp))

        Button(
            onClick = {
                    if(username.isNotEmpty() && password.isNotEmpty())
                    {
                            navController.navigate("Screen2")
                    }
                else{
                    showNotification=true
                    }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors
                (
                containerColor = Color(46,132,211),
                contentColor = Color.White),
            shape = RoundedCornerShape(10.dp),

        ) {
            Text(text = "Sign In")
        }

        Spacer(modifier = Modifier.padding(20.dp))

        Text(text = "——————————— or ———————————", color = Color.Gray)
        Spacer(modifier = Modifier.padding(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            IconLink(
                url = "https://accounts.google.com/v3/signin/identifier?ifkv=AYZoVhc47kdHJJvDFrKonJiS7w5Td-3WXyOelznUXb7juO1trop2KHXx7rr1rQKKvaWnf7BACzCPQg&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S-1677121878%3A1695056699340194&theme=glif",
                iconResourceId = R.drawable.icons8_google
            )

            Spacer(modifier = Modifier.padding(10.dp))

            IconLink(
                url = "https://github.com/login",
                iconResourceId = R.drawable.icons8_github
            )

            Spacer(modifier = Modifier.padding(10.dp))

            IconLink(
                url = "https://twitter.com/i/flow/login?input_flow_data=%7B%22requested_variant%22%3A%22eyJsYW5nIjoiZW4ifQ%3D%3D%22%7D",
                iconResourceId = R.drawable.twitter_x
            )
        }
    }
}


@Composable
fun IconLink(url: String, iconResourceId: Int, iconSize: Dp =130.dp) {
    var context = LocalContext.current
    Box(
        modifier = Modifier.size(80.dp), // Adjust the size as needed
        contentAlignment = Alignment.Center
    ) {
        IconButton(
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                try {
                    context.startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                }
            }
        ) {
            Icon(painter = painterResource(id = iconResourceId), contentDescription = null,
                modifier = Modifier.size(iconSize))
        }
    }
}
