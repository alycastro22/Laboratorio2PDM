package hn.edu.ujcv.pdm_2021_p2_laboratorio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun pantallaAlumnos(view: View){
        val cambio = Intent(this, RegistroAlumno::class.java)
        startActivity(cambio)
    }

    fun pantallaClase(view: View) {
        val cambio = Intent(this, RegistrarClase::class.java)
        startActivity(cambio)
    }

    fun pantallaMatricula(view: View) {
        val cambio = Intent(this, RealizarMatricula::class.java)
        startActivity(cambio)
    }

    fun pantallaNotas(view: View) {
        val cambio = Intent(this, IngresarNotas::class.java)
        startActivity(cambio)
    }


    fun Registrar(view: View) {}

}