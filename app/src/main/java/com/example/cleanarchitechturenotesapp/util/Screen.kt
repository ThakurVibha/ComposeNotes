package com.example.cleanarchitechturenotesapp.util

sealed class Screen(val route:String) {

    object NotesScreen:Screen("notes_screen")
    object AddEditNoteScreen:Screen("addd_edit_notes_screen")
}