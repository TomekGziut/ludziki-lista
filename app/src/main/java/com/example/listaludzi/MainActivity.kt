package com.example.listaludzi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imieInput: EditText = findViewById(R.id.inp_imie)
        val nazwiskoInput: EditText = findViewById(R.id.inp_nazwisko)
        val wiekInput: EditText = findViewById(R.id.inp_wiek)
        val wzrostInput: EditText = findViewById(R.id.inp_wzrost)
        val wagaInput: EditText = findViewById(R.id.inp_waga)

        val zapiszButton: Button = findViewById(R.id.btn_zapisz)
        val ekran2Button: Button = findViewById(R.id.btn_ekran_2)

        val sharedPreference =  getSharedPreferences("ListaLudzi",MODE_PRIVATE)
        val editor = sharedPreference.edit()

        zapiszButton.setOnClickListener {
            val imie = imieInput.text.toString()
            val nazwisko = nazwiskoInput.text.toString()
            val wiek = wiekInput.text.toString().toIntOrNull()
            val wzrost = wzrostInput.text.toString().toIntOrNull()
            val waga = wagaInput.text.toString().toIntOrNull()

            if (imie.isEmpty()) {
                Toast.makeText(applicationContext, "Imie nie może być puste", Toast.LENGTH_LONG).show()
            } else if (nazwisko.isEmpty()) {
                Toast.makeText(applicationContext, "Nazwisko nie może być puste", Toast.LENGTH_LONG).show()
            } else if (wiek == null || wiek <= 0 || wiek > 130) {
                Toast.makeText(applicationContext, "Wiek nie musi być w przedziale (0,130]", Toast.LENGTH_LONG).show()
            } else if (wzrost == null || wzrost !in 50..250) {
                Toast.makeText(applicationContext, "Wzrost musi być w przedziale [50, 250]", Toast.LENGTH_LONG).show()
            } else if (waga == null || waga !in 3..200) {
                Toast.makeText(applicationContext, "Wzrost musi być w przedziale [3, 200]", Toast.LENGTH_LONG).show()
            } else {
                editor.putString("imie", imie)
                editor.putString("nazwisko", nazwisko)
                editor.putInt("wiek", wiek)
                editor.putInt("wzrost", wzrost)
                editor.putInt("waga", waga)
                editor.apply()
            }
        }


        ekran2Button.setOnClickListener {
            val ekran2 = Intent(applicationContext, MainActivity2::class.java)
            startActivity(ekran2)
        }
    }
}
