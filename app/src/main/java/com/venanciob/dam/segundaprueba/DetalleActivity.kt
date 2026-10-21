package com.venanciob.dam.segundaprueba

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.venanciob.dam.segundaprueba.databinding.ActivityDetalleBinding


class DetalleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnDetalle2.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart2")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume2")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause2")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop2")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart2")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy2 (isFinishing = $isFinishing)")

    }
}