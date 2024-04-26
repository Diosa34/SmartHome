package com.github.diosa.smarthome.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.diosa.smarthome.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign

@Preview(showBackground = true)
@Composable
fun Intercom() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            "Домофон",
            style = TextStyle(fontSize = 24.sp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .weight(0.2f)
                .wrapContentHeight(align = Alignment.CenterVertically),
        )
        Image(
            painter = painterResource(id = R.drawable.door),
            contentDescription = "outside",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .weight(0.4f)
                .clip(
            RoundedCornerShape(10.dp)
            )
        )
        Image(
            painter = painterResource(id = R.drawable.lock),
            contentDescription = "lock",
            modifier = Modifier
                .size(64.dp)
                .weight(0.5f)
        )
        Row(
            modifier = Modifier
                .weight(0.6f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.call_in),
                contentDescription = "call_in",
                modifier = Modifier
                    .size(32.dp)
                    .weight(1f)
            )
            Image(
                painter = painterResource(id = R.drawable.lock_open),
                contentDescription = "lock_open",
                modifier = Modifier
                    .size(24.dp)
                    .weight(1f)
            )
            Image(
                painter = painterResource(id = R.drawable.call_end),
                contentDescription = "call_end",
                modifier = Modifier
                    .size(32.dp)
                    .weight(1f)
            )
        }
    }
}