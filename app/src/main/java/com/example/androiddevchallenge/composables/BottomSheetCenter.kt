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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.blackish
import com.example.androiddevchallenge.ui.theme.myStyle
import com.example.androiddevchallenge.R

@Composable
fun BottomSheetCenter() {
    Row(
        modifier = Modifier
            .fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .width(69.dp).clip(
                    RoundedCornerShape(
                        11.dp
                    )
                )
                .background(color = Color(0xFFFEC86F))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.weather_icons_01),
                    contentDescription = null,
                )
                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 6.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.thermometer),
                        contentDescription = "Thermometer",
                        modifier = Modifier.padding(end = 5.dp)
                    )
                    Text(
                        "37°", style = myStyle.copy(
                            fontWeight = FontWeight.Normal,
                            color = blackish,
                            fontSize = 19.sp
                        )
                    )
                    Text(
                        "C", style = myStyle.copy(
                            fontWeight = FontWeight.Normal,
                            color = blackish,
                            fontSize = 11.sp
                        )
                    )
                }

                Column(modifier = Modifier.padding(top = 5.dp).height(26.dp).fillMaxWidth().background(color = Color(0xFFFDD38B)),verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        "15:25",
                        style = myStyle.copy(
                            color = blackish,
                            fontWeight = FontWeight.Normal,
                            fontSize = 15.sp,
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.5.sp
                        ),)
                }

            }
        }
    }

}
