package com.example.cleanarchitechturenotesapp.presentation.note_folder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cleanarchitechturenotesapp.R
import com.example.cleanarchitechturenotesapp.ui.theme.*

@Composable
fun FolderScreen(

) {
    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(30),
            modifier = Modifier
                .width(80.dp)
                .height(80.dp),
            backgroundColor = Red,
        ) {
            Icon(Icons.Default.Add, contentDescription = "null", tint = White)

        }

    }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Black)
        )
        {

            Column {
                Row(
                    modifier = Modifier
                        .padding(15.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "folders", style = TextStyle(
                            fontFamily = Roboto_Bold,
                            fontSize = 35.sp,
                            color = White

                        )
                    )

                    Icon(
                        tint = White,
                        painter = painterResource(id = R.drawable.calender_icon),

                        contentDescription = "null"
                    )

                }

                Spacer(modifier = Modifier.height(5.dp))
                LazyColumn() {
                    itemsIndexed(
                        listOf(
                            "personal Notes",
                            "feelings",
                            "morning pages",
                            "ideas",
                            "daily dose"
                        )
                    ) { _, string ->
                        Card(
                            modifier = Modifier
                                .padding(10.dp),
                            elevation = 10.dp,
                            shape = RoundedCornerShape(30.dp),
                            backgroundColor = LightBlack
                        ) {

                            Column(
                                modifier = Modifier
                                    .padding(15.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {

                                    Text(
                                        text = string, style = TextStyle(
                                            fontFamily = Roboto_Medium,
                                            fontSize = 18.sp,
                                            color = LightGrey

                                        )
                                    )

                                    Icon(
                                        painter = painterResource(id = R.drawable.forward),
                                        contentDescription = "null",
                                        tint= White
                                    )
                                }
                                Spacer(modifier = Modifier.height(40.dp))

                                Text(
                                    text = "23", style = TextStyle(
                                        fontFamily = Roboto_Bold,
                                        fontSize = 50.sp,
                                        color = White

                                    )
                                )
                            }

                        }


                    }
                }


            }


        }

    }




}