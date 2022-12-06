package com.sorabh.qnaapp.di

import com.sorabh.qnaapp.network.ApiInterface
import com.sorabh.qnaapp.repository.QuestionRepository
import com.sorabh.qnaapp.repository.QuestionRepositoryImpl
import com.sorabh.qnaapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)


    @Provides
    @Singleton
    fun provideOkhttp(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient()
            .newBuilder()
            .addInterceptor(interceptor)
            .build()

    @Provides
    @Singleton
    fun provideRetrofitClient(okHttpClient: OkHttpClient): Retrofit =
        Retrofit
            .Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun providesAPIInterface(retrofit: Retrofit): ApiInterface =
        retrofit.create(ApiInterface::class.java)

    @Provides
    @Singleton
    fun provideQuestionsRepository(questionRepository: QuestionRepositoryImpl): QuestionRepository =
        questionRepository
}