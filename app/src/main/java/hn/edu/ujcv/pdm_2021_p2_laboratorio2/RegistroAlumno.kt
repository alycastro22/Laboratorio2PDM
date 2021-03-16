package hn.edu.ujcv.pdm_2021_p2_laboratorio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_ingresar_notas.*
import kotlinx.android.synthetic.main.activity_registrar_clase.*
import kotlinx.android.synthetic.main.activity_registro_alumno.*
import java.lang.StringBuilder
import java.util.ArrayList

class RegistroAlumno : AppCompatActivity() {
    private var valores :HashMap<Int,String> = hashMapOf()
    private var numero = 0
    var listItens = ArrayList<String>()
    var adapter: ArrayAdapter<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_alumno)
        inicializable()
        txtRegistrar.setOnClickListener { guardarAlumno() }
        findViewById<FloatingActionButton>(R.id.enviara).setOnClickListener { view ->
            if(txtCuenta.text.isNotEmpty() && txtNombre.text.isNotEmpty() && txtCorreo.text.isNotEmpty()) {
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
        val cuenta: String = (txtCuenta.text.toString())
        val nombre: String = (txtNombre.text.toString())

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

        lstAView.adapter = adapter
    }

    fun cambioPantalla() {
        val cambio = Intent(this, MainActivity::class.java)
        startActivity(cambio)
    }

    private fun inicializable() {
        //enviara.isEnabled = false
    }

    fun guardarAlumno(){

        if(txtCuenta.text.isNotEmpty() && txtNombre.text.isNotEmpty() && txtCorreo.text.isNotEmpty()){
            val dato = StringBuilder()
            numero+1
            dato.append(txtCuenta.text.toString().trim()).append("|")
            dato.append(txtNombre.text.toString().trim()).append("|")
            dato.append(txtCorreo.text.toString())
            valores.put(numero,dato.toString())
            Toast.makeText(this, "Su alumno ha sido guardado con exito", Toast.LENGTH_LONG).show()
            enviara.visibility = View.VISIBLE



        }else{
            ingresarDatos()
        }
    }
    /*private fun enviarregistro(){
        val intent = Intent(this, AlumnoActivity::class.java)
        intent.putExtra("valores", valores)
        startActivity(intent)
    }*/


    private fun ingresarDatos(){
        if(txtCuenta.text.isEmpty()){
            Toast.makeText(this, "Ingresar la cuenta", Toast.LENGTH_SHORT).show()
        }
        if (txtNombre.text.isEmpty()){
            Toast.makeText(this, "Ingresar el nombre", Toast.LENGTH_LONG).show()
        }
        if(txtCorreo.text.isEmpty()){
            Toast.makeText(this,"Ingresar el correo", Toast.LENGTH_LONG).show()
        }


    }
}
