package com.example.testtvup.di

import com.example.data.repository.BackgroundsRepository
import com.example.data.repository.FeedMoviesRepository
import com.example.data.source.LocalDataSource
import com.example.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun backgroundsRepositoryProvider(localDataSource: LocalDataSource, remoteDataSource: RemoteDataSource) = BackgroundsRepository(localDataSource, remoteDataSource)

    @Provides
    fun feedMoviesRepositoryProvider(localDataSource: LocalDataSource, remoteDataSource: RemoteDataSource) = FeedMoviesRepository(localDataSource, remoteDataSource)


}