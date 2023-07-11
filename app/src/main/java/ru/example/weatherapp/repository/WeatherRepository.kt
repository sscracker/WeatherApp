package ru.example.weatherapp.repository

import ru.example.weatherapp.api.ApiService
import javax.inject.Inject

class WeatherRepository
    @Inject
    constructor(private val apiService: ApiService){
        suspend fun getWeather() = apiService.getWeather()
    }
