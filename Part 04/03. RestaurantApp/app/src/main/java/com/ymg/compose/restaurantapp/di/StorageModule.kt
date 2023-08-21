package com.ymg.compose.restaurantapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.ymg.compose.restaurantapp.libraries.storage.StorageManager
import com.ymg.compose.restaurantapp.libraries.storage.helpers.DataConverter
import com.ymg.compose.restaurantapp.libraries.storage.helpers.DataEncoding
import com.ymg.compose.restaurantapp.libraries.storage.prefs.SharedPrefsStorageProvider
import com.ymg.compose.restaurantapp.libraries.storage.prefs.StorageProvider
import com.ymg.compose.restaurantapp.libraries.storage_contract.IStorage
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
