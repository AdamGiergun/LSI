package eu.adamgiergun.lsi.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eu.adamgiergun.lsi.users.data.local.UsersLocalRepository
import eu.adamgiergun.lsi.users.data.local.UsersLocalRepositoryImpl

@InstallIn(SingletonComponent::class)
@Module
abstract class UsersLocalRepositoryModule {

    @Binds
    abstract fun bindUsersLocalRepository(usersLocalRepositoryImpl: UsersLocalRepositoryImpl): UsersLocalRepository
}