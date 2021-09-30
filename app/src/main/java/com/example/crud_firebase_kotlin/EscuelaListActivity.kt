package com.example.crud_firebase_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_firebase_kotlin.adapter.EscuelaAdapter
import com.example.crud_firebase_kotlin.model.Docente
import com.example.crud_firebase_kotlin.model.Escuela
import com.google.firebase.database.*

class EscuelaListActivity : AppCompatActivity() {

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var escuelaRecycleview: RecyclerView
    private lateinit var escuelaArrayList: ArrayList<Escuela>
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escuela_list)
        escuelaRecycleview = findViewById(R.id.escuelaList)
        escuelaRecycleview.layoutManager = LinearLayoutManager(this )
        escuelaRecycleview.setHasFixedSize(true)
        escuelaArrayList = arrayListOf<Escuela>()
        getEscuelaData()
    }
    private fun getEscuelaData(){
        databaseReference = FirebaseDatabase.getInstance().getReference("Escuela")
        databaseReference.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(escuelaSnapshot in snapshot.children){

                        val escuela = escuelaSnapshot.getValue(Escuela::class.java)
                        escuelaArrayList.add(escuela!!)
                    }
                    escuelaRecycleview.adapter = EscuelaAdapter(escuelaArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}