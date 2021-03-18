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

import UpperPart
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
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
import androidx.core.view.WindowCompat
import com.example.androiddevchallenge.composables.ComfortContainer
import com.example.androiddevchallenge.composables.NextDaysContainer
import com.example.androiddevchallenge.composables.WindContainer
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
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            UpperPart()
            NextDaysContainer(modifier = Modifier.padding(horizontal = 20.dp))
            ComfortContainer(modifier = Modifier.padding(all = 20.dp))
            Divider(modifier = Modifier.padding(top = 25.dp))
            WindContainer(modifier = Modifier.padding(horizontal = 20.dp))

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


//@Preview("Light Theme", widthDp = 360, heightDp = 640)

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
