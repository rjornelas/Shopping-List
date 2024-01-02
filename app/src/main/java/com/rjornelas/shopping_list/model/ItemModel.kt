package com.rjornelas.shopping_list.model

data class ItemModel(
    val name: String,
    val	onRemove: (ItemModel) -> Unit
)