package com.example.crud_firebase_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.crud_firebase_kotlin.model.Docente
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class AddDocenteActivity : AppCompatActivity() {
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_docente)

        val addButton = findViewById<Button>(R.id.button2)
        val codDocente = findViewById<EditText>(R.id.txtcod_doc)
        val nomDocente = findViewById<EditText>(R.id.txtnom_doc)
        val dniDocente = findViewById<EditText>(R.id.txt_dni)
        val telDocente = findViewById<EditText>(R.id.txt_tel)
        val corDocente = findViewById<EditText>(R.id.txt_correo)

        ejecutarFirebase()

        addButton.setOnClickListener{
            val vCodDocente = codDocente.text.toString()
            val vNomDocente = nomDocente.text.toString()
            val vDniDocente = dniDocente.text.toString()
            val vTelDocente = telDocente.text.toString()
            val vCorDocente = corDocente.text.toString()

            if(vCodDocente == null || vCodDocente == ""){
                codDocente.setError("Required Failed")
            }else if(vNomDocente == null || vNomDocente ==""){
                nomDocente.setError("Required Failed")
            } else if(vDniDocente == null || vDniDocente == ""){
                dniDocente.setError("Required Failed")
            } else if(vTelDocente == null || vTelDocente == ""){
                telDocente.setError("Required Failed")
            } else if(vCorDocente == null || vCorDocente == ""){
                corDocente.setError("Required Failed")
            } else{
                var docente = Docente(UUID.randomUUID().toString(),vCodDocente,vNomDocente,vDniDocente,vTelDocente,vCodDocente)
                databaseReference.child("Docente").child(docente.iddocente).setValue(docente)
                Toast.makeText(
                    this,
                    "Registro Creado:",
                    Toast.LENGTH_SHORT
                ).show();
            }
        }
    }
    fun ejecutarFirebase(){
        FirebaseApp.initializeApp(this )
        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.getReference()
    }
}