package eu.adamgiergun.lsi.hilt

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import eu.adamgiergun.lsi.users.data.local.db.LocalDB
import eu.adamgiergun.lsi.users.data.local.db.UsersDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DaoModule {

    @Provides
    @Singleton
    fun provideDao(@ApplicationContext appContext: Context): UsersDao {
        return LocalDB.getDatabase(appContext).usersDao()
    }
}