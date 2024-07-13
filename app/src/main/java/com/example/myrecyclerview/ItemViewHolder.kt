package com.example.myrecyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * un ViewHolder es una clase utilizada por el RecyclerView para almacenar referencias a las
 * vistas que representan los elementos de la lista.
 *
 * ViewHolder para un elemento en el RecyclerView.
 *
 * @param itemView La vista del elemento.
 */
class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    /**
     * TextView para mostrar el texto del elemento.
     */
    val textView: TextView = itemView.findViewById(R.id.textView)
    val tvTelf: TextView = itemView.findViewById(R.id.textViewTelf)
}