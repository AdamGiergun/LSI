package eu.adamgiergun.lsi.users.data.local

class UsersLocalRepositoryImpl(
    private val usersDao: UsersDao,
): UsersLocalRepository {

    override fun getUsers() = usersDao.getUsers()
}