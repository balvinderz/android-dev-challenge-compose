package com.example.androiddevchallenge.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.myStyle
import com.example.androiddevchallenge.R

@Composable
fun NextDaysContainer(modifier: Modifier)
{
    Box(modifier = modifier
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

                modifier = Modifier
                    .padding(start = 9.dp, top = 16.dp)
                    .fillMaxWidth(),
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

                modifier = Modifier
                    .padding(start = 9.dp, top = 16.dp)
                    .fillMaxWidth(),
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

                modifier = Modifier
                    .padding(start = 9.dp, top = 16.dp)
                    .fillMaxWidth(),
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

                modifier = Modifier
                    .padding(start = 9.dp, top = 16.dp)
                    .fillMaxWidth(),
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

                modifier = Modifier
                    .padding(start = 9.dp, top = 16.dp)
                    .fillMaxWidth(),
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

                modifier = Modifier
                    .padding(start = 9.dp, top = 16.dp)
                    .fillMaxWidth(),
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

                modifier = Modifier
                    .padding(start = 9.dp, top = 16.dp)
                    .fillMaxWidth(),
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