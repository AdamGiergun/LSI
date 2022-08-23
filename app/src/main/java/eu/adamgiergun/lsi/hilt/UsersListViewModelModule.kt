package eu.adamgiergun.lsi.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import eu.adamgiergun.lsi.users.data.local.UsersLocalRepository
import eu.adamgiergun.lsi.users.data.remote.UsersRemoteRepository
import eu.adamgiergun.lsi.users.userslist.UsersListViewModel

@Module
@InstallIn(ViewModelComponent::class)
class UsersListViewModelModule {

    @Provides
    fun providesUsersListViewModel(
        usersRemoteRepository: UsersRemoteRepository,
        usersLocalRepository: UsersLocalRepository
    ): UsersListViewModel {
        return UsersListViewModel(usersRemoteRepository, usersLocalRepository)
    }
}