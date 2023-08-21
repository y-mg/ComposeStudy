package com.ymg.compose.movieapp.library.storage.usecases

import com.ymg.compose.movieapp.library.storage.IStorage
import javax.inject.Inject


class StorageClearUseCase @Inject constructor(
    private val storage: IStorage
) : IStorageClearUseCase {
    override fun invoke() {
        storage.clear()
    }
}
