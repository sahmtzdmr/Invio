package com.sadikahmetozdemir.invio.di

import com.sadikahmetozdemir.invio.core.repository.DefaultRepository
import com.sadikahmetozdemir.invio.core.service.MovieAPI
import com.sadikahmetozdemir.invio.core.utils.NetworkInterceptor
import com.sadikahmetozdemir.invio.utils.Constant
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
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieService(retrofitClient: Retrofit) = retrofitClient.create(MovieAPI::class.java)

    @Provides
    @Singleton
    fun provideDefaultRepository(
        movieAPI: MovieAPI
    ): DefaultRepository {
        return DefaultRepository(movieAPI)
    }

    @Provides
    @Singleton
    fun provideInterceptor(networkInterceptor: NetworkInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(networkInterceptor)
            .build()
    }
}