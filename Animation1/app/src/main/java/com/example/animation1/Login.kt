package com.example.animation1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    private var uname: EditText? = null
    private var epwd: EditText? = null
    private var btnlgn: Button? = null
    private var btn_reset: Button? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize UI elements
        uname = findViewById(R.id.et1)
        epwd = findViewById(R.id.et2)
        btnlgn = findViewById(R.id.buttonLogin)
        btn_reset = findViewById(R.id.btn_rst)

        // Reset button clears fields
        btn_reset?.setOnClickListener {
            uname?.setText("")
            epwd?.setText("")
        }

        // ✅ Login button action
        btnlgn?.setOnClickListener(View.OnClickListener {
            val username = uname?.text.toString()
            val password = epwd?.text.toString()

            if (username == "Admin" && password == "123") {
                Toast.makeText(this@Login, "Login successful", Toast.LENGTH_SHORT).show()

                // Redirect to Dashboard
                val intent = Intent(this@Login, Dashboard::class.java)
                startActivity(intent)
                finish() // close login so user can’t go back
            } else {
                Toast.makeText(this@Login, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
