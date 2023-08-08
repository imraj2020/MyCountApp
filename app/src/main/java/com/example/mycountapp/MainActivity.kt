package com.example.mycountapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.mycountapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val  viewModel : MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.scoreData.observe(this){
            setValue(it)
        }

        binding.inecrementBtn.setOnClickListener {
            viewModel.increment()
        }
        binding.decrementBtn.setOnClickListener {
            viewModel.decrement()
        }

        binding.resetBtn.setOnClickListener {
            viewModel.reset()
        }
    }

    private fun setValue(score: Int) {

        binding.scoreTv.text = "$score"
    }
}