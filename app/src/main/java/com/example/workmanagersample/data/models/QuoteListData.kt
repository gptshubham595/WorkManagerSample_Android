package com.example.workmanagersample.data.models

data class QuoteListData(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<ResultData>,
    val totalCount: Int,
    val totalPages: Int,
)
