package hn.edu.ujcv.pdm_2021_p2_laboratorio2

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_realizar_matricula.*
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

class RealizarMatricula : AppCompatActivity() {
    var valores : HashMap<Int,String> = hashMapOf()
    var numero = 0
    var listItens = ArrayList<String>()
    var adapter: ArrayAdapter<String>?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_matricula)
        txtMatricular.setOnClickListener { guardarmatricula() }

        findViewById<FloatingActionButton>(R.id.enviar).setOnClickListener { view ->
            addListItem()
            Snackbar.make(view, "Enviar matricula", Snackbar.LENGTH_LONG)
                .setAction("Deshacer", deshacerOnClickListener).show()
        }
    }
    var deshacerOnClickListener: View.OnClickListener = View.OnClickListener { view ->
        listItens.removeAt(listItens.size -1)
        adapter?.notifyDataSetChanged()
        Snackbar.make(view, "Correo enciado cancelado", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
    }
    private fun addListItem(){
        val correo: String=(txtcorreo.text.toString())
        listItens.add(correo)
        adapter?.notifyDataSetChanged()
    }

    override fun onStart(){
        super.onStart()
        adapter= ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            listItens)

        lstView.adapter = adapter
    }
    fun cambioPantalla(view: View) {
        val cambio = Intent(this, MainActivity::class.java)
        startActivity(cambio)
    }
    fun guardarmatricula(){
        if (txtAlumno.text.isNotEmpty() && txtAsignatura.text.isNotEmpty()){
            val dato = StringBuilder()
            numero+1
            dato.append(txtAlumno.text.toString().trim()).append("|")
            dato.append(txtAsignatura.text.toString())
            valores.put(numero, dato.toString())
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmación Recarga")
            builder.setMessage("¿Desea enviar Matricula por correo?")
            builder.setPositiveButton("Enviar", { dialogInterface: DialogInterface, i: Int ->
                txtcorreo.visibility = View.VISIBLE
                enviar.visibility = View.VISIBLE


            })
            builder.setNegativeButton("No enviar", { dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this, "Se matriculo con exito", Toast.LENGTH_LONG)
            })
            builder.show()


        }else{
            if (txtAlumno.text.isEmpty()){
                Toast.makeText(this, "Ingrese el nombre del alumno", Toast.LENGTH_LONG)
            }
            if (txtAsignatura.text.isEmpty()){
                Toast.makeText(this, "Ingrese una asignatura", Toast.LENGTH_LONG)
            }
        }
    }
}