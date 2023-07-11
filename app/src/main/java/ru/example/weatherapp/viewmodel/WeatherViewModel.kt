package ru.example.weatherapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.example.weatherapp.model.Weather
import ru.example.weatherapp.repository.WeatherRepository
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel
@Inject
constructor(private val repository: WeatherRepository):ViewModel(){

   private val _weatherResponse = MutableLiveData<Weather>()
    val weatherResponse: LiveData<Weather> = _weatherResponse

    init {
        getWeather()
    }

    private fun getWeather() = viewModelScope.launch {
        repository.getWeather().let {
            response ->
            if (response.isSuccessful){
                _weatherResponse.postValue(response.body())
            }else{
                Log.d("Tag", "Error response: ${response.message()}")
            }
        }
    }
}