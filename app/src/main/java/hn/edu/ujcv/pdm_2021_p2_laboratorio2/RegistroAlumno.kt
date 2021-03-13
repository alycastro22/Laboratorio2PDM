package hn.edu.ujcv.pdm_2021_p2_laboratorio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registrar_clase.*
import kotlinx.android.synthetic.main.activity_registro_alumno.*

class RegistroAlumno : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_alumno)
        ingresarDatos()

    }
    fun cambioPantalla(view: View) {
        val cambio = Intent(this, MainActivity::class.java)
        startActivity(cambio)

    }
    fun ingresarDatos(){
        if (txtNombre.text.isEmpty()){
            Toast.makeText(this, "Ingresar el nombre", Toast.LENGTH_LONG).show()
        }
        if(txtCuenta.text.isEmpty()){
            Toast.makeText(this, "Ingresar la cuenta", Toast.LENGTH_SHORT).show()
        }
        if(txtCorreo.text.isEmpty()){
            Toast.makeText(this,"Ingresar lel correo", Toast.LENGTH_LONG).show()
        }


    }
}
