package com.example.listaludzi

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val sharedPreferences = getSharedPreferences("ListaLudzi", MODE_PRIVATE)
        val imie = sharedPreferences.getString("imie", "Brak danych")
        val nazwisko = sharedPreferences.getString("nazwisko", "Brak danych")
        val wiek = sharedPreferences.getInt("wiek", -1)
        val wzrost = sharedPreferences.getInt("wzrost", -1)
        val waga = sharedPreferences.getInt("waga", -1)

        val imieTextView: TextView = findViewById(R.id.tv_imie)
        val nazwiskoTextView: TextView = findViewById(R.id.tv_nazwisko)
        val wiekTextView: TextView = findViewById(R.id.tv_wiek)
        val wzrostTextView: TextView = findViewById(R.id.tv_wzrost)
        val wagaTextView: TextView = findViewById(R.id.tv_waga)

        imieTextView.text = "Imię: $imie"
        nazwiskoTextView.text = "Nazwisko: $nazwisko"
        wiekTextView.text = "Wiek: ${if (wiek != -1) wiek else "Brak danych"}"
        wzrostTextView.text = "Wzrost: ${if (wzrost != -1) wzrost else "Brak danych"}"
        wagaTextView.text = "Waga: ${if (waga != -1) waga else "Brak danych"}"

    }
}