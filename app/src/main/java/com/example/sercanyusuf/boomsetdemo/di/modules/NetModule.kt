package com.example.sercanyusuf.boomsetdemo.di.modules

import com.example.sercanyusuf.boomsetdemo.util.AppConstants.BASE_URL
import dagger.Module
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetModule {


    internal var okHttpClient = OkHttpClient().newBuilder().addInterceptor { chain ->
        val originalRequest = chain.request()

        val builder = originalRequest.newBuilder().addHeader("Authorization", "Token 4f81fed8ec862793b0abb9318b2066c47439bb13")

        val newRequest = builder.build()
        chain.proceed(newRequest)
    }.build()

    private var retrofit: Retrofit? = null
    val client: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .client(okHttpClient)
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit
        }

}
