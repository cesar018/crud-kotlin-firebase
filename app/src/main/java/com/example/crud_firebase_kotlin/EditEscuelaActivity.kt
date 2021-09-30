package com.example.crud_firebase_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.widget.Button
import android.widget.EditText
import com.example.crud_firebase_kotlin.model.Escuela
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class EditEscuelaActivity : AppCompatActivity() {
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_escuela)
        val edtButton = findViewById<Button>(R.id.btn_editar_esc)
        val nomEscuela = findViewById<EditText>(R.id.edt_nom_txt)
        val nomFacultad = findViewById<EditText>(R.id.edt_fac_txt)

        iniciarFirebase()

        edtButton.setOnClickListener {
            val nuevoNombre = nomEscuela.text.toString()
            val nuevaFac = nomFacultad.text.toString()
        }

    }
    fun iniciarFirebase(){
        FirebaseApp.initializeApp(this)
        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.getReference()
    }
}