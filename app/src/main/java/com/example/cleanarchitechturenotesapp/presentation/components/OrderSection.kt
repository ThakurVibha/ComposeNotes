package com.example.cleanarchitechturenotesapp.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
            DefaultRadioButton(text = "Title",
                selected = notesOrder is NoteOrder.Title,
                onSelect = { onOrderChange(NoteOrder.Title(notesOrder.orderType)) })
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(text = "Date",
                selected = notesOrder is NoteOrder.Date,
                onSelect = { onOrderChange(NoteOrder.Date(notesOrder.orderType)) })
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(text = "Color",
                selected = notesOrder is NoteOrder.Color,
                onSelect = { onOrderChange(NoteOrder.Color(notesOrder.orderType)) })
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(text = "Ascending",
                selected = notesOrder.orderType is OrderType.Ascending,
                onSelect = { onOrderChange(notesOrder.copy(OrderType.Ascending)) })
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(text = "Descending",
                selected = notesOrder.orderType is OrderType.Descending,
                onSelect = { onOrderChange(notesOrder.copy(OrderType.Descending)) })
            Spacer(modifier = Modifier.width(8.dp))

        }


    }

}