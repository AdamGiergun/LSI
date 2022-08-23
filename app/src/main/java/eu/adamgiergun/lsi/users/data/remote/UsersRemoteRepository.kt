package eu.adamgiergun.lsi.users.data.remote

import androidx.lifecycle.LiveData

interface UsersRemoteRepository {

    val error: LiveData<Boolean?>
    val errorInfoId: LiveData<Int?>
    val errorText: LiveData<String?>

    suspend fun refresh()
}