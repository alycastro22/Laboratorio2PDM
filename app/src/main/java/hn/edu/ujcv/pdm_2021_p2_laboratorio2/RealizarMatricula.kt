package hn.edu.ujcv.pdm_2021_p2_laboratorio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_realizar_matricula.*
import java.lang.StringBuilder

class RealizarMatricula : AppCompatActivity() {
    var valores : HashMap<Int,String> = hashMapOf()
    var numero = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_matricula)

    }
    fun cambioPantalla(view: View) {
        val cambio = Intent(this, MainActivity::class.java)
        startActivity(cambio)
    }
    fun guardarmatricula(){
        if (txtAlumno.text.isNotEmpty() && txtAsignatura.text.isNotEmpty()){
            val dato = StringBuilder()
            numero+1
            dato.append(txtAlumno.text.toString().trim()).append("|")
            dato.append(txtAsignatura.text.toString())
            valores.put(numero, dato.toString())
            Toast.makeText(this, "Se matriculo con exito", Toast.LENGTH_LONG)

        }else{
            if (txtAlumno.text.isEmpty()){
                Toast.makeText(this, "Ingrese el nombre del alumno", Toast.LENGTH_LONG)
            }
            if (txtAsignatura.text.isEmpty()){
                Toast.makeText(this, "Ingrese una asignatura", Toast.LENGTH_LONG)
            }
        }
    }
}