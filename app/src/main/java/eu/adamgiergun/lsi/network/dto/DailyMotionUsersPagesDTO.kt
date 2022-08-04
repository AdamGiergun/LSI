package eu.adamgiergun.lsi.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import eu.adamgiergun.lsi.users.data.local.UserDB

@JsonClass(generateAdapter = true)
data class DailyMotionUsersPagesDTO(
    val list: List<DailyMotionUserDTO>
) {
    @JsonClass(generateAdapter = true)
    data class DailyMotionUserDTO(
        val id: String,
        @Json(name = "screenname") val screenName: String
    )
}

fun DailyMotionUsersPagesDTO.asDbModel(): MutableList<UserDB> {
    val users = mutableListOf<UserDB>()
    list.forEach { userDTO ->
        users.add(
            UserDB(
                userDTO.id,
                userDTO.screenName,
                "",
                "Dailymotion"
            )
        )
    }
    return users
}