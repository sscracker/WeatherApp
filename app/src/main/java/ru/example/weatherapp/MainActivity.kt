package ru.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.example.weatherapp.databinding.ActivityMainBinding
import ru.example.weatherapp.viewmodel.WeatherViewModel


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.weatherResponse.observe(this) { weather ->
            binding.apply {
                tvCity.text = "Samara"
                tvTemperature.text = weather.temperature
                tvDescription.text = weather.description
                tvWind.text = weather.wind

                val forecast1 = weather.forecast[0]
                tvForecast1.text = "${forecast1.temperature} / ${forecast1.wind}"
            }
        }
    }
}