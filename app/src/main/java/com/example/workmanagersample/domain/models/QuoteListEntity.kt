package com.example.workmanagersample.domain.models

data class QuoteListEntity(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<ResultEntity>,
    val totalCount: Int,
    val totalPages: Int,
)
