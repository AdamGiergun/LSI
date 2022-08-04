package eu.adamgiergun.lsi.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DailyMotionUsersPagesDTO (
    val pages: List<PageDTO>
        ){
    @JsonClass(generateAdapter = true)
    data class PageDTO(
        val id: Int,
        val DailymotionUsersDTO: List<DailyMotionUserDTO>
    ) {
        @JsonClass(generateAdapter = true)
        data class DailyMotionUserDTO(
            val id: String,
            @Json(name = "screenname") val screenName: String
        )
    }
}