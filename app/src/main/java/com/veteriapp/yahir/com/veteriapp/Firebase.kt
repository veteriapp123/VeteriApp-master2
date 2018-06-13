package com.veteriapp.yahir.com.veteriapp

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_fragmento_info.view.*
import org.jetbrains.anko.support.v4.toast

object Firebase {

    private var database = FirebaseDatabase.getInstance()
    private var myReferencia = database.reference
    private var id = FirebaseAuth.getInstance().currentUser!!.uid

    fun EnviarArticulo( nombre:String, descripcion:String)
    {
        myReferencia.child("Articulo").push().setValue(Articulos(nombre,
                descripcion))

    }
}