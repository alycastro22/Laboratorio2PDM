package hn.edu.ujcv.pdm_2021_p2_laboratorio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_registrar_clase.*
import kotlinx.android.synthetic.main.activity_registrar_clase.imageRetroceder
import kotlinx.android.synthetic.main.activity_registro_alumno.*
import java.lang.StringBuilder
import java.util.ArrayList

class RegistrarClase : AppCompatActivity() {
    private var valores : HashMap<Int, String> = hashMapOf()
    private var numero = 0
    var listItens = ArrayList<String>()
    var adapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_clase)
        txvRegistrar.setOnClickListener{ guardarclase() }
        imageRetroceder.setOnClickListener { cambioPantalla() }

        findViewById<FloatingActionButton>(R.id.enviarc).setOnClickListener { view ->
            if(txtCodigo.text.isNotEmpty() && textNombre.text.isNotEmpty() && txtSeccion.text.isNotEmpty() && txtHora.text.isNotEmpty() && txtEdificio.text.isNotEmpty() && txtAula.text.isNotEmpty()) {
                addListItem()
                Snackbar.make(view, "Visualizar Registro", Snackbar.LENGTH_LONG)
                        .setAction("No visualizar", deshacerOnClickListener).show()
            }
        }

    }
    var deshacerOnClickListener: View.OnClickListener = View.OnClickListener { view ->
        listItens.removeAt(listItens.size - 1)
        listItens.removeAt(listItens.size - 1)
        adapter?.notifyDataSetChanged()
        Snackbar.make(view, "Registro no visualizado", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }

    fun addListItem() {
        val cuenta: String = (txtCodigo.text.toString())
        val nombre: String = (textNombre.text.toString())

        listItens.add(cuenta)
        listItens.add(nombre)
        adapter?.notifyDataSetChanged()

    }

    override fun onStart() {
        super.onStart()
        adapter = ArrayAdapter(
                this,
                android.R.layout.simple_gallery_item,
                listItens

        )

        lstCView.adapter = adapter
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
            valores.put(numero,dato.toString())
            Toast.makeText(this,"Su clase ha sido guardada con exito", Toast.LENGTH_LONG).show()
            enviarc.visibility = View.VISIBLE

        }else{
            ingresarDatos()
        }
    }

    /*private fun enviarclase() {
        val intent = Intent(this, ClaseActivity::class.java)
        intent.putExtra("valoresclase", valores)
        startActivity(intent)
    }*/


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