package com.example.restapitp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val scope = CoroutineScope(Dispatchers.Main)
        scope.launch {
            try{
                val response = ApiClient.apiService.getOffers()
                if (response.isSuccessful && response.body() != null) {
                    println(response.body())
                }else{
                    println("Error 1")
                }
            } catch (e: Exception) {
                println("Error 2")
            }

        }
    }
}