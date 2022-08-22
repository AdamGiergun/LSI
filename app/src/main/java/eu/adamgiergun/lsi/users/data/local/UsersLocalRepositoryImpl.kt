package eu.adamgiergun.lsi.users.data.local

import androidx.lifecycle.Transformations
import eu.adamgiergun.lsi.users.data.local.db.UsersDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsersLocalRepositoryImpl @Inject constructor(
    private val usersDao: UsersDao,
) : UsersLocalRepository {

    override fun getUsers() = Transformations.map(usersDao.getUsers()) { list ->
        list?.map { userDB ->
            userDB.run {
                User(id, name, avatarUrl, sourceApi)
            }
        }
    }
}