package com.rjornelas.shopping_list.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.rjornelas.shopping_list.R
import com.rjornelas.shopping_list.viewModel.ItemsViewModel
import com.rjornelas.shopping_list.viewModel.ItemsViewModelFactory

class MainActivity : AppCompatActivity() {

    private val	viewModel: ItemsViewModel by viewModels	{
        ItemsViewModelFactory(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val	recyclerView = findViewById<RecyclerView>(R.id.rvItems);
        val	itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val	button = findViewById<Button>(R.id.btnRegister)
        val	edNewItem = findViewById<EditText>(R.id.edNewItem)


        button.setOnClickListener	{
            val edNewItemText = edNewItem.text

            if (validateEmptyValue(edNewItem)) return@setOnClickListener

            viewModel.addItem(edNewItemText.toString())

            edNewItemText.clear()
        }

        viewModel.itemsLiveData.observe(this)	{ items ->
            itemsAdapter.updateItems(items)
        }
    }

    private fun validateEmptyValue(edNewItem: EditText): Boolean {
        if (edNewItem.text.isEmpty()) {
            edNewItem.error = "The item name must not be empty"
            return true
        }
        return false
    }
}