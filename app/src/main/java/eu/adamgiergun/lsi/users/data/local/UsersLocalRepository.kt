package eu.adamgiergun.lsi.users.data.local

import androidx.lifecycle.LiveData
import javax.inject.Singleton

@Singleton
interface UsersLocalRepository {
    fun getUsers(): LiveData<List<User>?>
}