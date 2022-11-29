package com.example.cleanarchitechturenotesapp.use_cases

import com.example.cleanarchitechturenotesapp.model.Note
import com.example.cleanarchitechturenotesapp.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNotesById(id)
    }
}