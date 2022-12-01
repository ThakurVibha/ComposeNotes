package com.example.cleanarchitechturenotesapp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cleanarchitechturenotesapp.ui.theme.Grey
import com.example.cleanarchitechturenotesapp.ui.theme.Roboto_Medium

@Composable
fun DefaultRadioButton(
    text: String,
    selected: Boolean,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier

) {

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {

        RadioButton(
            selected = selected, onClick = onSelect, colors = RadioButtonDefaults.colors(
                selectedColor = Grey,
                unselectedColor = Grey
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, style = TextStyle(
            fontFamily = Roboto_Medium,
            fontSize = 16.sp,
            color = Grey))
//        Spacer(modifier = Modifier.width(8.dp))
//        Text(text = text, style = MaterialTheme.typography.body1)
//        OutlinedButton(
//            enabled = selected,
//            onClick =
//            onSelect,
//            modifier = Modifier
//                .width(120.dp)
//                .height(50.dp),
//            //avoid the oval shape
//            shape = RoundedCornerShape(15.dp),
//            border = BorderStroke(2.dp, Color.Gray),
//            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Gray)
//        ) {
//            Spacer(modifier = Modifier.width(10.dp))
//            Text(
//                text = text, style = TextStyle(
//                    fontFamily = Roboto_Medium,
//                    fontSize = 16.sp,
//                    color = Color.Gray
//
//                )
//            )
//        }


    }


}