package hn.edu.ujcv.pdm_2021_p2_laboratorio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class RegistrarAlumno : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_clase)
    }
    fun cambioPantalla(view: View) {
        val cambio = Intent(this, MainActivity::class.java)
        startActivity(cambio)
    }

}