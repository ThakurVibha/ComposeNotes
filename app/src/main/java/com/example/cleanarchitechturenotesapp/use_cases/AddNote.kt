package com.example.cleanarchitechturenotesapp.use_cases

import com.example.cleanarchitechturenotesapp.model.InvalidNoteException
import com.example.cleanarchitechturenotesapp.model.Note
import com.example.cleanarchitechturenotesapp.repository.NoteRepository

class AddNote(private val repository: NoteRepository) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can not be empty")

        }
        if(note.content.isBlank()){
            throw InvalidNoteException("The Content of the note can not be empty")

        }
        repository.insertNote(note)


    }
}