package com.example.cleanarchitechturenotesapp.repository

import com.example.cleanarchitechturenotesapp.data_source.NoteDao
import com.example.cleanarchitechturenotesapp.model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val dao: NoteDao) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNotesById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        return dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return dao.deleteNotes(note)
    }

}