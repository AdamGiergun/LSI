package eu.adamgiergun.lsi.users.userslist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import eu.adamgiergun.lsi.users.data.local.UsersLocalRepository
import eu.adamgiergun.lsi.users.data.local.UsersLocalRepositoryImpl
import eu.adamgiergun.lsi.users.data.local.db.LocalDB
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
        viewModelScope.launch(Dispatchers.IO) {
            val usersRemoteRepository = UsersRemoteRepositoryImpl()
            usersRemoteRepository.refresh()
            dao.apply {
                deleteAll()
                insert(usersRemoteRepository.users)
            }
        }
    }

    val usersList = usersLocalRepository.getUsers()
}