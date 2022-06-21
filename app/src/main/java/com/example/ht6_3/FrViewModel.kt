package com.example.ht6_3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.random.Random

class FrViewModel: ViewModel() {
    val numbers = MutableStateFlow<Int>(1)
    val secondsPassed = MutableStateFlow<Int>(0)
    var i = 0
    var isRunning: Boolean = true
    fun start(){
        viewModelScope.launch(Dispatchers.IO){
            while(isActive)
                if(isRunning) {
                    numbers.value = Random.nextInt(1, 9)
                    delay(50)
                }
        }

        viewModelScope.launch(Dispatchers.IO){
            while (isActive)
                if (isRunning){
                    delay(10)
                    i += 1
                    secondsPassed.value = i
                }
        }
    }
    fun reset(){
        numbers.value = -1
        secondsPassed.value = 0
        i = 0
    }
    fun pause(){
        isRunning = false
    }
    fun run(){
        isRunning = true
    }
}