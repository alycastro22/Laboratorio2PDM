package hn.edu.ujcv.pdm_2021_p2_laboratorio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registrar_clase.*

class RegistrarClase : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_clase)
    }
    fun cambioPantalla(view: View) {
        val cambio = Intent(this, MainActivity::class.java)
        startActivity(cambio)
        ingresarDatos();
    }


    fun ingresarDatos(){
        if (txtCodigo.text.isEmpty()){
            Toast.makeText(this, "Ingresar la cuenta", Toast.LENGTH_LONG).show()
        }
        if(textNombre.text.isEmpty()){
            Toast.makeText(this, "Ingresar el nombre", Toast.LENGTH_SHORT).show()
        }
        if(txtSeccion.text.isEmpty()){
            Toast.makeText(this,"Ingresar la seccion", Toast.LENGTH_LONG).show()
        }
        if(txtHora.text.isEmpty()){
            Toast.makeText(this,"Ingresar la hora", Toast.LENGTH_LONG).show()
        }
        if(txtEdificio.text.isEmpty()){
            Toast.makeText(this,"Ingresar el edificio/piso", Toast.LENGTH_LONG).show()
        }
        if(txtAula.text.isEmpty()){
            Toast.makeText(this,"Ingresar el aula", Toast.LENGTH_LONG).show()
        }



    }




}