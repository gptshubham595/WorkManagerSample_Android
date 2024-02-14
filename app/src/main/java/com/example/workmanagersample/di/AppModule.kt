package com.example.workmanagersample.di

import android.app.Application
import androidx.room.Room
import com.example.workmanagersample.common.APIConstants.BASE_URL
import com.example.workmanagersample.common.DBConstants.DB_NAME
import com.example.workmanagersample.data.api.QuoteService
import com.example.workmanagersample.data.db.QuoteDao
import com.example.workmanagersample.data.db.QuoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiInterface(): QuoteService {
        val okHttpClient = OkHttpClient.Builder()
            .build()

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofit.create(
            QuoteService::class.java,
        )
    }

    @Provides
    @Singleton
    fun provideRoomDataBase(application: Application): QuoteDatabase {
        return Room.databaseBuilder(application, QuoteDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideTodoDao(quoteDatabase: QuoteDatabase): QuoteDao {
        return quoteDatabase.getQuoteDao()
    }
}
