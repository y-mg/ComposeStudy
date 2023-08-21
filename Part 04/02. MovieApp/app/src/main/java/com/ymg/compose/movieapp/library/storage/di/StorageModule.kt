package com.ymg.compose.movieapp.library.storage.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.ymg.compose.movieapp.library.storage.IStorage
import com.ymg.compose.movieapp.library.storage.StorageManager
import com.ymg.compose.movieapp.library.storage.helpers.DataConverter
import com.ymg.compose.movieapp.library.storage.helpers.DataEncoding
import com.ymg.compose.movieapp.library.storage.prefs.SharedPrefsStorageProvider
import com.ymg.compose.movieapp.library.storage.prefs.StorageProvider
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class StorageModule {

    @Singleton
    @Provides
    fun bindOnDiscStorage(
        storage: StorageProvider,
        converter: DataConverter,
        encoding: DataEncoding
    ): IStorage = StorageManager(storage, converter, encoding)

    @Provides
    fun provideSharePrefStorageProvider(provider: SharedPrefsStorageProvider): StorageProvider =
        provider

}
