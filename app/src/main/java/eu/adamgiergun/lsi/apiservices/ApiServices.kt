package eu.adamgiergun.lsi.apiservices

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import eu.adamgiergun.lsi.dto.DailyMotionUsersPagesDTO
import eu.adamgiergun.lsi.dto.GithubUsersDTO
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val DAILYMOTION = "https://api.dailymotion.com/"
private const val GITHUB = "https://api.github.com/users"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofitDailymotion = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(DAILYMOTION)
    .build()

private val retrofitGithub = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(GITHUB)
    .build()

interface DailymotionApiService{
    @GET("users")
    suspend fun getUsers(): DailyMotionUsersPagesDTO
}

interface GithubApiService{
    @GET("users")
    suspend fun getUsers(): GithubUsersDTO
}