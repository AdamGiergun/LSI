package eu.adamgiergun.lsi.users.userslist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import eu.adamgiergun.lsi.users.data.local.LocalDB
import eu.adamgiergun.lsi.users.data.local.UsersLocalRepository
import eu.adamgiergun.lsi.users.data.local.UsersLocalRepositoryImpl
import eu.adamgiergun.lsi.users.data.remote.UsersRemoteRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersListViewModel(
    app: Application,
    ) : AndroidViewModel(app) {

    private val usersLocalRepository: UsersLocalRepository

    init {
        val dao = LocalDB.getDatabase(app.applicationContext).usersDao()
        usersLocalRepository = UsersLocalRepositoryImpl(dao)
        val usersRemoteRepository = UsersRemoteRepositoryImpl()
        viewModelScope.launch(Dispatchers.IO) {
            usersRemoteRepository.refresh()
        }
    }

    val usersList = usersLocalRepository.getUsers()
}