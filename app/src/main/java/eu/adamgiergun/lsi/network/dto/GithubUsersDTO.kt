package eu.adamgiergun.lsi.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import eu.adamgiergun.lsi.users.data.local.db.UserDB

@JsonClass(generateAdapter = true)
data class GithubUserDTO(
    val id: Int,
    @Json(name = "login") val userName: String,
    @Json(name = "avatar_url") val avatarUrl: String
)