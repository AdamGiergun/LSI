package eu.adamgiergun.lsi.users.data.local

import androidx.lifecycle.LiveData

interface UsersLocalRepository {
    fun getUsers(): LiveData<List<User>?>
}