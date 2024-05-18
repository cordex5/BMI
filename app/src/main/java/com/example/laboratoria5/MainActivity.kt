package com.example.laboratoria5

import android.R
import android.os.Bundle
import android.os.Handler
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.laboratoria5.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Toast.makeText(this, "Twoje BMI to:", Toast.LENGTH_LONG).show()
            Handler().postDelayed({ }, 10)
            // Przekształcamy tekst z EditText na double
            val wzrostText = binding.wzrost.text.toString()
            val wagaText = binding.waga.text.toString()

            // Sprawdzamy, czy pola są puste
            if (wzrostText.isEmpty() || wagaText.isEmpty()) {
                Toast.makeText(this, "Wszystkie pola są wymagane.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Próbujemy przekształcić tekst na double
            val wzrost = wzrostText.toDoubleOrNull()
            val waga = wagaText.toDoubleOrNull()

            // Sprawdzamy, czy przekształcenie się powiodło
            if (wzrost == null || waga == null) {
                Toast.makeText(this, "Podaj poprawne wartości.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // Przeliczamy wzrost z cm na m
            val wzrostM = wzrost / 100

            // Tutaj możemy wykonać obliczenia na wzroście i wadze
            // Na przykład, obliczenie BMI
            val bmi = waga / (wzrostM * wzrostM)



            // Wyświetlamy wynik
            Toast.makeText(this, String.format("%.2f", bmi), Toast.LENGTH_LONG).show()
            binding.wynik.text = String.format("%.2f", bmi)
        }

    }
}
fun obliczanie () {


}