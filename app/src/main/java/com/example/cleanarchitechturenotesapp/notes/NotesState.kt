package com.example.cleanarchitechturenotesapp.notes

import com.example.cleanarchitechturenotesapp.model.Note
import com.example.cleanarchitechturenotesapp.util.NoteOrder
import com.example.cleanarchitechturenotesapp.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
