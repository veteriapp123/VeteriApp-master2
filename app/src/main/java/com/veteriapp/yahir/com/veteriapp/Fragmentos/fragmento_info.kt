package com.veteriapp.yahir.com.veteriapp.Fragmentos


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.veteriapp.yahir.com.veteriapp.Articulos
import com.veteriapp.yahir.com.veteriapp.Firebase
import com.veteriapp.yahir.com.veteriapp.R
import com.veteriapp.yahir.com.veteriapp.R.id.*
import kotlinx.android.synthetic.main.fragment_fragmento_info.view.*
import org.jetbrains.anko.support.v4.toast


class fragmento_info : Fragment() {

    private var database = FirebaseDatabase.getInstance()
    private var myReferencia = database.reference

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val vista: View = inflater.inflate(R.layout.fragment_fragmento_info, container, false)

        vista.apply{
            btnAgregarArticulo.setOnClickListener{
                myReferencia.child("Articulos").push().setValue(Articulos(txtNombreArticulo.text.toString(), txtDescripcionArticulo.text.toString()))
                txtNombreArticulo.setText("")
                txtDescripcionArticulo.setText("")
            }
        }
        return vista
    }




}