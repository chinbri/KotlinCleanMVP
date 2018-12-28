package com.example.chin.shoppinglist.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.chin.domain.entities.ShoppingItem
import com.example.chin.shoppinglist.R

class ShoppingListAdapter(var shoppingItems: List<ShoppingItem> = emptyList()): RecyclerView.Adapter<ShoppingItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, index: Int): ShoppingItemViewHolder {
        return ShoppingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun getItemCount() = shoppingItems.size

    override fun onBindViewHolder(viewHolder: ShoppingItemViewHolder, position: Int) {
        viewHolder.bind(shoppingItems[position])
    }
}

class ShoppingItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    fun bind(shoppingItem: ShoppingItem){

        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvQuantity = itemView.findViewById<TextView>(R.id.tvQuantity)

        tvName.text = shoppingItem.name
        tvQuantity.text = shoppingItem.quantity.toString()

    }

}