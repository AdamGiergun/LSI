package eu.adamgiergun.lsi.users.data.remote

import androidx.lifecycle.LiveData
import eu.adamgiergun.lsi.users.data.local.db.UserDB

interface UsersRemoteRepository {

    val users: List<UserDB>?
    val error: LiveData<Boolean?>
    val errorInfoId: LiveData<Int?>
    val errorText: LiveData<String?>

    suspend fun refresh()
}