package eu.adamgiergun.lsi.network.apiservices

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import eu.adamgiergun.lsi.network.dto.DailyMotionUsersPagesDTO
import eu.adamgiergun.lsi.network.dto.GithubUserDTO
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val DAILYMOTION = "https://api.dailymotion.com/"
private const val GITHUB = "https://api.github.com/"

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
    suspend fun getUsers(): List<GithubUserDTO>
}

object UsersApis {
    val retrofitDailymotionApiService: DailymotionApiService by lazy {
        retrofitDailymotion.create(DailymotionApiService::class.java)
    }

    val retrofitGithubApiService: GithubApiService by lazy {
        retrofitGithub.create(GithubApiService::class.java)
    }
}