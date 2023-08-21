package com.ymg.compose.restaurantapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import com.ymg.compose.restaurantapp.libraries.storage_contract.IStorage
import com.ymg.compose.restaurantapp.libraries.storage_contract.constants.StorageKeys
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var storage: IStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        saveAppTheme()
    }

    private fun saveAppTheme() {
        storage.save(
            StorageKeys.APP_THEME,
            BuildConfig.FLAVOR
        )
    }
}
