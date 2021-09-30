package com.example.crud_firebase_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var escuelas = findViewById<Button>(R.id.op_esc)
        var docentes = findViewById<Button>(R.id.op_doc)
        escuelas.setOnClickListener {
            finish();
            startActivity(Intent( this, EscuelaListActivity::class.java))
        }
        docentes.setOnClickListener {
            finish();
            startActivity(Intent(this, DocenteListActivity::class.java))
        }
    }
}