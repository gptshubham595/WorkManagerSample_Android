package com.example.workmanagersample.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.workmanagersample.common.DBConstants.TABLE_NAME
import com.example.workmanagersample.data.models.ResultData

@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuotes(quotes: List<ResultData>)

    @Query("SELECT * FROM $TABLE_NAME")
    suspend fun getQuotes(): List<ResultData>
}
