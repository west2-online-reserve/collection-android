package com.example.work5

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.work5.databinding.ActivityMainBinding
import dataclass.ChartData
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button2.setOnClickListener {
            binding.customView.setData(ChartData(listOf(listOf(4f, 1f, 2f,3f), listOf(2f, 3f, 4f,5f))))
        }

        binding.button3.setOnClickListener {
            binding.customView.setData(ChartData(listOf(listOf(4f, 1f), listOf(2f, 3f))))
        }
        binding.button4.setOnClickListener {
            binding.customView.setData(ChartData(listOf(listOf(4f, 1f, 2f,3f,9f), listOf(2f, 1f, 9f,5f,20f))))
        }
        binding.button5.setOnClickListener {
            binding.customView.setData(ChartData(listOf(listOf(1f, 2f), listOf(5f, 15f))))
        }
        binding.button6.setOnClickListener {
            binding.customView.setData(ChartData(listOf(listOf(1f, 2f, 3f,4f), listOf(1f, 1f, 1f, 1f))))
        }

        binding.button.setOnClickListener {
            val intent = Intent(this@MainActivity, MyActivity::class.java)
            startActivity(intent)
        }
    }
}