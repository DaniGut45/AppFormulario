package com.example.appformulario

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.listView)

        // Crea un array con los elementos
        val items = arrayOf("DAW", "DAM", "ASIR")

        // Crea un ArrayAdapter y asócialo al ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        listView.adapter = adapter

        // Configura el listener para la selección de elementos
        listView.setOnItemClickListener { _, _, position, _ ->
            val cicloSeleccionado = items[position]

            val nombre: EditText = findViewById(R.id.editTextNombre)
            val apellido1: EditText = findViewById(R.id.editTextApellido1)
            val apellido2: EditText = findViewById(R.id.editTextApellido2)

            val textView = findViewById<TextView>(R.id.textViewSalida)
            val botonEnviar = findViewById<Button>(R.id.botonEnviar)
            val botonLimpiar = findViewById<Button>(R.id.botonLimpiar)
            botonLimpiar.setOnClickListener {
                nombre.setText("")
                apellido1.setText("")
                apellido2.setText("")
            }

            botonEnviar.setOnClickListener {
                val nombreTexto = nombre.text.toString()
                val apellido1Texto = apellido1.text.toString()
                val apellido2Texto = apellido2.text.toString()

                textView.text =
                    ("$nombreTexto $apellido1Texto $apellido2Texto ha solicitado la matricula de $cicloSeleccionado")
            }

        }
    }
}
