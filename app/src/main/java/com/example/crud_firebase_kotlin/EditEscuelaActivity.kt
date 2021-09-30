package com.example.crud_firebase_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.widget.Button
import android.widget.EditText
import com.example.crud_firebase_kotlin.adapter.EscuelaAdapter
import com.example.crud_firebase_kotlin.model.Escuela
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseError
import com.google.firebase.database.*

class EditEscuelaActivity : AppCompatActivity() {
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference
    private lateinit var escuelaArrayList: ArrayList<Escuela>

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

    fun llamardatos(){
        databaseReference = FirebaseDatabase.getInstance().getReference("Escuela")
        databaseReference.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(escuelaSnapshot in snapshot.children){

                        val escuela = escuelaSnapshot.getValue(Escuela::class.java)
                        if(escuela?.idescuela.toString().equals("ganssuo")){

                        }
                        escuelaArrayList.add(escuela!!)
                    }

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}