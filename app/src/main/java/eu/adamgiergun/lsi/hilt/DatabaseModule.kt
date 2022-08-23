package eu.adamgiergun.lsi.hilt

import android.content.Context
import androidx.room.Room
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
class DatabaseModule {

    @Provides
    @ViewModelScoped
    fun provideLocalDB(@ApplicationContext appContext: Context): LocalDB =
        Room.databaseBuilder(
            appContext,
            LocalDB::class.java,
            "local.db"
        ).build()

    @Provides
    @ViewModelScoped
    fun provideDao(localDB: LocalDB): UsersDao {
        return localDB.usersDao()
    }
}