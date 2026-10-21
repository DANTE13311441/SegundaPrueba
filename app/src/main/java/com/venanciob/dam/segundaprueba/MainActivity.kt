package com.venanciob.dam.segundaprueba

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.venanciob.dam.segundaprueba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Clase generada por View Binding a partir de activity_main.xml
    private val CLAVE_CONTADOR = "contador"
    private lateinit var binding: ActivityMainBinding

    // Estado de la pantalla: el valor actual del contador
    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate (savedInstanceState es ${if (savedInstanceState == null) "null" else "no null"})")
        enableEdgeToEdge()



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        contador = savedInstanceState?.getInt(CLAVE_CONTADOR) ?: 0
        // Mostrar el valor inicial
        mostrarContador()

        // Eventos: qué hacer cuando se pulsa cada botón
        binding.btnSumar.setOnClickListener {
            contador++
            mostrarContador()
        }

        binding.btnRestar.setOnClickListener {
            if (contador > 0)
                contador--
            mostrarContador()
        }
        binding.btnDetalle.setOnClickListener {
            startActivity(Intent(this, DetalleActivity::class.java))
        }
        binding.btnReiniciar.setOnClickListener {
            contador = 0
            mostrarContador()
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
        contador++
        mostrarContador()
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
        contador++
        mostrarContador()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
        contador++
        mostrarContador()
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
        contador++
        mostrarContador()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
        contador++
        mostrarContador()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy (isFinishing = $isFinishing)")
        contador++
        mostrarContador()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)   // guarda el estado de las vistas (EditText…)
        outState.putInt(CLAVE_CONTADOR, contador)
    }
    private fun mostrarContador() {
        binding.tvContador.text = contador.toString()
        if (contador>=10)
            binding.tvContador.setTextColor(getColor(R.color.red))
        else
            binding.tvContador.setTextColor(getColor(R.color.black))
    }


}