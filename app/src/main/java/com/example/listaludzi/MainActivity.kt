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

        val Input_Imie: EditText = findViewById(R.id.inp_imie)
        val Input_Nazwisko: EditText = findViewById(R.id.inp_nazwisko)
        val Input_Wiek: EditText = findViewById(R.id.inp_wiek)
        val Input_Wzrost: EditText = findViewById(R.id.inp_wzrost)
        val Input_Waga: EditText = findViewById(R.id.inp_waga)

        val Button_Zapisz: Button = findViewById(R.id.btn_zapisz)
        val Button_Ekran_2: Button = findViewById(R.id.btn_ekran_2)

        val sharedPreference =  getSharedPreferences("ListaLudzi",MODE_PRIVATE)
        var editor = sharedPreference.edit()

        Button_Zapisz.setOnClickListener {
            val imie = Input_Imie.text.toString()
            val nazwisko = Input_Nazwisko.text.toString()
            val wiek = Input_Wiek.text.toString().toIntOrNull()
            val wzrost = Input_Wzrost.text.toString().toIntOrNull()
            val waga = Input_Waga.text.toString().toIntOrNull()

            if (imie.isNullOrEmpty()) {
                Toast.makeText(applicationContext, "Imie nie może być puste", Toast.LENGTH_LONG).show()
            } else if (nazwisko.isNullOrEmpty()) {
                Toast.makeText(applicationContext, "Nazwisko nie może być puste", Toast.LENGTH_LONG).show()
            } else if (wiek == null || wiek <= 0 || wiek > 130) {
                Toast.makeText(applicationContext, "Wiek nie musi być w przedziale (0,130]", Toast.LENGTH_LONG).show()
            } else if (wzrost == null || !(wzrost in 50..250)) {
                Toast.makeText(applicationContext, "Wzrost musi być w przedziale [50, 250]", Toast.LENGTH_LONG).show()
            } else if (waga == null || !(waga in 3..200)) {
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





        Button_Ekran_2.setOnClickListener {
            val ekran2 = Intent(applicationContext, MainActivity2::class.java)
            startActivity(ekran2)
        }
    }
}
