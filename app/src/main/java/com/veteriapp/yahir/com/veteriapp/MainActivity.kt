package com.veteriapp.yahir.com.veteriapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.database.FirebaseDatabase
import com.veteriapp.yahir.com.veteriapp.Fragmentos.fragmento_buscar
import com.veteriapp.yahir.com.veteriapp.Fragmentos.fragmento_info
import com.veteriapp.yahir.com.veteriapp.Fragmentos.fragmento_inicio
import com.veteriapp.yahir.com.veteriapp.R.id.message
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {




    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.item_info -> {
                loadfragment(fragmento_info())

                return@OnNavigationItemSelectedListener true
            }
            R.id.item_inicio -> {
                loadfragment2(fragmento_inicio())

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

   // override fun onCreateOptionsMenu(menu: Menu): Boolean {

     //   menuInflater.inflate(R.menu.menu_lateral, menu)
     //   return true
    //}

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.item_sesion -> {
                val intent:Intent= Intent(this,IniciarSesion::class.java)
                startActivity(intent)
             return true
            }
            R.id.item_cerrar_sesion -> {

                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }



    private fun loadfragment (fragl: fragmento_info){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragmento,fragl)
        ft.commit()
    }

    private fun loadfragment2 (fragl: fragmento_inicio){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragmento,fragl)
        ft.commit()
    }

    private fun loadfragment3 (fragl: fragmento_buscar){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragmento,fragl)
        ft.commit()
    }

}
