package com.example.workmanagersample.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.workmanagersample.common.DBConstants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class ResultData(
    @PrimaryKey(autoGenerate = true)
    val quoteId: Int,
    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
)
