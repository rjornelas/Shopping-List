package com.rjornelas.shopping_list.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ItemEntity::class], version =	1)
abstract class ItemsDatabase : RoomDatabase(){
    abstract fun itemsDao(): ItemsDao
}