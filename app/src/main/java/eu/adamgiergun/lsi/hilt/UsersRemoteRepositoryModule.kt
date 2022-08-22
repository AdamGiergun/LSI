package eu.adamgiergun.lsi.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eu.adamgiergun.lsi.users.data.remote.UsersRemoteRepository
import eu.adamgiergun.lsi.users.data.remote.UsersRemoteRepositoryImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class UsersRemoteRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUsersRemoteRepository(usersRemoteRepositoryImpl: UsersRemoteRepositoryImpl): UsersRemoteRepository
}