package com.example.myrecyclerview

import java.io.Serializable

data class CarroModel(
    val marca: String,
    val placa: String,
    val color: String,
    val tipoCombustible: String
): Serializable
