package com.example.cleanarchitechturenotesapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cleanarchitechturenotesapp.util.NoteOrder
import com.example.cleanarchitechturenotesapp.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    notesOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
) {

    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(text = "Title", selected =  notesOrder is NoteOrder.Title, onSelect = { /*TODO*/ })

        }
    }

}