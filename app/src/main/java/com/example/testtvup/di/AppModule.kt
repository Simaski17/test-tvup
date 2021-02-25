package com.example.testtvup.di

import android.app.Application
import androidx.room.Room
import com.example.data.source.LocalDataSource
import com.example.data.source.RemoteDataSource
import com.example.testtvup.data.database.FeedDatabase
import com.example.testtvup.data.database.RoomDataSource
import com.example.testtvup.data.server.TheFeedDbDatasource
import com.example.testtvup.data.server.TheFeedDbService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun databaseProvider(app: Application) = Room.databaseBuilder(
            app,
            FeedDatabase::class.java,
            "feed-db"
    ).build()

    @Provides
    fun localDataSourceProvider(db: FeedDatabase): LocalDataSource = RoomDataSource(db)

    @Singleton
    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .callTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(provideInterceptor())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://tvup-265af-default-rtdb.firebaseio.com/")
            .client(provideHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitServiceApi(): TheFeedDbService {
        return provideRetrofit().create(TheFeedDbService::class.java)
    }

    @Provides
    fun remoteDataSourceProvider(theFeedDbService: TheFeedDbService): RemoteDataSource = TheFeedDbDatasource(theFeedDbService)

}