package eu.adamgiergun.lsi.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import eu.adamgiergun.lsi.users.data.local.UsersLocalRepository
import eu.adamgiergun.lsi.users.data.local.UsersLocalRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class UsersLocalRepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindUsersLocalRepository(usersLocalRepositoryImpl: UsersLocalRepositoryImpl): UsersLocalRepository
}