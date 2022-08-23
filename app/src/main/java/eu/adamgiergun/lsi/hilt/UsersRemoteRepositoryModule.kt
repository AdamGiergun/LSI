package eu.adamgiergun.lsi.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import eu.adamgiergun.lsi.users.data.remote.UsersRemoteRepository
import eu.adamgiergun.lsi.users.data.remote.UsersRemoteRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class UsersRemoteRepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindUsersRemoteRepository(usersRemoteRepositoryImpl: UsersRemoteRepositoryImpl): UsersRemoteRepository
}