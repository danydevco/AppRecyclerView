package com.example.myrecyclerview

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_card)

        val carro = intent.getStringExtra("carro")
        Log.d("TAG", "onCreate: $carro")

        // Obtiene una referencia al RecyclerView desde el diseño
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // Establece el LinearLayoutManager para el RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        val listContact = mutableListOf<CarroModel>()

        // Lista de elementos a mostrar en el RecyclerView
        // val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

        // Crea una instancia del adaptador con la lista de elementos
        val listCars = getCarrosFromPreferences().toMutableList()
        val adapter = ItemAdapter(listCars)

        // Asigna el adaptador al RecyclerView
        recyclerView.adapter = adapter
    }

    private fun getCarrosFromPreferences(): List<CarroModel> {
        val sharedPreferences = getSharedPreferences("CarroPrefs", Context.MODE_PRIVATE)
        val gson = Gson()
        val carrosJson = sharedPreferences.getString("carrosList", null)
        val type = object : TypeToken<List<CarroModel>>() {}.type
        return gson.fromJson(carrosJson, type)
    }


}