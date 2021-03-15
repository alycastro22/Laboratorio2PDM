package hn.edu.ujcv.pdm_2021_p2_laboratorio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_alumno.*


class AlumnoActivity : AppCompatActivity() {
    var valores: HashMap<Int, String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumno)
        iniciabilizar()
        txtRegresar.setOnClickListener{onBackPressed()}
    }

    private fun iniciabilizar() {
        var intent = intent
        valores = intent.getSerializableExtra("valores") as HashMap<Int, String>
        var cuenta = ""
        var nombre = ""
        var correo = ""

        for (valor in valores) {
            val lista = valor.toString().split("|").toTypedArray()
            cuenta = lista[1]
            nombre = lista[2]
            correo = lista[3]
        }
        txtResultadoAlumno.text = getString(R.string.resultadoalumno, nombre, cuenta, correo)
    }
}