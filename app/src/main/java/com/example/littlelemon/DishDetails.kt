package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable


fun DishDetails(Dish: Dish) {

    Column {
        Row (modifier = Modifier.fillMaxWidth()){
            Image(
                painter = painterResource(id = Dish.image),
                contentDescription = ""
            )
        }
        Text(
            text = Dish.name, fontSize = 18.sp, fontWeight = FontWeight.Bold
        )
        Text(
            text = Dish.description,
            color = Color.Gray,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
                .fillMaxWidth(.75f)
        )

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Add For ${Dish.price}")
        }
    }

}
