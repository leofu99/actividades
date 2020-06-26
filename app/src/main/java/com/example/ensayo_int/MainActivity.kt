package com.example.ensayo_int

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val datos = intent.extras
        val correo = datos?.getString("correo")
        val contrasena = datos?.getString("contrasena")
        tv_main.text= correo
        tv_contrasena.text = contrasena

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.cerrar_sesion){
            val intent = Intent(this,loginActivity::class.java)
            intent.putExtra("correo",tv_main.text.toString() )
            intent.putExtra("contrasena", tv_contrasena.text.toString())
            startActivity(intent)

        }

        return super.onOptionsItemSelected(item)
    }


}

