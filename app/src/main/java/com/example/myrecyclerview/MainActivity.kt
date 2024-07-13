package com.example.myrecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Actividad principal que muestra una lista de elementos en un RecyclerView.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtiene una referencia al RecyclerView desde el diseño
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // Establece el LinearLayoutManager para el RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        val listContact = mutableListOf<ContactModel>()
        listContact.add(ContactModel("Juan", 123456789))
        listContact.add(ContactModel("Pedro", 987654321))
        listContact.add(ContactModel("Maria", 123456789))
        listContact.add(ContactModel("Jose", 987654321))
        listContact.add(ContactModel("Ana", 123456789))

        // Lista de elementos a mostrar en el RecyclerView
        // val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

        // Crea una instancia del adaptador con la lista de elementos
        val adapter = ItemAdapter(listContact)

        // Asigna el adaptador al RecyclerView
        recyclerView.adapter = adapter

    }
}