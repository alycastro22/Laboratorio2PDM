package hn.edu.ujcv.pdm_2021_p2_laboratorio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registrar_clase.*
import kotlinx.android.synthetic.main.activity_registro_alumno.*
import java.lang.StringBuilder

class RegistroAlumno : AppCompatActivity() {
    var valores :HashMap<Int,String> = hashMapOf()
    var numero = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_alumno)

    }
    fun cambioPantalla(view: View) {
        val cambio = Intent(this, MainActivity::class.java)
        startActivity(cambio)

    }
    fun guardarAlumno(){
        if(txtCuenta.text.isNotEmpty() && txtNombre.text.isNotEmpty() && txtCorreo.text.isNotEmpty()){
            val dato = StringBuilder()
            numero+1
            dato.append(txtCuenta.text.toString().trim()).append("|")
            dato.append(txtNombre.text.toString().trim()).append("|")
            dato.append(txtCorreo.text.toString())
            valores.put(numero, dato.toString())
            Toast.makeText(this, "Alumno guardado con exito", Toast.LENGTH_LONG)

        }else{
            ingresarDatos()
        }
    }
    fun ingresarDatos(){
        if(txtCuenta.text.isEmpty()){
            Toast.makeText(this, "Ingresar la cuenta", Toast.LENGTH_SHORT).show()
        }
        if (txtNombre.text.isEmpty()){
            Toast.makeText(this, "Ingresar el nombre", Toast.LENGTH_LONG).show()
        }
        if(txtCorreo.text.isEmpty()){
            Toast.makeText(this,"Ingresar lel correo", Toast.LENGTH_LONG).show()
        }


    }
}
