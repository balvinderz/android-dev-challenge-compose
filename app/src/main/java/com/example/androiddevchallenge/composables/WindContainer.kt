package com.example.androiddevchallenge.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.borderColor
import com.example.androiddevchallenge.ui.theme.myStyle


@Composable
fun WindContainer(modifier: Modifier)
{

    Column(
        modifier
            .fillMaxWidth().padding(top = 12.dp)) {
        Text("Wind",style = myStyle.copy(
            fontSize = 16.sp,
        ))
        Image(
            painter = painterResource(id = R.drawable.windmill),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            alignment = Alignment.Center
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 26.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text("Direction North",style = myStyle.copy(
                fontSize = 12.sp
            ))
            Surface(color = borderColor,modifier = Modifier
                .height(height = 42.dp)
                .width(width = 1.dp)) {
            }
            Text("Speed  12 km/h",style = myStyle)
        }

    }
}