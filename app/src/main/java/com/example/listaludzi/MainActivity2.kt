package com.example.listaludzi

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Odczytanie danych z SharedPreferences
        val sharedPreferences = getSharedPreferences("ListaLudzi", MODE_PRIVATE)
        val imie = sharedPreferences.getString("imie", "Brak danych")
        val nazwisko = sharedPreferences.getString("nazwisko", "Brak danych")
        val wiek = sharedPreferences.getInt("wiek", -1)
        val wzrost = sharedPreferences.getInt("wzrost", -1)
        val waga = sharedPreferences.getInt("waga", -1)

        // Powiązanie TextView do wyświetlania danych
        val imieTextView: TextView = findViewById(R.id.textViewImie)
        val nazwiskoTextView: TextView = findViewById(R.id.textViewNazwisko)
        val wiekTextView: TextView = findViewById(R.id.textViewWiek)
        val wzrostTextView: TextView = findViewById(R.id.textViewWzrost)
        val wagaTextView: TextView = findViewById(R.id.textViewWaga)

        // Ustawienie tekstu w TextView
        imieTextView.text = "Imię: $imie"
        nazwiskoTextView.text = "Nazwisko: $nazwisko"
        wiekTextView.text = "Wiek: ${if (wiek != -1) wiek else "Brak danych"}"
        wzrostTextView.text = "Wzrost: ${if (wzrost != -1) wzrost else "Brak danych"}"
        wagaTextView.text = "Waga: ${if (waga != -1) waga else "Brak danych"}"
    }
}
