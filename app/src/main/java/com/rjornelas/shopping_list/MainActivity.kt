package com.rjornelas.shopping_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.rjornelas.shopping_list.model.ItemModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val	recyclerView = findViewById<RecyclerView>(R.id.rvItems);
        val	itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val	button = findViewById<Button>(R.id.btnRegister)
        val	editText = findViewById<EditText>(R.id.edNewItem)

        button.setOnClickListener	{
            val item = ItemModel(editText.text.toString())
            itemsAdapter.addItem(item)
        }
    }
}