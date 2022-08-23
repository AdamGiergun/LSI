package eu.adamgiergun.lsi.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import eu.adamgiergun.lsi.network.apiservices.DailymotionApiService
import eu.adamgiergun.lsi.network.apiservices.GithubApiService
import eu.adamgiergun.lsi.network.apiservices.UsersApis

@Module
@InstallIn(ViewModelComponent::class)
object ApisModule {

    @Provides
    fun providesDailymotionApiService(): DailymotionApiService = UsersApis.retrofitDailymotionApiService

    @Provides
    fun provideGithubApiService(): GithubApiService = UsersApis.retrofitGithubApiService
}