package com.example.workmanagersample.di

import com.example.workmanagersample.core.QuoteManagerRepoImpl
import com.example.workmanagersample.domain.repository.QuoteManagerRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun bindQuoteManagerRepo(quoteManagerRepoImpl: QuoteManagerRepoImpl): QuoteManagerRepo
}
