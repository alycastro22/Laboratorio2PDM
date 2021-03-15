package hn.edu.ujcv.pdm_2021_p2_laboratorio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_clase.*

class ClaseActivity : AppCompatActivity() {
    private var valores: HashMap<Int, String> = hashMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clase)
        inicializar()
       txtRegresar.setOnClickListener { onBackPressed() }
    }

    private fun inicializar() {
        val intent = intent

        valores = intent.getSerializableExtra("valoresclase") as HashMap<Int, String>
        var codigo = ""
        var nombre = ""
        var seccion = ""
        var hora = ""
        var edificio = ""
        var aula  = ""

        for (valor in valores) {
            val lista = valor.toString().split("|").toTypedArray()
            codigo = lista[1]
            nombre = lista[2]
            seccion = lista[3]
            hora = lista[4]
            edificio = lista[5]
            aula = lista[6]
        }

        txvResultadoClase.text = getString(R.string.resultadoClase, nombre, codigo, edificio, hora, aula, seccion)
    }

}