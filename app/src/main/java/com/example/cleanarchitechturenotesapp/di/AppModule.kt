package com.example.cleanarchitechturenotesapp.di

import android.app.Application
import androidx.room.Room
import com.example.cleanarchitechturenotesapp.data_source.NoteDatabase
import com.example.cleanarchitechturenotesapp.repository.NoteRepository
import com.example.cleanarchitechturenotesapp.repository.NoteRepositoryImpl
import com.example.cleanarchitechturenotesapp.use_cases.DeleteNotes
import com.example.cleanarchitechturenotesapp.use_cases.GetNotes
import com.example.cleanarchitechturenotesapp.use_cases.NotesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(app, NoteDatabase::class.java, NoteDatabase.DATABASE_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun provideNotesRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)

    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NotesUseCases {

        return NotesUseCases(getNotes = GetNotes(repository), deleteNotes = DeleteNotes(repository))
    }
}