package com.example.crud_firebase_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.crud_firebase_kotlin.model.Escuela
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class AddEscuelaActivity : AppCompatActivity() {
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_escuela)

        val addButton = findViewById<Button>(R.id.button3)
        val nomEscuela = findViewById<EditText>(R.id.txtnom_esc)
        val nomFacultad = findViewById<EditText>(R.id.txt_facultad);

        iniciarFirebase()

        addButton.setOnClickListener {
           val vNomEscuela = nomEscuela.text.toString()
           val vNomFacultad = nomFacultad.text.toString()

           if(vNomEscuela == null || vNomEscuela == ""){
               nomEscuela.setError("Required Field")
           }else if(vNomFacultad == null ||  vNomFacultad == ""){
               nomFacultad.setError("Required Field")
           }else{
               var escuela = Escuela(UUID.randomUUID().toString(),vNomEscuela, vNomFacultad)
               databaseReference.child("Escuela").child(escuela.idescuela).setValue(escuela)
               Toast.makeText(
                   this,
                   "Registro Creado!",
                   Toast.LENGTH_SHORT
               ).show();
           }
        }
    }
    fun iniciarFirebase(){
        FirebaseApp.initializeApp(this)
        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.getReference()
    }
}