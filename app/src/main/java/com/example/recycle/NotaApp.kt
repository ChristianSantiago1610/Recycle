package com.example.recycle

import android.app.Application
import androidx.room.Room
import com.example.recycle.db.NotasDB


class NotaApp: Application() {
        val room = Room
            .databaseBuilder(this,NotasDB::class.java,"notas_db")
            .build()

}