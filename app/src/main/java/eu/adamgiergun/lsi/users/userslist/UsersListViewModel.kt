package eu.adamgiergun.lsi.users.userslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eu.adamgiergun.lsi.users.data.local.UsersLocalRepository
import eu.adamgiergun.lsi.users.data.remote.UsersRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersListViewModel @Inject constructor(
    usersRemoteRepository: UsersRemoteRepository,
    usersLocalRepository: UsersLocalRepository
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            usersRemoteRepository.refresh()
        }
    }

    val usersList = usersLocalRepository.getUsers()
}