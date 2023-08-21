package com.ymg.compose.restaurantapp.libraries.storage.usecases

import com.ymg.compose.restaurantapp.libraries.storage_contract.IStorage
import javax.inject.Inject

class StorageClearUseCase @Inject constructor(
    private val storage: IStorage
) : IStorageClearUseCase {
    override fun invoke() {
        storage.clear()
    }
}
