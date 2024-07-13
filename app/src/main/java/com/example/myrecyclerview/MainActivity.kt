package com.example.myrecyclerview

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Actividad principal que muestra una lista de elementos en un RecyclerView.
 */
class MainActivity : AppCompatActivity() {
    private var carrosList = mutableListOf<CarroModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val etMarca = findViewById<EditText>(R.id.etMarca)
        val etPlaca = findViewById<EditText>(R.id.etPlaca)
        val etColor = findViewById<EditText>(R.id.etColor)
        val spinnerTipoCombustible = findViewById<Spinner>(R.id.spinnerTipoCombustible)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        // Crear una lista de opciones para el spinner
        val tiposCombustible = arrayOf("Gasolina", "Diesel", "Eléctrico", "Híbrido")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tiposCombustible)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTipoCombustible.adapter = adapter

        btnGuardar.setOnClickListener {
            val marca = etMarca.text.toString()
            val placa = etPlaca.text.toString()
            val color = etColor.text.toString()
            val tipoCombustible = spinnerTipoCombustible.selectedItem.toString()

            if (marca.isNotBlank() && placa.isNotBlank() && color.isNotBlank() && tipoCombustible.isNotBlank()) {

                carrosList = getCarrosFromPreferences().toMutableList()

                val nuevoCarro = CarroModel(marca, placa, color, tipoCombustible)
                carrosList.add(nuevoCarro)

                saveCarrosToPreferences(carrosList)

                // Crea el Intent para iniciar ListCardActivity
                val intent = Intent(this, ListCardActivity::class.java)
                startActivity(intent)

                Toast.makeText(this, "Datos registrados", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Por favor, llene todos los campos", Toast.LENGTH_LONG).show()
            }

        }

    }

    private fun saveCarrosToPreferences(carros: List<CarroModel>) {
        val sharedPreferences = getSharedPreferences("CarroPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val carrosJson = gson.toJson(carros)
        editor.putString("carrosList", carrosJson)
        editor.apply()
    }

    private fun getCarrosFromPreferences(): List<CarroModel> {
        val sharedPreferences = getSharedPreferences("CarroPrefs", Context.MODE_PRIVATE)
        val gson = Gson()
        val carrosJson = sharedPreferences.getString("carrosList", null)
        if (carrosJson == null) {
            return emptyList()
        }
        val type = object : TypeToken<List<CarroModel>>() {}.type
        return gson.fromJson(carrosJson, type)
    }



}