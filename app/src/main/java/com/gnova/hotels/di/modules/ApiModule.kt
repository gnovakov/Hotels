package com.gnova.hotels.di.modules

import com.gnova.data.api.response.HotelsApi
import com.gnova.hotels.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class ApiModule {

    @Provides
    @Reusable
    fun providesRetrofit(
        okHttpClient: OkHttpClient.Builder): HotelsApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                okHttpClient
                    .build()
            )
            .addConverterFactory( MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // Needed for Rx
            .build()
            .create(HotelsApi::class.java)

    @Provides
    @Reusable
    fun providesOkHttpClient(): OkHttpClient.Builder =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

}