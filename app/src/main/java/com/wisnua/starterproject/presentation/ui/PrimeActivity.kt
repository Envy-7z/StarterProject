package com.wisnua.starterproject.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.wisnua.starterproject.R
import com.wisnua.starterproject.databinding.ActivityPrimeBinding

class PrimeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPrimeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrimeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            btnGenerate.setOnClickListener {
                val numberStr = etNumber.text.toString().trim()
                if (numberStr.isNotEmpty()) {
                    val number = numberStr.toInt()
                    val isPrime = isPrimeNumber(number)
                    val resultMessage = if (isPrime) {
                        "Angka $number adalah bilangan prima."
                    } else {
                        "Angka $number bukan bilangan prima."
                    }
                    showToast(resultMessage)
                } else {
                    showToast("Mohon masukkan angka yang valid.")
                }
            }
        }
    }

    private fun isPrimeNumber(num: Int): Boolean {
        if (num <= 1) {
            return false
        }
        for (i in 2 until num) {
            if (num % i == 0) {
                return false
            }
        }
        return true
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}