package com.project.swizo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen3(navController: NavController ,text: String?){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    )
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .padding(5.dp)
        ){

            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()

            ) {
                Button(
                    onClick = { navController.navigate("Screen2") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(80.dp)
                )
                {
                    Image(painter = painterResource(id = R.drawable.baseline_arrow_back_24), contentDescription = "back button",
                        colorFilter = ColorFilter.tint(Color.Red),
                        modifier = Modifier.size(30.dp)
                    )
                }

                var foodname by remember { mutableStateOf("")}

                TextField(
                   modifier = Modifier
                       .align(Alignment.CenterVertically)
                       .border(BorderStroke(0.dp, Color.Transparent))
                       .width(179.dp),
                    value = foodname,
                    onValueChange = {newFoodname -> foodname = newFoodname},
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        textColor = Color.Black,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    placeholder = {
                        Text(
                            text = "search you fav dish",
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    },
                )

                Spacer(Modifier.weight(1f))

                var heart by remember { mutableStateOf(false)}
                IconButton(
                    onClick = { heart=!heart },
                    Modifier.align(Alignment.CenterVertically)
                )
                {
                    if(heart==false){
                        Image(
                            painter = painterResource(id = R.drawable.heart),
                            contentDescription = "like dislike",
                            modifier = Modifier
                                .size(30.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                    else{
                        Image(
                            painter = painterResource(id = R.drawable.heart_filled),
                            contentDescription = "like dislike",
                            modifier = Modifier
                                .size(30.dp)
                                .align(Alignment.CenterVertically),
                            colorFilter = ColorFilter.tint(Color.Red)
                        )
                    }

                }

                Spacer(Modifier.width(5.dp))

                IconButton(
                    onClick = { /*TODO*/ },
                    Modifier.align(Alignment.CenterVertically)
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.menu_vertical),
                        contentDescription = "menu",
                        modifier = Modifier
                            .size(30.dp)
                            .align(Alignment.CenterVertically)
                    )
                }

            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 75.dp)
                .padding(bottom = 70.dp)
        )
        {

            // scrolable area and food

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(text = text?:"Restaurant Name",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(text = "Pizza . Fast Food . Beverages", color = Color.Gray)
                Row(
                    modifier= Modifier
                        .background(Color(25, 128, 0), shape = RoundedCornerShape(5.dp))
                        .padding(5.dp)
                ){
                    Text(text = "4.0", fontSize = 12.sp, fontWeight = FontWeight.Bold, color =Color.White)
                    Image(painter = painterResource(id = com.google.android.material.R.drawable.abc_ic_star_black_16dp),
                        contentDescription = "rating star",
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                }


                Spacer(modifier = Modifier.height(20.dp))

                // _______________________________________ Chicken Biryani
                Row(
                    Modifier.padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxHeight()
                            .align(Alignment.CenterVertically)
                            .weight(1f)
                    )
                    {
                        Text(
                            text = "Chicken Biryani",
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .align(Alignment.CenterHorizontally),
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            textAlign = TextAlign.Start,
                        )
                        Text("₹150", fontSize = 18.sp, fontWeight = FontWeight.Medium)
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.chicken_biryani),
                            contentDescription = "Chicken Biryani",
                            modifier = Modifier
                                .size(150.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                                .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop,
                        )
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .padding(top = 4.dp)
                                .width(75.dp)
                                .fillMaxWidth()
                                .offset(y = (-20.5).dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(43,134,0,(5*255).toInt())
                            )
                        ) {
                            Text(text = "Add")
                        }
                    }

                }

                Spacer(Modifier.padding(10.dp))

                // _______________________________________ Burger

                Row(
                    Modifier.padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxHeight()
                            .align(Alignment.CenterVertically)
                            .weight(1f)
                    )
                    {
                        Text(
                            text = "Burger",
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .align(Alignment.CenterHorizontally),
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            textAlign = TextAlign.Start,
                        )
                        Text("₹100", fontSize = 18.sp, fontWeight = FontWeight.Medium)
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.burger),
                            contentDescription = "Burger",
                            modifier = Modifier
                                .size(150.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                                .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop,
                        )
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .padding(top = 4.dp)
                                .width(75.dp)
                                .fillMaxWidth()
                                .offset(y = (-20.5).dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(43,134,0,(5*255).toInt())
                            )
                        ) {
                            Text(text = "Add")
                        }
                    }
                }

                Spacer(Modifier.padding(10.dp))

                // _______________________________________ Sandwich

                Row(
                    Modifier.padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxHeight()
                            .align(Alignment.CenterVertically)
                            .weight(1f)
                    )
                    {
                        Text(
                            text = "Sandwich",
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .align(Alignment.CenterHorizontally),
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            textAlign = TextAlign.Start,
                        )
                        Text("₹80", fontSize = 18.sp, fontWeight = FontWeight.Medium)
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.sandwich_2),
                            contentDescription = "Sandwich",
                            modifier = Modifier
                                .size(150.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                                .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop,
                        )
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .padding(top = 4.dp)
                                .width(75.dp)
                                .fillMaxWidth()
                                .offset(y = (-20.5).dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(43,134,0,(5*255).toInt())
                            )
                        ) {
                            Text(text = "Add")
                        }
                    }
                }

                Spacer(Modifier.padding(10.dp))

                // _______________________________________ Pizza
                Row(
                    Modifier.padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxHeight()
                            .align(Alignment.CenterVertically)
                            .weight(1f)
                    )
                    {
                        Text(
                            text = "Pizza",
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .align(Alignment.CenterHorizontally),
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            textAlign = TextAlign.Start,
                        )
                        Text("₹180", fontSize = 18.sp, fontWeight = FontWeight.Medium)
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.pizza),
                            contentDescription = "Pizza",
                            modifier = Modifier
                                .size(150.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                                .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop,
                        )
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .padding(top = 4.dp)
                                .width(75.dp)
                                .fillMaxWidth()
                                .offset(y = (-20.5).dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(43,134,0,(5*255).toInt())
                            )
                        ) {
                            Text(text = "Add")
                        }
                    }
                }
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
                            colorFilter = ColorFilter.tint(Color.White)
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