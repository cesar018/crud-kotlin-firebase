package com.example.crud_firebase_kotlin.model

class Escuela {
    var idescuela: String = ""
    var nombre: String = ""
    var facultad: String = ""

    constructor(){}

    constructor(idescuela: String, nombre: String, facultad: String) {
        this.idescuela = idescuela
        this.nombre = nombre
        this.facultad = facultad
    }
}