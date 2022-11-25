package com.example.cleanarchitechturenotesapp.use_cases

import com.example.cleanarchitechturenotesapp.model.Note
import com.example.cleanarchitechturenotesapp.repository.NoteRepository
import com.example.cleanarchitechturenotesapp.util.NoteOrder
import com.example.cleanarchitechturenotesapp.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(private val repository: NoteRepository) {

    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(
            OrderType.Descending
        )
    ): Flow<List<Note>> {
        //put our business logic
        return repository.getNotes().map { notes ->
            when (noteOrder.orderType) {
                is OrderType.Ascending -> {

                    when (noteOrder) {

                        is NoteOrder.Title ->

                            notes.sortedBy {
                                it.title.toLowerCase()


                            }
                        is NoteOrder.Date ->

                            notes.sortedBy {

                                it.timestamp


                            }

                        is NoteOrder.Color ->
                            notes.sortedBy {
                                it.color


                            }
                    }


                }
                is OrderType.Descending ->
                    when (noteOrder) {

                        is NoteOrder.Title ->

                            notes.sortedByDescending {
                                it.title.toLowerCase()
                            }


                        is NoteOrder.Date ->

                            notes.sortedByDescending {

                                it.timestamp
                            }


                        is NoteOrder.Color ->
                            notes.sortedByDescending {
                                it.color
                            }


                    }


            }

        }
    }

}

