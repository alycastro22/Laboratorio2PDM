package hn.edu.ujcv.pdm_2021_p2_laboratorio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_mostrar_registro_clase.*
import kotlinx.android.synthetic.main.activity_mostrar_registro_clase.txtNombre
import kotlinx.android.synthetic.main.activity_registrar_clase.*
import kotlinx.android.synthetic.main.activity_registrar_clase.enviar
import kotlinx.android.synthetic.main.activity_registro_alumno.*
import java.lang.StringBuilder

class RegistrarClase : AppCompatActivity() {
    var valores : HashMap<Int, String> = hashMapOf()
    var numero = 0

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

    fun cambioPantalla(view: View) {
        val cambio = Intent(this, MainActivity::class.java)
        startActivity(cambio)
        ingresarDatos();
    }
    fun guardarclase(){
        if (txtCodigo.text.isNotEmpty() && textNombre.text.isNotEmpty() && txtSeccion.text.isNotEmpty() && txtHora.text.isNotEmpty() && txtEdificio.text.isNotEmpty() && txtAula.text.isNotEmpty()   ){
            val dato = StringBuilder()
            numero+1
            dato.append(txtCodigo.text.toString().trim()).append("|")
            dato.append(txtNombre.text.toString().trim()).append("|")
            dato.append(txtSeccion.text.toString().trim()).append("|")
            dato.append(txtHora.text.toString().trim()).append("|")
            dato.append(txtEdificio.text.toString().trim()).append("|")
            dato.append(txtAula.text.toString().trim())
            valores.put(numero, dato.toString())
            Toast.makeText(this,"Su clase ha sido guardada con exito", Toast.LENGTH_LONG).show()
            enviar.isEnabled = true
            limpiar()

        }else{
            ingresarDatos()
        }
    }

    private fun enviarclase() {
        val intent = Intent(this, ClaseActivity::class.java)
        intent.putExtra("valores", valores)
        startActivity(intent)
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

    private fun limpiar() {
        txtCodigo.text.clear()
        textNombre.text.clear()
        txtSeccion.text.clear()
        txtHora.text.clear()
        txtEdificio.text.clear()
        txtAula.text.clear()
    }


}