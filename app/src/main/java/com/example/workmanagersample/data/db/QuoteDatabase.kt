package com.example.workmanagersample.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.workmanagersample.common.DBConstants.DB_VERSION
import com.example.workmanagersample.data.models.ResultData

@Database(entities = [ResultData::class], version = DB_VERSION)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun getQuoteDao(): QuoteDao

    companion object {
        @Volatile
        private var INSTANCE: QuoteDatabase? = null

        fun getDatabase(context: Context): QuoteDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        QuoteDatabase::class.java,
                        "quoteDB"
                    )
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}
