package com.example.cleanarchitechturenotesapp.use_cases

import com.example.cleanarchitechturenotesapp.model.Note
import com.example.cleanarchitechturenotesapp.repository.NoteRepository

class DeleteNotes(private val repository: NoteRepository) {

    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }




}