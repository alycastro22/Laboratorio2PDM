package hn.edu.ujcv.pdm_2021_p2_laboratorio2

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ingresar_notas.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class IngresarNotas : AppCompatActivity() {
    var valores : HashMap<Int,String> = hashMapOf()
    var  numero = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_notas)
        txvEnviar.setOnClickListener { guardarnotas() }
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

            enviarcorreo()
        }
        if (editTextAlumno.text.isEmpty()){
            Toast.makeText(this,"Ingrese un alumno", Toast.LENGTH_LONG).show()
        }
        if (editTextClase.text.isEmpty()){
            Toast.makeText(this,"Ingrese una clase", Toast.LENGTH_LONG).show()
        }
        if (editTextAcumulativo.text.isEmpty()){
            Toast.makeText(this,"Ingrese la nota del acumulativo", Toast.LENGTH_LONG).show()
        }
        if (editTextExamen.text.isEmpty()){
            Toast.makeText(this,"Ingrese la nota del examen", Toast.LENGTH_LONG).show()
        }

    }
    private fun enviarcorreo(){

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Enviar por Correo")
        builder.setMessage("¿Desea enviar Matricula por correo?")
        builder.setPositiveButton("Enviar", { dialogInterface: DialogInterface, i: Int ->
            val intent = Intent(this, EnviarCorreoActivity::class.java)
            intent.putExtra("valores", valores)
            startActivity(intent)
        })
        builder.setNegativeButton("No enviar", { dialogInterface: DialogInterface, i: Int ->
            Toast.makeText(this,"La nota fue guardada con exito", Toast.LENGTH_LONG).show()
        })
        builder.show()
    }
}