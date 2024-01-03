package com.rjornelas.shopping_list.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rjornelas.shopping_list.data.ItemEntity
import com.rjornelas.shopping_list.data.ItemsDatabase
import com.rjornelas.shopping_list.data.toModel
import com.rjornelas.shopping_list.model.ItemModel
import com.rjornelas.shopping_list.model.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemsViewModel(
    private val	database: ItemsDatabase
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            fetchAll()
        }
    }

    val itemsLiveData = MutableLiveData<List<ItemModel>>()

    fun addItem (name: String){
        viewModelScope.launch(Dispatchers.IO) {
            val	entity = ItemEntity(id = 0,	name = name)
            database.itemsDao().insert(entity)
            fetchAll()
        }
    }

    private fun removeItem (item: ItemModel){
        viewModelScope.launch(Dispatchers.IO) {
            val	entity = item.toEntity()
            database.itemsDao().delete(entity)
            fetchAll()
        }
    }

    private suspend fun	fetchAll()	{
        val	result = database.itemsDao().getAll().map {
            it.toModel(onRemove	= ::removeItem)
        }
        itemsLiveData.postValue(result)
    }


}