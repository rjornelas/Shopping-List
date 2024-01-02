package com.rjornelas.shopping_list.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemsViewModel(
    private var items: MutableList<ItemModel> = mutableListOf(),

) : ViewModel() {

    fun	addItem(name: String) {
        val	item = ItemModel(name =	name, onRemove = ::removeItem)
        items.add(item)
        itemsLiveData.value	= items
    }

    private fun	removeItem(item: ItemModel)	{
        items.remove(item)
        itemsLiveData.value	= items
    }

    val	itemsLiveData = MutableLiveData<List<ItemModel>>()

}