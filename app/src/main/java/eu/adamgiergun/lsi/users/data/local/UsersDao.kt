package eu.adamgiergun.lsi.users.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {

    @Query("DELETE FROM UserDB")
    suspend fun deleteAll()

    @Query("SELECT * FROM UserDB")
    fun getUsers(): LiveData<List<UserDB>?>

    @Insert
    suspend fun insert(users: List<UserDB>)
}