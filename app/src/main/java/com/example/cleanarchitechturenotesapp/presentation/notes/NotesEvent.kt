package com.example.cleanarchitechturenotesapp.presentation.notes

import com.example.cleanarchitechturenotesapp.model.Note
import com.example.cleanarchitechturenotesapp.util.NoteOrder

sealed class NotesEvent{
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
