package com.example.crud_firebase_kotlin.model

class Docente {
    var iddocente: String=""
    var codigo: String=""
    var nombre: String=""
    var dni: String=""
    var telefono: String=""
    var correo: String=""

    constructor(){}
    constructor(iddocente: String, codigo: String, nombre: String, dni: String, telefono: String, correo: String) {
        this.iddocente = iddocente
        this.codigo = codigo
        this.nombre = nombre
        this.dni = dni
        this.telefono = telefono
        this.correo = correo
    }
}