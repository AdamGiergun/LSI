package eu.adamgiergun.lsi.users.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import eu.adamgiergun.lsi.R
import eu.adamgiergun.lsi.network.apiservices.UsersApis
import eu.adamgiergun.lsi.network.dto.asDbModel
import eu.adamgiergun.lsi.users.data.local.db.UserDB

class UsersRemoteRepositoryImpl: UsersRemoteRepository {

    private val _users = MutableLiveData<List<UserDB>?>()
    override val users: LiveData<List<UserDB>?>
        get() = _users

    private val _error = MutableLiveData<Boolean?>()
    override val error: LiveData<Boolean?>
        get() = _error

    private val _errorInfoId = MutableLiveData<Int?>()
    override val errorInfoId: LiveData<Int?>
        get() = _errorInfoId

    private val _errorText = MutableLiveData<String?>()
    override val errorText: LiveData<String?>
        get() = _errorText

    override suspend fun refresh() {
        _users.postValue(null)
        _error.postValue(null)
        _errorInfoId.postValue(null)
        _errorText.postValue(null)

        try {
            val usersDB: MutableList<UserDB> = UsersApis.retrofitGithubApiService.getUsers().map {
                it.asDbModel()
            }.toMutableList()
            usersDB += UsersApis.retrofitDailymotionApiService.getUsers().asDbModel()
            _users.postValue(usersDB)
        } catch (e: Exception) {
            _errorInfoId.postValue(R.string.error_connecting_data_source_on_internet)
            _errorText.postValue(e.localizedMessage ?: "")
            _error.postValue(true)
            _users.postValue(null)
        }
    }
}