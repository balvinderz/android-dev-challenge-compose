package com.example.androiddevchallenge.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.borderColor
import com.example.androiddevchallenge.ui.theme.myStyle

@Composable
fun ComfortContainer(modifier : Modifier)
{
        Column(modifier = modifier) {
            Text("Comfort Level",style = myStyle.copy(
                fontSize = 16.sp
            ) )
            Box(
                modifier = Modifier.size(95.dp).clip(CircleShape).background(color = Color.Blue).
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 26.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text("Feels like 10°",style = myStyle.copy(
                    fontSize = 12.sp
                ))
                Surface(color = borderColor,modifier = Modifier
                    .height(height = 42.dp)
                    .width(width = 1.dp)) {
                }
                Text("UV Index 0 low",style = myStyle)
            }
        }
}
