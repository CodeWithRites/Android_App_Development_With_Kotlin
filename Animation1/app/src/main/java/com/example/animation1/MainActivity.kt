package com.example.animation1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // your splash/animation layout

        // Redirect to Login after 3 seconds (3000 ms)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@MainActivity, Login::class.java)
            startActivity(intent)
            finish() // close splash so user can’t go back
        }, 3000)
    }
}
