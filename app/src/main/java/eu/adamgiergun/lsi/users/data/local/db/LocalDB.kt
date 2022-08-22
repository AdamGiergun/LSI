package eu.adamgiergun.lsi.users.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        UserDB::class
    ],
    version = 1,
    exportSchema = true
)
abstract class LocalDB : RoomDatabase() {

    abstract fun usersDao(): UsersDao

    companion object {
        @Volatile
        private var INSTANCE: LocalDB? = null

        fun getDatabase(
            context: Context
        ): LocalDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    LocalDB::class.java,
                    "local.db"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}