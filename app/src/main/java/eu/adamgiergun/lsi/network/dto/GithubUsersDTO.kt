package eu.adamgiergun.lsi.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import eu.adamgiergun.lsi.users.data.local.UserDB

@JsonClass(generateAdapter = true)
data class GithubUsersDTO (
    val githubUsers: List<GithubUser>
        ){
    @JsonClass(generateAdapter = true)
    data class GithubUser(
        val id: Int,
        @Json(name = "login") val userName: String,
        @Json(name = "avatar_url") val avatarUrl: String
    )
}

fun GithubUsersDTO.asDbModel(): MutableList<UserDB> {
    val users = mutableListOf<UserDB>()
    githubUsers.forEach { githubUser ->
        users.add(
            UserDB(
                githubUser.id.toString(),
                githubUser.userName,
                githubUser.avatarUrl,
                "GitHub"
            )
        )
    }
    return users
}