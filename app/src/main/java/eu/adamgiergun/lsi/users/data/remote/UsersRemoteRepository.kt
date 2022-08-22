package eu.adamgiergun.lsi.users.data.remote

import androidx.lifecycle.LiveData
import javax.inject.Singleton

@Singleton
interface UsersRemoteRepository {

    val error: LiveData<Boolean?>
    val errorInfoId: LiveData<Int?>
    val errorText: LiveData<String?>

    suspend fun refresh()
}