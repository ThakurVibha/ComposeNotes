package com.example.cleanarchitechturenotesapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cleanarchitechturenotesapp.ui.theme.*

@Entity
data class Note(
    val title: String, val content: String, val timestamp: Long,
    val color: Int, @PrimaryKey val id: Int?=null


) {
    companion object {
        val notesColors = listOf(
            Black,
            White,
            Red,

        )
    }


}

class InvalidNoteException(message:String):Exception(message)
