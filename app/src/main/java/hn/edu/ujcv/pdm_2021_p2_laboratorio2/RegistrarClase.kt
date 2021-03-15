package hn.edu.ujcv.pdm_2021_p2_laboratorio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registrar_clase.*
import java.lang.StringBuilder

class RegistrarClase : AppCompatActivity() {
    private var valores : HashMap<Int, String> = hashMapOf()
    private var numero = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_clase)
        inicializar()
        txvRegistrar.setOnClickListener{ guardarclase() }
        enviar.setOnClickListener { enviarclase() }

    }

    private fun inicializar() {
        enviar.isEnabled = false
    }

    fun cambioPantalla() {
        val cambio = Intent(this, MainActivity::class.java)
        startActivity(cambio)
    }

    private fun guardarclase(){
        if (txtCodigo.text.isNotEmpty() && textNombre.text.isNotEmpty() && txtSeccion.text.isNotEmpty() && txtHora.text.isNotEmpty() && txtEdificio.text.isNotEmpty() && txtAula.text.isNotEmpty()){
            val dato = StringBuilder()
            numero+1
            dato.append(txtCodigo.text.toString().trim()).append("|")
            dato.append(textNombre.text.toString().trim()).append("|")
            dato.append(txtSeccion.text.toString().trim()).append("|")
            dato.append(txtHora.text.toString().trim()).append("|")
            dato.append(txtEdificio.text.toString().trim()).append("|")
            dato.append(txtAula.text.toString())
            valores[numero] = dato.toString()
            Toast.makeText(this,"Su clase ha sido guardada con exito", Toast.LENGTH_LONG).show()
            enviar.isEnabled = true

        }else{
            ingresarDatos()
        }
    }

    private fun enviarclase() {
        val intent = Intent(this, ClaseActivity::class.java)
        intent.putExtra("valoresclase", valores)
        startActivity(intent)
    }


    private fun ingresarDatos(){

        if (txtCodigo.text.isEmpty()) {
            Toast.makeText(this, "Ingresar el código", Toast.LENGTH_SHORT).show()
        }
        if (textNombre.text.isEmpty()) {
            Toast.makeText(this, "Ingresar el nombre", Toast.LENGTH_SHORT).show()
        }
        if (txtSeccion.text.isEmpty()) {
            Toast.makeText(this, "Ingresar la seccion", Toast.LENGTH_SHORT).show()
        }
        if (txtHora.text.isEmpty()) {
            Toast.makeText(this, "Ingresar la hora", Toast.LENGTH_SHORT).show()
        }
        if (txtEdificio.text.isEmpty()) {
            Toast.makeText(this, "Ingresar el edificio/piso", Toast.LENGTH_SHORT).show()
        }
        if (txtAula.text.isEmpty()) {
            Toast.makeText(this, "Ingresar el aula", Toast.LENGTH_SHORT).show()
        }

    }



}