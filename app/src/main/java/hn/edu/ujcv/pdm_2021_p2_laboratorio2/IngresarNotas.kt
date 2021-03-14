package hn.edu.ujcv.pdm_2021_p2_laboratorio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ingresar_notas.*
import java.lang.StringBuilder

class IngresarNotas : AppCompatActivity() {
    var valores : HashMap<Int,String> = hashMapOf()
    var  numero = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_notas)
    }

    fun cambioPantalla(view: View) {
        val cambio = Intent(this, MainActivity::class.java)
        startActivity(cambio)
    }

    fun guardarnotas(){
        if (editTextAlumno.text.isNotEmpty() && editTextClase.text.isNotEmpty() && editTextAcumulativo.text.isNotEmpty() && editTextExamen.text.isNotEmpty()){
            var dato = StringBuilder()
            numero+1
            dato.append(editTextAlumno.text.toString().trim()).append("|")
            dato.append(editTextClase.text.toString().trim()).append("|")
            dato.append(editTextAcumulativo.text.toString().trim()).append("|")
            dato.append(editTextExamen.text.toString())
            valores.put(numero,dato.toString())
            Toast.makeText(this,"La nota fue guardada con exito", Toast.LENGTH_LONG)

        }else{
            if (editTextAlumno.text.isEmpty()){
                Toast.makeText(this,"Ingrese un alumno", Toast.LENGTH_LONG)
            }
            if (editTextClase.text.isEmpty()){
                Toast.makeText(this,"Ingrese una clase", Toast.LENGTH_LONG)
            }
            if (editTextAcumulativo.text.isEmpty()){
                Toast.makeText(this,"Ingrese la nota del acumulativo", Toast.LENGTH_LONG)
            }
            if (editTextExamen.text.isEmpty()){
                Toast.makeText(this,"Ingrese la nota del examen", Toast.LENGTH_LONG)
            }
        }
    }
}