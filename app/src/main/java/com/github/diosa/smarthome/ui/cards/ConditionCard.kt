package com.github.diosa.smarthome.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.diosa.smarthome.R
import com.github.diosa.smarthome.ui.theme.Orange

@Preview(showBackground = true)
@Composable
fun ConditionCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Orange

        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cond),
                    contentDescription = "Air conditioning",
                    modifier = Modifier
                        .weight(2f)
                        .alpha(0.7f)
                        .size(32.dp)
                )
                Text(
                    text = "Air conditioning",
                    modifier = Modifier
                        .weight(4f),
                    style = TextStyle(fontSize = 20.sp),
                    color = Color.DarkGray
                )
                var switchValue by remember { mutableStateOf(true) }
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .weight(7f, true)
                ) {
                    Switch(
                        checked = switchValue,
                        onCheckedChange = { switchValue = it },
                        modifier = Modifier
                            .padding(end = 16.dp)
//                    colors = SwitchDefaults.colors(
//
//                    )
                    )
                }

            }



            var sliderValue by remember { mutableFloatStateOf(24f) }
            Text(
                text = sliderValue.toInt().toString() + " ºC",
                style = TextStyle(fontSize = 20.sp),
                color = Color.DarkGray
            )
            Slider(
                value = sliderValue,
                onValueChange = { sliderValue = it },
                valueRange = -10f..42f,
                steps = 52,
                modifier = Modifier
                    .width(250.dp),
                colors = SliderDefaults.colors(
                    thumbColor = Orange,
                    activeTrackColor = Orange,
                    inactiveTrackColor = Color.Gray,
                ),
            )
        }
    }
}