package eu.adamgiergun.lsi.users.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import eu.adamgiergun.lsi.R
import eu.adamgiergun.lsi.network.apiservices.UsersApis
import eu.adamgiergun.lsi.network.dto.asDbModel
import eu.adamgiergun.lsi.users.data.local.db.UsersDao
import javax.inject.Inject

class UsersRemoteRepositoryImpl
@Inject constructor(private var dao: UsersDao) :
    UsersRemoteRepository {

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
        _error.postValue(null)
        _errorInfoId.postValue(null)
        _errorText.postValue(null)

        try {
            dao.deleteAll()
            UsersApis.retrofitGithubApiService.getUsers().map {
                it.asDbModel()
            }.let {
                dao.insert(it)
            }
            UsersApis.retrofitDailymotionApiService
                .getUsers()
                .asDbModel()
                .let {
                    dao.insert(it)
                }

        } catch (e: Exception) {
            _errorInfoId.postValue(R.string.error_connecting_data_source_on_internet)
            _errorText.postValue(e.localizedMessage ?: "")
            _error.postValue(true)
        }
    }
}