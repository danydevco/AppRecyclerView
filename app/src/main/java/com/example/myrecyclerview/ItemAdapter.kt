package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Adaptador para mostrar una lista de cadenas en un RecyclerView.
 *
 * @param items La lista de cadenas a mostrar.
 */
class ItemAdapter(private val items: List<CarroModel>) : RecyclerView.Adapter<ItemViewHolder>() {

    /**
     * Se llama cuando el RecyclerView necesita un nuevo ViewHolder del tipo dado para representar un elemento.
     * Este es el momento en que el ViewHolder debe ser inflado.
     *
     * @param parent El ViewGroup en el que se agregará la nueva vista después de ser vinculada a una posición del adaptador.
     * @param viewType El tipo de vista del nuevo View.
     * @return Un nuevo ViewHolder que contiene una vista del tipo dado.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // Inflar el diseño del elemento y crear una nueva instancia de ViewHolder.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item_layout, parent, false)
        return ItemViewHolder(view)
    }

    /**
     * Llamado por RecyclerView para mostrar los datos en la posición especificada.
     * Este método debe actualizar el contenido del itemView del ViewHolder para reflejar el elemento en la posición dada.
     *
     * @param holder El ViewHolder que debe actualizarse para representar el contenido del elemento en la posición dada en el conjunto de datos.
     * @param position La posición del elemento dentro del conjunto de datos del adaptador.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // Vincular los datos al ViewHolder.
        val item = items[position]

        holder.tvMarca.text = item.marca
        holder.tvPlaca.text = item.placa
        holder.tvColor.text = item.color
        holder.tvTipoCombustible.text = item.tipoCombustible


    }

    /**
     * Devuelve el número total de elementos en el conjunto de datos mantenido por el adaptador.
     *
     * @return El número total de elementos en este adaptador.
     */
    override fun getItemCount(): Int {
        return items.size
    }
}