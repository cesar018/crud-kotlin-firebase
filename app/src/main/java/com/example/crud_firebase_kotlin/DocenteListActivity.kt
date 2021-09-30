package com.example.crud_firebase_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_firebase_kotlin.adapter.DocenteAdapter
import com.example.crud_firebase_kotlin.adapter.EscuelaAdapter
import com.example.crud_firebase_kotlin.model.Docente
import com.example.crud_firebase_kotlin.model.Escuela
import com.google.firebase.database.*

class DocenteListActivity : AppCompatActivity() {

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var docenteRecycleview: RecyclerView
    private lateinit var docenteArrayList: ArrayList<Docente>
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_docente_list)
        docenteRecycleview = findViewById(R.id.docenteList)
        docenteRecycleview.layoutManager = LinearLayoutManager(this )
        docenteRecycleview.setHasFixedSize(true)
        docenteArrayList = arrayListOf<Docente>()
        getDocenteData()
    }
    private fun getDocenteData(){
        databaseReference = FirebaseDatabase.getInstance().getReference("Docente")
        databaseReference.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(docenteSnapshot in snapshot.children){

                        val docente = docenteSnapshot.getValue(Docente::class.java)
                        docenteArrayList.add(docente!!)
                    }
                    docenteRecycleview.adapter = DocenteAdapter(docenteArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}