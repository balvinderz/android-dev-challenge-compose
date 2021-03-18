package com.example.androiddevchallenge.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.myStyle

@Composable
fun TemperatureContainer(modifier: Modifier){
    Box(
        modifier = Modifier
            .width(68.dp)
            .height(110.dp)
            .clip(
                shape = RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 30.dp,
                    bottomEnd = 8.dp,
                    bottomStart = 30.dp
                )
            )
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF467BFF),
                        Color(0xFFC661FF)
                    )
                )
            )
    ) {
        Column(modifier = Modifier.padding(15.dp),horizontalAlignment = Alignment.CenterHorizontally) {
            Text("12:00am",style = myStyle.copy(
                fontSize = 8.sp,
                color = Color.White
            ))
            Spacer(modifier = Modifier.height(11.dp))
            Image(painter = painterResource(id = R.drawable.rain_cloud_sun_small),contentDescription = null)
            Text("13°",style = myStyle.copy(
                color = Color.White,
                fontSize = 12.sp
            ))
        }

    }

}