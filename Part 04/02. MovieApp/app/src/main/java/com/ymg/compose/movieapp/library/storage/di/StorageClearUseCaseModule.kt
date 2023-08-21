package com.ymg.compose.movieapp.library.storage.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.ymg.compose.movieapp.library.storage.usecases.IStorageClearUseCase
import com.ymg.compose.movieapp.library.storage.usecases.StorageClearUseCase
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class StorageClearUseCaseModule {

    @Binds
    @Singleton
    abstract fun bindStorageClearUseCase(
        storageClearUserCase: StorageClearUseCase
    ): IStorageClearUseCase
}
