package com.rjornelas.shopping_list.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.rjornelas.shopping_list.data.ItemsDatabase

class ItemsViewModelFactory(
    private val	applicationContext: Context
): ViewModelProvider.Factory {

    private fun	createDatabase(): ItemsDatabase {
        return	Room.databaseBuilder(
            applicationContext,
            ItemsDatabase::class.java, "items_database.db"
        ).build()
    }

    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return ItemsViewModel(database = createDatabase()) as T
    }


}