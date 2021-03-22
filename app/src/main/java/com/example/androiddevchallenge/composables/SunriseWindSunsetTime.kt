package com.example.androiddevchallenge.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.blackish
import com.example.androiddevchallenge.ui.theme.myStyle

@Composable
fun SunriseWindSunsetTime(
    sunriseTime: String,
    windTime: String,
    sunsetTime: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        TimeColumn(
            iconId = R.drawable.sunrise,
            text = stringResource(id = R.string.sunrise),
            time = sunriseTime,
            contentDescription = stringResource(id = R.string.sunrise)
        )
        TimeColumn(
            iconId = R.drawable.wind,
            text = stringResource(id = R.string.wind),
            time = windTime,
            contentDescription = stringResource(id = R.string.wind)
        )
        TimeColumn(
            iconId = R.drawable.sunset,
            text = stringResource(id = R.string.sunset),
            time = sunsetTime,
            contentDescription = stringResource(id = R.string.sunset)
        )
    }
}

@Composable
private fun TimeColumn(
    iconId: Int,
    text: String,
    time: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = contentDescription
        )
        Text(
            text,
            style = myStyle.copy(
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = blackish
            )
        )
        Text(
            time,
            style = myStyle.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = blackish
            )
        )
    }

}