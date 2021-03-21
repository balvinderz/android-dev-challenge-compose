package com.example.androiddevchallenge.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.*
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.blackish
import com.example.androiddevchallenge.ui.theme.myStyle
import com.example.androiddevchallenge.ui.theme.grayish
import com.example.androiddevchallenge.ui.theme.myStyleBlackColor

@ExperimentalAnimationApi
@Composable
fun BottomSheet(expanded  : Boolean , temperatureType : TemperatureType ){
    val sunriseTime = remember {generateRandomTime(5,7)}
    val convertToFahrenheit = temperatureType == TemperatureType.Fahrenheit

    val windTime =  remember {generateRandomTime(8,10)}
    val sunsetTime =  remember {generateRandomTime(18,20)}
        var height = 250
    if (expanded )
        height = 760
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
                .height(height = height.dp)
                .animateContentSize()
                .clip(
                    RoundedCornerShape(
                        topEnd = 40.dp,
                        topStart = 40.dp
                    )
                )
                .background(color = Color.White)
        ) {
            if(!expanded)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 45.dp, end = 45.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.circle),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp), horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally,) {
                        Image(
                            painter = painterResource(id = R.drawable.sunrise_icon),
                            contentDescription = null
                        )
                        Text(
                            "Sunrise", style = myStyle.copy(
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Medium,
                                color = blackish
                            )
                        )
                        Text(
                            generateRandomTime(5,7), style = myStyle.copy(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                color = blackish
                            )
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.wind),
                            contentDescription = null
                        )
                        Text(
                            "Wind", style = myStyle.copy(
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Medium,
                                color = blackish
                            )
                        )
                        Text(
                            sunriseTime, style = myStyle.copy(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                color = blackish
                            )
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.sunset),
                            contentDescription = null
                        )
                        Text(
                            "Sunset", style = myStyle.copy(
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Medium,
                                color = blackish
                            )
                        )
                        Text(
                            sunsetTime, style = myStyle.copy(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                color = blackish
                            )
                        )
                    }
                }
                Divider(modifier = Modifier.padding(top = 16.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp)
                ) {
                    Text(
                        "Tomorrow", style = myStyle.copy(
                            color = blackish,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                    Box(
                        modifier = Modifier
                            .height(46.dp)
                            .width(1.dp)
                            .background(color = Color(0xFFD0D0D0))
                    )
                    Text(
                        "Next 7 days ", style = myStyle.copy(
                            color = blackish,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
            }
            else
                Box() {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 36.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            "Today, "+ getTodaysDate(), style = myStyleBlackColor.copy(
                                fontSize = 19.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                        Text(
                            "India", style = myStyleBlackColor.copy(
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Medium
                            ), modifier = Modifier.padding(top = 10.dp)
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.cloudy_small),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(10.3.dp))
                            Text(
                                "${27.convertToFahrenheit(convert =convertToFahrenheit )}", style = myStyleBlackColor.copy(
                                    fontSize = 41.sp,
                                    fontWeight = FontWeight.Bold,

                                    )
                            )
                            Text(
                                "°", style = myStyleBlackColor.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 20.sp
                                )
                            )
                            Text(
                                if(convertToFahrenheit)"F" else "C", style = myStyleBlackColor.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 25.sp
                                )
                            )

                        }
                        Text(
                            "Sunny with periodic clouds", style = myStyleBlackColor.copy(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium
                            )
                        )
                        Row() {
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
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally,) {
                                Image(
                                    painter = painterResource(id = R.drawable.sunrise_icon),
                                    contentDescription = null
                                )
                                Text(
                                    "Sunrise", style = myStyle.copy(
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = blackish
                                    )
                                )
                                Text(
                                   sunsetTime, style = myStyle.copy(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = blackish
                                    )
                                )
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(
                                    painter = painterResource(id = R.drawable.wind),
                                    contentDescription = null
                                )
                                Text(
                                    "Wind", style = myStyle.copy(
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = blackish
                                    )
                                )
                                Text(
                                    windTime, style = myStyle.copy(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = blackish
                                    )
                                )
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(
                                    painter = painterResource(id = R.drawable.sunset),
                                    contentDescription = null
                                )
                                Text(
                                    "Sunset", style = myStyle.copy(
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = blackish
                                    )
                                )
                                Text(
                                    sunsetTime, style = myStyle.copy(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = blackish
                                    )
                                )
                            }
                        }
                        Image(
                            painter = painterResource(id = R.drawable.group_73_temp),
                            contentDescription = null,
                            modifier = Modifier.padding(top = 20.dp)
                        )
                        LazyRow(modifier = Modifier.padding(horizontal = 15.dp, vertical = 22.dp)) {
                            items(count = 10) {
                                Column() {
                                    Row(
                                        modifier = Modifier.padding(end = 26.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.weather_icons_01),
                                            contentDescription = null
                                        )
                                        Text(
                                            (12..40).random().toString()+"°", style = myStyleBlackColor.copy(
                                                fontWeight = FontWeight.SemiBold,
                                                fontSize = 17.sp
                                            )
                                        )
                                    }
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(start = 5.dp, top = 3.dp)
                                    ) {
                                        Text(
                                            "${2*(it-1)+6}-${2*(it-1)+8}  ", style = myStyleBlackColor.copy(
                                                fontSize = 13.sp,
                                                fontWeight = FontWeight.Medium
                                            )
                                        )
                                        Text(
                                            if(2*(it-1)>=12)"PM" else "AM", style = myStyleBlackColor.copy(
                                                fontSize = 11.sp,
                                                fontWeight = FontWeight.Medium
                                            )
                                        )
                                    }
                                }
                            }
                        }
                        Text(
                            "Details", style = myStyleBlackColor.copy(
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp
                            ), modifier = Modifier.padding(top = 13.dp, bottom = 10.dp)
                        )
                        Row() {
                            Text(
                                "Humidity", style = myStyleBlackColor.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 13.sp,
                                    color = grayish

                                )
                            )
                            Text(
                                "20%", style = myStyleBlackColor.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 13.sp,
                                ), modifier = Modifier.padding(start = 20.dp)
                            )
                        }
                        Row(modifier = Modifier.padding(top = 10.dp)) {
                            Text(
                                "              UV index", style = myStyleBlackColor.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 13.sp,
                                    color = grayish
                                )
                            )
                            Text(
                                "Extreme, 11", style = myStyleBlackColor.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 13.sp,
                                ), modifier = Modifier.padding(start = 20.dp)
                            )
                        }
                    }

                }
        }

}
@ExperimentalAnimationApi
@Preview(widthDp = 600,heightDp = 250)
@Composable
fun BottomSheetPreview(){
    Surface(color = Color.White) {
        BottomSheet(expanded = true,temperatureType = TemperatureType.Celcius )
    }
}