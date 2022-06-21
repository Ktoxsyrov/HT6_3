package com.example.ht6_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ht6_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container1, FragmentOne.newInstance())
            .commit()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container2, FragmentTwo.newInstance())
            .commit()

    }
    //Flow - поток.
    //в корутинах может возвращать несколько значений сразу, в отличие от suspend fun
    //можно обрабатывать асинхронно
    //3 объекта: производитель, посредник и получатель
}