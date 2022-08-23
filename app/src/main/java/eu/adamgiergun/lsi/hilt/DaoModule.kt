package eu.adamgiergun.lsi.hilt

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import eu.adamgiergun.lsi.users.data.local.db.LocalDB
import eu.adamgiergun.lsi.users.data.local.db.UsersDao

@Module
@InstallIn(ViewModelComponent::class)
class DaoModule {

    @Provides
    @ViewModelScoped
    fun provideDao(@ApplicationContext appContext: Context): UsersDao {
        return LocalDB.getDatabase(appContext).usersDao()
    }
}