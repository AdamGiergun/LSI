package eu.adamgiergun.lsi.users.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [UserDB::class],
    version = 1,
    exportSchema = true
)
abstract class LocalDB : RoomDatabase() {

    abstract fun usersDao(): UsersDao
}