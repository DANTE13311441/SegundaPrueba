package com.venanciob.dam.segundaprueba

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.venanciob.dam.segundaprueba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Clase generada por View Binding a partir de activity_main.xml
    private lateinit var binding: ActivityMainBinding

    // Estado de la pantalla: el valor actual del contador
    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Mostrar el valor inicial
        mostrarContador()

        // Eventos: qué hacer cuando se pulsa cada botón
        binding.btnSumar.setOnClickListener {
            contador++
            mostrarContador()
        }

        binding.btnReiniciar.setOnClickListener {
            contador = 0
            mostrarContador()
        }
    }
    private fun mostrarContador() {
        binding.tvContador.text = contador.toString()
    }


}