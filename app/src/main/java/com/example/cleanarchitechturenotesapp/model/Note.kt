package com.example.cleanarchitechturenotesapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cleanarchitechturenotesapp.ui.theme.*

@Entity
data class Note(
    val title: String, val content: String, val timestamp: Long,
    val color: Int, @PrimaryKey val id: Int


) {
    companion object {
        val notesColors = listOf(
            GreenBright,
            OrangeBright,
            YellowLemon,
            IndigoDye,
            PinkLavender,
            GreenAquaMarine,
            Campagne,
            DarkCyan,
            MintGreen,
            FireOpal,
            Yellow,
            Purple,
            Blue,
            BabyPink,
            SeaGreen,
            Red,
            EagleGreen,
            PurssianBlue
        )
    }
}
