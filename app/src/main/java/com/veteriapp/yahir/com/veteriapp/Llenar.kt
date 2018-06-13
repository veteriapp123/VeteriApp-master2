package com.veteriapp.yahir.com.veteriapp


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.FirebaseDatabase


class Llenar : Fragment() {

    private var database = FirebaseDatabase.getInstance()
    private var myReferencia = database.reference
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       val vista=  inflater.inflate(R.layout.fragment_llenar, container, false)


        vista.apply{

            myReferencia.child("Articulo").push().setValue(Articulos("holaa",
                    "holaaaaaaa"))

        }
        return vista
    }


}
