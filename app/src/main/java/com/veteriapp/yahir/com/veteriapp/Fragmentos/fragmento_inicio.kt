package com.veteriapp.yahir.com.veteriapp.Fragmentos

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

import com.veteriapp.yahir.com.veteriapp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.articulos.view.*
import kotlinx.android.synthetic.main.fragment_fragmento_inicio.*
import java.util.ArrayList
import java.util.HashMap

class fragmento_inicio : Fragment() {

    private var database = FirebaseDatabase.getInstance()
    private var myReferencia = database.reference

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val vista = inflater.inflate(R.layout.fragment_fragmento_inicio,container,false)

        return vista
    }


    override fun onStart() {
        super.onStart()
        adaptador = MiAdaptadorDePublicaciones(ListaPublicaciones)
        Articulo.adapter = adaptador
        cargarPost()
    }



    inner class MiAdaptadorDePublicaciones:BaseAdapter{

        var listaDeAdaptadorDeArticulos = ArrayList<Publicacion>()

        constructor(listaDeAdaptadorDePublis: ArrayList<Publicacion>) : super() {
            this.listaDeAdaptadorDeArticulos = listaDeAdaptadorDePublis
        }


        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {


            var miPublicacion = listaDeAdaptadorDeArticulos[p0]
            if (miPublicacion.TextoPublicacion.equals("add"))
            {

                return layoutInflater.inflate(R.layout.articulos,null)


            }
            else
            {
                var miVista = layoutInflater.inflate(R.layout.articulos, null)
                miVista.txt_NombreArticulo.setText(miPublicacion.NombrePersona)
                miVista.TextoArticulo.setText(miPublicacion.TextoPublicacion)
                return miVista
            }

        }

        override fun getItem(p0: Int): Any {
            return listaDeAdaptadorDeArticulos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listaDeAdaptadorDeArticulos.size
        }

    }






    var ListaPublicaciones = ArrayList<Publicacion>()
    var adaptador: MiAdaptadorDePublicaciones? = null
    fun cargarPost() {
        myReferencia.child("Articulos")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot?) {

                        try {

                            ListaPublicaciones.clear()
                            ListaPublicaciones.add(Publicacion("0", "0", "add"))

                            var td = dataSnapshot!!.value as HashMap<String, Any>
                            for (llave in td.keys) {

                                var post = td[llave] as HashMap<String, Any>
                                ListaPublicaciones.add(Publicacion(llave,
                                        post["articulo"] as String,
                                        post["nombre"] as String))

                            }

                            adaptador!!.notifyDataSetChanged()
                        } catch (ex: Exception) {
                        }
                    }

                    override fun onCancelled(p0: DatabaseError?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                })
    }


}