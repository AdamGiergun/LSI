package eu.adamgiergun.lsi.users.data.local

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class UserDB(
    @PrimaryKey val id: String,
    val name: String,
    val avatarUrl: String,
    val sourceApi: String
) : Parcelable