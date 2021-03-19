/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import android.widget.Space
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleUp
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.androiddevchallenge.composables.BottomSheet
import com.example.androiddevchallenge.composables.BottomSheetCenter
import com.example.androiddevchallenge.ui.theme.*

class MainActivity : AppCompatActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@ExperimentalAnimationApi
@Composable
fun MyApp() {
    val gradient1 = listOf<Color>(Color(0xFF8C2480),Color(0xFFCE587D),Color(0xFFFF9485),Color(0xFFFF9D80),Color(0xFFFFBD73),Color(0xFFFFFF))
    val gradient2 =listOf(
        Color(0xFF262F69),
        Color(0xFF3B4791),
        Color(0xFF829BBF),
        Color(0xFFFFB98D)
    )
    val expanded = remember {
        mutableStateOf(true    )
    }
    Surface(color = MaterialTheme.colors.background) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(

                    colors = gradient1

                )
            )) {
            Row(                modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp, end = 20.dp),horizontalArrangement = Arrangement.End) {
                Text("C°",style = myStyle.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                ))
            Text("/F°",style = myStyle.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            ),modifier = Modifier.alpha(0.5f))
            }

            Column() {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Text(
                        "Today, 12 May 19",
                        color = Color.White,
                        style = myStyle,
                        modifier = Modifier.padding(top = 76.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        "Current Location", color = Color.White, style = myStyle.copy(
                            fontWeight = FontWeight.Medium,
                            fontSize = 17.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        Column() {
                            Text(
                                "DAY 42°", color = Color.White, style = myStyle.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 17.sp
                                )
                            )
                            Text(
                                "NIGHT 28°", color = Color.White, style = myStyle.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 17.sp
                                )
                            )
                        }
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.End
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.sunny_with_cloud),
                                    contentDescription = null
                                )
                                Spacer(modifier = Modifier.width(10.3.dp))
                                Text(
                                    "27", style = myStyle.copy(
                                        fontSize = 59.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White,

                                        )
                                )
                                Text(
                                    "°", style = myStyle.copy(
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 29.sp
                                    )
                                )
                                Text(
                                    "C", style = myStyle.copy(
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 36.sp
                                    )
                                )
                            }
                            Text(
                                "Sunny with periodic \n" +
                                        "clouds", style = myStyle.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 15.sp
                                ), textAlign = TextAlign.Center
                            )
                        }
                    }
                }


            }
            Image(
                painter = painterResource(id = R.drawable.landscape_2),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 220.dp),
                contentScale = ContentScale.FillWidth
            )
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)){
                    BottomSheet(expanded = expanded.value)
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 36.dp, top = 20.dp),horizontalArrangement = Arrangement.End){
                        FloatingActionButton(onClick = { expanded.value = !expanded.value   },backgroundColor =  yellowish,modifier = Modifier.size(36.dp)) {
                            Icon(if(expanded.value) Icons.Filled.ArrowDownward else Icons.Filled.ArrowUpward,tint = Color.Black ,contentDescription = null)
                        }
                    }
                    androidx.compose.animation.AnimatedVisibility(visible =!expanded.value ) {
                        BottomSheetCenter()

                    }
                }
                

            }}}

}

@ExperimentalAnimationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@ExperimentalAnimationApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
