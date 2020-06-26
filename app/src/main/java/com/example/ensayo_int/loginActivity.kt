package com.example.ensayo_int

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registro.*

class loginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var datos = intent.extras
        var correo = datos?.getString("correo")
        var contrasena = datos?.getString("contrasena")


        bt_registro.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivityForResult(intent, 1234)
        }
        bt_tomain.setOnClickListener {
            if (et_contrasena_login.text.toString() == contrasena && et_correo_login.text.toString() == correo) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("correo", correo)
                intent.putExtra("contrasena", contrasena)
                startActivity(intent)
            } else if(contrasena==null||correo == null) {
                Toast.makeText(this, "Registrese primero", Toast.LENGTH_LONG).show()

            }
            else
            {
                Toast.makeText(this, "contraseña o usuario incorrectos", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1234 && resultCode == Activity.RESULT_OK){
            val correo = data?.extras?.getString("correo")
            val contrasena = data?.extras?.getString("contrasena")
            Toast.makeText(this, "correo: $correo, contraseña: $contrasena",Toast.LENGTH_LONG).show()
            bt_tomain.setOnClickListener{
                if(et_contrasena_login.text.toString()==contrasena && et_correo_login.text.toString()==correo) {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("correo", correo)
                    intent.putExtra("contrasena", contrasena)
                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(this, "contraseña o usuario incorrectos",Toast.LENGTH_LONG).show()
                }
            }
        }

    }




}