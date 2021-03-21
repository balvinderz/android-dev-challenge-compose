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
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
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
    val theme : TimeBasedTheme = getTheme()

    val expanded = remember {
        mutableStateOf(false     )
    }
    val temperatureType = remember {
        mutableStateOf(TemperatureType.Celcius)
    }
    val convertToFahrenheit= temperatureType.value == TemperatureType.Fahrenheit;

    var floatingButtonContentDescription ="Open Bottom Sheet";
    if(expanded.value)
        floatingButtonContentDescription ="Close Bottom Sheet";
    Surface(color = MaterialTheme.colors.background) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(

                    colors = theme.gradientColors

                )
            )) {
            if(!expanded.value)
            Row(                modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp, end = 20.dp),horizontalArrangement = Arrangement.End) {
                Text("C°",style = myStyle.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color =  theme.textColor
                ),modifier = Modifier.clickable {
                    temperatureType.value = TemperatureType.Celcius
                }.semantics {
                    contentDescription ="Celcius"
                }.alpha(getAlpha(temperatureType =temperatureType.value  , textType = "Celcius")))
            Text("/F°",style = myStyle.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color =  theme.textColor

            ),modifier = Modifier.semantics {
                contentDescription ="Fahrenheit"
            }.alpha(getAlpha(temperatureType = temperatureType.value ,textType = "Fahrenheit") ).clickable {
                temperatureType.value =TemperatureType.Fahrenheit
            })
            }

            Column() {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Text(
                        "Today" + ", "+ getTodaysDate(),
                        color =  theme.textColor,
                        style = myStyle,
                        modifier = Modifier.padding(top = 76.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        "India", style = myStyle.copy(
                            fontWeight = FontWeight.Medium,
                            fontSize = 17.sp,
                            color =  theme.textColor,

                            )
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        Column() {
                            Text(
                                "DAY "+42.convertToFahrenheit(convertToFahrenheit)+"°", style = myStyle.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 17.sp,
                                    color =  theme.textColor,

                                    )
                            )
                            Text(
                                "NIGHT "+28.convertToFahrenheit(convertToFahrenheit)+"°", style = myStyle.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 17.sp,
                                    color =  theme.textColor,

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
                                    painter = painterResource(id = getIcon(theme),),
                                    contentDescription = null
                                )
                                Spacer(modifier = Modifier.width(10.3.dp))
                                Text(
                                    "${27.convertToFahrenheit(convertToFahrenheit)}", style = myStyle.copy(
                                        fontSize = 59.sp,
                                        fontWeight = FontWeight.Bold,
                                        color =  theme.textColor,


                                        )
                                )
                                Text(
                                    "°", style = myStyle.copy(
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 29.sp,
                                        color =  theme.textColor,

                                        )
                                )
                                Text(
                                    if(temperatureType.value == TemperatureType.Celcius)"C" else "F"    , style = myStyle.copy(
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 36.sp,
                                        color =  theme.textColor,

                                        )
                                )
                            }
                            Text(
                                "Sunny with periodic \n" +
                                        "clouds", style = myStyle.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 15.sp,
                                    color =  theme.textColor,

                                    ), textAlign = TextAlign.Center,
                            )
                        }
                    }
                }


            }
            Column(modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.Bottom) {
                Image(
                    painter = painterResource(id = theme.backgroundImage),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 200.dp),
                    contentScale = ContentScale.FillWidth
                )
            }
            Column(modifier = Modifier.fillMaxSize(),verticalArrangement = Arrangement.Bottom) {
                Box(modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topEnd = 40.dp,
                            topStart = 40.dp
                        )
                    )
                    .background(Color.White))
            }
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)){

                    BottomSheet(expanded = expanded.value,temperatureType = temperatureType.value )

                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 36.dp, top = 20.dp),horizontalArrangement = Arrangement.End) {
                        FloatingActionButton(onClick = { expanded.value = !expanded.value },
                            backgroundColor = theme.fabColor,
                            modifier = Modifier
                                .size(36.dp)
                                .semantics() {
                                    contentDescription = floatingButtonContentDescription


                                }) {
                            Icon(
                                if (expanded.value) Icons.Filled.ArrowDownward else Icons.Filled.ArrowUpward,
                                tint = theme.fabIconColor,
                                contentDescription = null
                            )
                        }
                    }
                    androidx.compose.animation.AnimatedVisibility(visible = !expanded.value) {
                        BottomSheetCenter(theme = theme,temperatureType = temperatureType.value)
                    }
                   }


            }

        }}

}

fun getAlpha(temperatureType: TemperatureType, textType : String ): Float {
 if(textType == "Fahrenheit" &&temperatureType == TemperatureType.Fahrenheit) {
     return 1.0f
 }
 else {
     if(textType == "Celcius" && temperatureType == TemperatureType.Celcius)
         return 1.0f;

 }
    return 0.5f;


 }

fun getIcon(theme: TimeBasedTheme): Int {
    if(theme.textColor == blackish)
        return R.drawable.sunny_with_cloud_black
    return R.drawable.sunny_with_cloud
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
