package com.example.workmanagersample.domain

import com.example.workmanagersample.data.models.QuoteListData
import com.example.workmanagersample.data.models.ResultData
import com.example.workmanagersample.domain.models.QuoteListEntity
import com.example.workmanagersample.domain.models.ResultEntity

fun QuoteListData.toDomain() = QuoteListEntity(
    count = count,
    lastItemIndex = lastItemIndex,
    page = page,
    results = results.map { it.toDomain() },
    totalCount = totalCount,
    totalPages = totalPages,
)

fun ResultData.toDomain() = ResultEntity(
    quoteId = quoteId,
    _id = _id,
    author = author,
    authorSlug = authorSlug,
    content = content,
    dateAdded = dateAdded,
    dateModified = dateModified,
    length = length,
)
