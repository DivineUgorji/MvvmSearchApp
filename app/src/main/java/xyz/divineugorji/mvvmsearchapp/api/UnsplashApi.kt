package xyz.divineugorji.mvvmsearchapp.api

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import xyz.divineugorji.mvvmsearchapp.BuildConfig


interface UnsplashApi {
    companion object{
        const val BASE_URL = "https://api.unsplash.com/"
        const val Client_ID = BuildConfig.UNSPLASH_ACCESS_KEY
    }
    @Headers ("Accept-Version: v1", "Authorization: Client-ID $Client_ID")
    @GET("search/photos")
    suspend fun searchPhotos
                (@Query("query") query: String,
                 @Query("page") page: Int,
                 @Query("per_page") per_page: Int
): UnsplashResponse

}