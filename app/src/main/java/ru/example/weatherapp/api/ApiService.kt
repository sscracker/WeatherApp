package ru.example.weatherapp.api

import retrofit2.Response
import retrofit2.http.GET
import ru.example.weatherapp.model.Weather


interface ApiService {
    @GET("weather/Samara")
    suspend fun getWeather(): Response<Weather>

}
