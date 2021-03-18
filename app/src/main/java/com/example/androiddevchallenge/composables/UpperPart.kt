import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.IconCard
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.composables.TemperatureContainer
import com.example.androiddevchallenge.ui.theme.borderColor
import com.example.androiddevchallenge.ui.theme.myStyle
import com.example.androiddevchallenge.ui.theme.pinkish

@Composable
fun UpperPart() {
    Column(
        Modifier
            .padding(all = 20.dp)
    ) {
        Spacer(modifier = Modifier.padding(top = 80.dp))
        Text("Today", style = myStyle)
        Text(
            "London", style = myStyle.copy(
                fontSize = 36.sp
            )
        )
        Text(
            "19-02-2021", style = myStyle.copy(
                color = pinkish,

                )
        )
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 45.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.rain_cloud_sun),
                contentDescription = null
            )
            Surface(
                color = borderColor, modifier = Modifier
                    .height(height = 42.dp)
                    .width(width = 1.dp)
            ) {
            }
            Column {
                Text(
                    "13°", style = myStyle.copy(
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Thin
                    )
                )
                Text(
                    "Rainy Shower", style = myStyle.copy(
                        color = pinkish
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(27.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 45.dp)
        ) {
            IconCard()
            IconCard()
            IconCard()
        }
        Spacer(modifier = Modifier.height(17.dp))
        Text(
            "Today", style = myStyle.copy(
                fontSize = 16.sp
            )
        )
        Spacer(modifier = Modifier.height(19.dp))

        LazyRow() {
            items(count = 50) {
                TemperatureContainer(modifier = Modifier)
                Spacer(modifier = Modifier.width(14.dp))
            }
        }
        Spacer(modifier = Modifier.height(46.dp))
    }
}