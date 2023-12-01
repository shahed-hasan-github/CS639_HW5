package com.shop.hw5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FetchInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch_info)


        // Make a network request
        val call: Call<User> = RetrofitInstance.api.getUser()
        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val user: User? = response.body()
                    // Update your UI with the user data
                    updateUI(user)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                // Handle network request failure
            }
        })
    }

    private fun updateUI(user: User?) {
        if (user != null) {
            findViewById<TextView>(R.id.textViewId).text = "User ID: ${user.id}"
            findViewById<TextView>(R.id.textViewName).text = "User Name: ${user.name}"
            findViewById<TextView>(R.id.textViewEmail).text = "User Email: ${user.email}"
        }
    }
    }
