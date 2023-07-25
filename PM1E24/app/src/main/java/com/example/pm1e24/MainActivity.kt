package com.example.pm1e24

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.pm1e24.modelos.ListaFirmasActivity


class MainActivity : AppCompatActivity() {
    var btnNuevaFirma: Button? = null
    var btnListaFirma: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setListeners()
    }

    fun init() {
        btnNuevaFirma = findViewById<Button>(R.id.btnNuevaFirma)
        btnListaFirma = findViewById<Button>(R.id.btnListaFirmas)
    }

    fun setListeners() {
        btnNuevaFirma!!.setOnClickListener { view: View? ->
            val intent = Intent(
                applicationContext,
                NuevaFirmaActivity::class.java
            )
            startActivity(intent)
        }
        btnListaFirma!!.setOnClickListener { v: View? ->
            val intent = Intent(
                applicationContext,
                ListaFirmasActivity::class.java
            )
            startActivity(intent)
        }
    }
}
