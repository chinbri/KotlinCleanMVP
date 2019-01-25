package com.example.chin.shoppinglist.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chin.domain.entities.ShoppingItem
import com.example.chin.shoppinglist.R

class ShoppingListAdapter(
    var shoppingItems: List<ShoppingItem> = emptyList(),
    private val listener: (ShoppingItem) -> Unit,
    private val deleteListener: (ShoppingItem) -> Unit
    ): RecyclerView.Adapter<ShoppingItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, index: Int): ShoppingItemViewHolder {
        return ShoppingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun getItemCount() = shoppingItems.size

    override fun onBindViewHolder(viewHolder: ShoppingItemViewHolder, position: Int) {
        viewHolder.bind(shoppingItems[position], listener, deleteListener)
    }
}

class ShoppingItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    fun bind(
        shoppingItem: ShoppingItem,
        listener: (ShoppingItem) -> Unit,
        deleteListener: (ShoppingItem) -> Unit
    ){

        itemView.setOnClickListener{
            listener.invoke(shoppingItem)
        }

        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvQuantity = itemView.findViewById<TextView>(R.id.tvQuantity)
        val ivDelete = itemView.findViewById<ImageView>(R.id.ivDelete)

        tvName.text = shoppingItem.name
        tvQuantity.text = shoppingItem.quantity.toString()
        ivDelete.setOnClickListener {
            deleteListener.invoke(shoppingItem)
        }

    }

}