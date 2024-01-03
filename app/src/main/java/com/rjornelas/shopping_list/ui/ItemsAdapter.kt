package com.rjornelas.shopping_list.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rjornelas.shopping_list.R
import com.rjornelas.shopping_list.model.ItemModel

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHold>() {
    private var	items = listOf<ItemModel>()

    class ItemViewHold(view: View) : RecyclerView.ViewHolder(view) {
        private val	textView = view.findViewById<TextView>(R.id.tvItem)
        private val	btnRemove = view.findViewById<ImageButton>(R.id.btnRemove)

        fun	bind(item: ItemModel)	{
            textView.text = item.name
            btnRemove.setOnClickListener{
                item.onRemove(item)
            }
        }
    }

    fun	updateItems(newItems: List<ItemModel>)	{
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHold {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHold(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHold, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
}