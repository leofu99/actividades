package com.example.ensayo_int

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_registro.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern


class RegistroActivity : AppCompatActivity() {
    private lateinit var fecha: String
    private var cal= Calendar.getInstance()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, month)
                cal.set(Calendar.DAY_OF_MONTH,dayOfMonth)

                val format = "MM/dd/yyy"
                val simpleDateFormat = SimpleDateFormat(format, Locale.US)
                fecha = simpleDateFormat.format(cal.time).toString()
                tv_fecha_nacimiento.text = fecha
            }
        ib_calendario.setOnClickListener(){
            DatePickerDialog(
                this,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }
        bt_guardar.setOnClickListener() {
            Log.d("ButtonClicked", "si mi PERRO")
            val nombre = et_nombre.text.toString()
            val telefono = et_telefono.text.toString()
            val correo = et_correo.text.toString()
            val contrasena = et_contrasena.text.toString()
            val conf_contrasena = et_rep_contrasena.text.toString()
            val genero = if (rb_masculino.isChecked) "Masculino" else "Femenino"
            var pasatiempos = ""
            val fecha_nac = tv_fecha_nacimiento.text.toString()
            val ciudadnacimiento = sp_ciudad_nacimiento.selectedItem.toString()
            if (ch_Cine.isChecked) pasatiempos = "$pasatiempos  Cine"
            if (ch_ps4.isChecked) pasatiempos = "$pasatiempos  PS4"
            if (ch_series.isChecked) pasatiempos = "$pasatiempos  TV"
            if (ch_facebook.isChecked) pasatiempos = "$pasatiempos  Facebook"


            if(nombre.isEmpty() || telefono.isEmpty() || correo.isEmpty() || contrasena.isEmpty() || conf_contrasena.isEmpty() ||
                fecha_nac.isEmpty() || ciudadnacimiento.isEmpty()||genero.isEmpty()) {
                Toast.makeText(this, "LLene todos los campos", Toast.LENGTH_SHORT).show()
            }

            else
            {
                if (contrasena.length < 6) {
                    Toast.makeText(this, "la contraseña debe ser mínimo de 6 digitos", Toast.LENGTH_SHORT).show()
                }
                else if (contrasena != conf_contrasena) {
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }

                else if (!isValidEmailId(correo)) {
                    Toast.makeText(this, "Correo inválido", Toast.LENGTH_SHORT).show()
                }
                else
                {

                    Toast.makeText(this, "Registro Exitoso.", Toast.LENGTH_SHORT).show()
                    val intent = Intent()
                    intent.putExtra("correo",et_correo.text.toString())
                    intent.putExtra("contrasena",et_contrasena.text.toString())
                    setResult(Activity.RESULT_OK,intent)
                    finish()

                }
            }
            }

    }

    private fun isValidEmailId(email: String): Boolean {
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }

    override fun onStart() {
        super.onStart()
        Log.d("onStart","ok")
    }

    override fun onResume() {
        super.onResume()
        Log.d("onResume","ok")
    }

    override fun onPause() {
        super.onPause()
        Log.d("onPause","ok")
    }

    override fun onStop() {
        super.onStop()
        Log.d("onStop","ok")
    }


    override fun onRestart() {
        super.onRestart()
        Log.d("onRestart","ok")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("onDestroy","ok")
    }

}