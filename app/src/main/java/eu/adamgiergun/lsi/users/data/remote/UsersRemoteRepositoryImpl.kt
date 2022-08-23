package eu.adamgiergun.lsi.users.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import eu.adamgiergun.lsi.R
import eu.adamgiergun.lsi.network.apiservices.DailymotionApiService
import eu.adamgiergun.lsi.network.apiservices.GithubApiService
import eu.adamgiergun.lsi.network.dto.DailyMotionUsersPagesDTO
import eu.adamgiergun.lsi.network.dto.GithubUserDTO
import eu.adamgiergun.lsi.users.data.local.db.UserDB
import eu.adamgiergun.lsi.users.data.local.db.UsersDao
import javax.inject.Inject

class UsersRemoteRepositoryImpl
@Inject constructor(private var dao: UsersDao) :
    UsersRemoteRepository {

    @Inject
    lateinit var dailymotionApiService: DailymotionApiService

    @Inject
    lateinit var githubApiService: GithubApiService

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

            githubApiService.getUsers()
                .map {
                    it.asDbModel()
                }.let {
                    dao.insert(it)
                }

            dailymotionApiService.getUsers()
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

private fun DailyMotionUsersPagesDTO.asDbModel() =
    list.map { userDTO ->
        UserDB(
            userDTO.id,
            userDTO.screenName,
            "",
            "Dailymotion"
        )
    }

private fun GithubUserDTO.asDbModel() =
    UserDB(
        id.toString(),
        userName,
        avatarUrl,
        "GitHub"
    )