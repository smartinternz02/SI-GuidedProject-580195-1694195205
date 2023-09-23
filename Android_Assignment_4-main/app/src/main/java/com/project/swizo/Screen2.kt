package com.project.swizo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen2(navController: NavController) {
    val systemUiController = rememberSystemUiController()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    )
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color(41, 123, 201))
                .padding(20.dp)
        ){

            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
                )
                {
                    IconButton(onClick = { /*TODO*/ }) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_location_on_24),
                            contentDescription = "Location Icon",
                            colorFilter = ColorFilter.tint(Color.Red),
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    Text(
                        text = "Home",
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(end = 20.dp),
                        color = Color(41, 123, 201),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )

                }

                Spacer(Modifier.weight(1f))

                IconButton(
                    onClick = { /*TODO*/ },

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.user_img),
                        contentDescription = "User Account",
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp)
                .padding(bottom = 70.dp)
        )
        {

            // scrolable area and restraunts

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                ClickableImageWithText(
                    imageResId = R.drawable.restraunt_1,
                    text = "Dum Pukht",
                    onClick = {
                        navController.navigate("Screen3/Dum Pukht")
                    }
                )

                Spacer(Modifier.padding(10.dp))

                ClickableImageWithText(
                    imageResId = R.drawable.restraunt_2,
                    text = "Indian Accent",
                    onClick = {
                        navController.navigate("Screen3/Indian Accent")
                    }
                )

                Spacer(Modifier.padding(10.dp))

                ClickableImageWithText(
                    imageResId = R.drawable.restraunt_3,
                    text = "Bukhara",
                    onClick = {
                        navController.navigate("Screen3/Bukhara")
                    }
                )

                Spacer(Modifier.padding(10.dp))

                ClickableImageWithText(
                    imageResId = R.drawable.restraunt_4,
                    text = "Hauz Khas Social",
                    onClick = {
                        navController.navigate("Screen3/Hauz Khas Social")
                    }
                )
            }
        }

        // ________________________________________ lower nav bar ________________________________________

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(Color(41, 123, 201))
                .align(Alignment.BottomCenter)
        )
        {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            )
            {

                    IconButton(
                        onClick = { /*TODO*/ },
                        Modifier.fillMaxHeight()
                    ) {
                        Column{
                            Image(painter = painterResource(id = R.drawable.baseline_delivery_dining_24), contentDescription = "delivery",
                                Modifier.size(40.dp),
                                colorFilter = ColorFilter.tint(Color.White)
                            )
                            Text(text = "Delivery", fontSize = 11.sp, fontWeight = FontWeight.Bold
                            )
                        }

                    }


                IconButton(onClick = { /*TODO*/ },Modifier.fillMaxHeight()) {
                    Column {
                        Image(painter = painterResource(id = R.drawable.order_history), contentDescription = "order history",
                            Modifier.size(40.dp),
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                        Text(text = "History", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                    
                }



                IconButton(onClick = { /*TODO*/ },Modifier.fillMaxHeight()) {
                    Column {
                        Image(painter = painterResource(id = R.drawable.money), contentDescription = "money",
                            Modifier.size(40.dp),
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                        Text(text = "Money", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }

                }


                IconButton(onClick = { /*TODO*/ },Modifier.fillMaxHeight()) {
                    Column {
                        Image(painter = painterResource(id = R.drawable.order), contentDescription = "orders",
                            Modifier.size(40.dp),
                            colorFilter = ColorFilter.tint(Color.Red)
                        )
                        Text(text = "Order", fontSize = 12.sp, fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }

        // ________________________________________ Lower Scroll bar Finish ________________________________________

    }
}


@Composable
fun ClickableImageWithText(
    imageResId: Int,
    text: String,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = "Restaurant Images",
            modifier = Modifier
                .size(250.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Text(
            text = text,
            modifier = Modifier.padding(top = 8.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
    }
}
