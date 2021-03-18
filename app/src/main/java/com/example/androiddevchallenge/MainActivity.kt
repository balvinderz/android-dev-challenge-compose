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
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.androiddevchallenge.ui.theme.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    var myList  = (0..50).toList()
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            Modifier
                .padding(all = 20.dp)
                .verticalScroll(rememberScrollState())) {
            Spacer(modifier = Modifier.padding(top = 80.dp))
            Text("Today",style = myStyle)
            Text("London",style = myStyle.copy(
                fontSize = 36.sp
            ))
            Text("19-02-2021",style = myStyle.copy(
                color = pinkish,

            ))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 45.dp)
            ){
                Image(painter = painterResource(id = R.drawable.rain_cloud_sun),contentDescription = null)
                Surface(color = borderColor,modifier = Modifier
                    .height(height = 42.dp)
                    .width(width = 1.dp)) {
                }
                Column {
                    Text("13°",style = myStyle.copy(
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Thin
                    ))
                    Text("Rainy Shower",style = myStyle.copy(
                        color = pinkish
                    ))
                }
            }
            Spacer(modifier = Modifier.height(27.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 45.dp)
            ){
                IconCard()
                IconCard()
                IconCard()
            }
            Spacer(modifier = Modifier.height(17.dp))
            Text("Today",style = myStyle.copy(
                fontSize = 16.sp
            ))
            Spacer(modifier = Modifier.height(19.dp))

            LazyRow() {
                items(count = 50) {
                    TemperatureContainer(modifier =Modifier)
                    Spacer(modifier = Modifier.width(14.dp))
                }
            }
            Spacer(modifier = Modifier.height(46.dp))
            NextDaysContainer()


        }

    }
}

@Composable
fun IconCard() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Surface(
            color = borderColor,
            shape = RoundedCornerShape(size = 12.dp,),
            modifier = Modifier.size(44.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.wind),
                contentDescription = null,
                modifier = Modifier.padding(12.dp)
            )

        }
        Spacer(modifier = Modifier.height(7.dp))
        Text(
            "19km/h", style = myStyle.copy(
                fontSize = 8.sp
            )
        )
    }
}

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
@Preview
@Composable
fun NextDaysContainer()
{
    Box(modifier = Modifier
        .fillMaxWidth()
        .clip(
            shape = RoundedCornerShape(
                topStart = 12.dp,
                topEnd = 50.dp,
                bottomEnd = 12.dp,
                bottomStart = 12.dp
            )
        )
        .background(color = Color(0xFFF4F4F8)))
    {
        Column(modifier = Modifier.padding(start = 11.dp,top = 15.dp,end = 12.dp)) {
         Text("Next Days",style = myStyle.copy(
             fontSize = 15.sp
         ))
            Divider(modifier = Modifier.padding(top = 12.dp))
            Row(

                modifier = Modifier.padding(start = 9.dp,top = 16.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text("Monday, Feb 20",style = myStyle.copy(
                    fontSize = 10.sp
                ) )
                Image(painter = painterResource(id = R.drawable.rainy),contentDescription = "rainy")
                Text("14°/12°",style = myStyle.copy(
                    fontSize = 10.sp
                ) )
            }
            Divider(modifier = Modifier.padding(top = 12.dp))
            Row(

                modifier = Modifier.padding(start = 9.dp,top = 16.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text("Monday, Feb 20",style = myStyle.copy(
                    fontSize = 10.sp
                ) )
                Image(painter = painterResource(id = R.drawable.rainy),contentDescription = "rainy")
                Text("14°/12°",style = myStyle.copy(
                    fontSize = 10.sp
                ) )
            }
            Divider(modifier = Modifier.padding(top = 12.dp))
            Row(

                modifier = Modifier.padding(start = 9.dp,top = 16.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text("Monday, Feb 20",style = myStyle.copy(
                    fontSize = 10.sp
                ) )
                Image(painter = painterResource(id = R.drawable.rainy),contentDescription = "rainy")
                Text("14°/12°",style = myStyle.copy(
                    fontSize = 10.sp
                ) )
            }
            Divider(modifier = Modifier.padding(top = 12.dp))
            Row(

                modifier = Modifier.padding(start = 9.dp,top = 16.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text("Monday, Feb 20",style = myStyle.copy(
                    fontSize = 10.sp
                ) )
                Image(painter = painterResource(id = R.drawable.rainy),contentDescription = "rainy")
                Text("14°/12°",style = myStyle.copy(
                    fontSize = 10.sp
                ) )
            }
            Divider(modifier = Modifier.padding(top = 12.dp))
            Row(

                modifier = Modifier.padding(start = 9.dp,top = 16.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text("Monday, Feb 20",style = myStyle.copy(
                    fontSize = 10.sp
                ) )
                Image(painter = painterResource(id = R.drawable.rainy),contentDescription = "rainy")
                Text("14°/12°",style = myStyle.copy(
                    fontSize = 10.sp
                ) )
            }
            Divider(modifier = Modifier.padding(top = 12.dp))
            Row(

                modifier = Modifier.padding(start = 9.dp,top = 16.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text("Monday, Feb 20",style = myStyle.copy(
                    fontSize = 10.sp
                ) )
                Image(painter = painterResource(id = R.drawable.rainy),contentDescription = "rainy")
                Text("14°/12°",style = myStyle.copy(
                    fontSize = 10.sp
                ) )
            }
            Divider(modifier = Modifier.padding(top = 12.dp))
            Row(

                modifier = Modifier.padding(start = 9.dp,top = 16.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text("Monday, Feb 20",style = myStyle.copy(
                    fontSize = 10.sp
                ) )
                Image(painter = painterResource(id = R.drawable.rainy),contentDescription = "rainy")
                Text("14°/12°",style = myStyle.copy(
                    fontSize = 10.sp
                ) )
            }
        }
    }
}
//@Preview("Light Theme", widthDp = 360, heightDp = 640)
//@Composable
//fun LightPreview() {
//    MyTheme {
//        MyApp()
//    }
//}
//
//@Preview("Dark Theme", widthDp = 360, heightDp = 640)
//@Composable
//fun DarkPreview() {
//    MyTheme(darkTheme = true) {
//        MyApp()
//    }
//}
