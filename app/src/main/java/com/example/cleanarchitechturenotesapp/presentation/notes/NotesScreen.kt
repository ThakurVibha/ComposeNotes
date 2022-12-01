package com.example.cleanarchitechturenotesapp.presentation.notes

import NoteItem
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cleanarchitechturenotesapp.R
import com.example.cleanarchitechturenotesapp.presentation.components.OrderSection
import com.example.cleanarchitechturenotesapp.ui.theme.Roboto_Bold
import com.example.cleanarchitechturenotesapp.ui.theme.Roboto_Medium
import com.example.cleanarchitechturenotesapp.util.Screen
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@Composable
fun NotesScreen(
    navController: NavController,
    viewModel: NotesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddEditNoteScreen.route)
                },
                backgroundColor = Color.DarkGray
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add note")
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(
                text = "personal notes",
                style = TextStyle(
                    fontFamily = Roboto_Bold,
                    fontSize = 30.sp,
                    color = Color.Black


                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(enabled = true, reverseScrolling = true, state = scrollState),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                OutlinedButton(
                    onClick = {
//                        viewModel.onEvent(NotesEvent.ToggleOrderSection)
                    },

                    modifier = Modifier
                        .width(120.dp)
                        .height(50.dp),  //avoid the oval shape
                    shape = RoundedCornerShape(15.dp),
                    border = BorderStroke(2.dp, Color.Gray),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Gray),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.iconfilter),
                        contentDescription = "content description"
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "filters", style = TextStyle(
                            fontFamily = Roboto_Medium,
                            fontSize = 16.sp,
                            color = Color.Gray

                        )
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                AnimatedVisibility(
                    visible = state.isOrderSectionVisible,
                    enter = fadeIn() + slideInVertically(),
                    exit = fadeOut() + slideOutVertically()
                ) {
                    OrderSection(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        notesOrder = state.noteOrder,
                        onOrderChange = {
                            viewModel.onEvent(NotesEvent.Order(it))
                        }
                    )
                }
            }
//            AnimatedVisibility(
//                visible = state.isOrderSectionVisible,
//                enter = fadeIn() + slideInVertically(),
//                exit = fadeOut() + slideOutVertically()
//            ) {
//                OrderSection(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(vertical = 16.dp),
//                    notesOrder = state.noteOrder,
//                    onOrderChange = {
//                        viewModel.onEvent(NotesEvent.Order(it))
//                    }
//                )
//            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.notes) { note ->
                    NoteItem(
                        note = note,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(
                                    Screen.AddEditNoteScreen.route +
                                            "?noteId=${note.id}&noteColor=${note.color}"
                                )
                            },
                        onDeleteClick = {
                            viewModel.onEvent(NotesEvent.DeleteNote(note))
                            scope.launch {
                                val result = scaffoldState.snackbarHostState.showSnackbar(
                                    message = "Note deleted",
                                    actionLabel = "Undo"
                                )
                                if (result == SnackbarResult.ActionPerformed) {
                                    viewModel.onEvent(NotesEvent.RestoreNote)
                                }
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}