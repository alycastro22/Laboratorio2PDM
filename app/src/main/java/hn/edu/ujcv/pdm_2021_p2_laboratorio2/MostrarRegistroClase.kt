package hn.edu.ujcv.pdm_2021_p2_laboratorio2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_mostrar_registro_clase.*
import kotlinx.android.synthetic.main.activity_mostrar_registro_clase.txtNombre
import kotlinx.android.synthetic.main.activity_registrar_clase.*
import kotlinx.android.synthetic.main.activity_registro_alumno.*

class MostrarRegistroClase : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_matricula)

    }

    fun Registrar(view: View) {
        var nombre = txtNombre.text.toString()
        var cuenta = txtCuenta.text.toString()
        var seccion = txtSeccion.text.toString()
        var hora = txtHora.text.toString()
        var edificio = txtEdificio.text.toString()
        var aula = txtAula.text.toString()

        var tabla = findViewById<View>(R.id.tablaRegistros) as TableLayout
        btnAgregar.setOnClickListener() {
            var cadena = arrayOf(nombre,cuenta,seccion,hora,edificio,aula)
            var text: TextView
            var fila = TableRow(baseContext)
            for(i in 0..1){
                text = TextView(baseContext)
                text.gravity = Gravity.CENTER_VERTICAL
                text.setPadding(15,15,15,15)
                text.setBackgroundResource(R.color.purple_200)
                text.text = (cadena[i])
                text.setTextColor(Color.WHITE)
                fila.addView(text)
            }
            tabla.addView(fila)
        }
    }
}