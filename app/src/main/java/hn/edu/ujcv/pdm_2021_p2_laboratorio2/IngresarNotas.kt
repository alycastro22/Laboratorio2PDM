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
import kotlinx.android.synthetic.main.activity_ingresar_notas.*
import kotlinx.android.synthetic.main.activity_ingresar_notas.lstCView
import kotlinx.android.synthetic.main.activity_ingresar_notas.txtcorreo
import java.lang.StringBuilder
import java.util.ArrayList

class IngresarNotas : AppCompatActivity() {
    var valores : HashMap<Int,String> = hashMapOf()
    var  numero = 0
    var listItens = ArrayList<String>()
    var adapter: ArrayAdapter<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_notas)
        txvEnviar.setOnClickListener { guardarnotas() }

        findViewById<FloatingActionButton>(R.id.enviarn).setOnClickListener { view ->
            if (txtcorreo.text.isNotEmpty()){
                addListItem()
                Snackbar.make(view, "Enviar Notas", Snackbar.LENGTH_LONG)
                        .setAction("Deshacer", deshacerOnClickListener).show()
            }else{
                Toast.makeText(this,"Ingrese correo", Toast.LENGTH_LONG).show()
            }

        }
    }

    var deshacerOnClickListener: View.OnClickListener = View.OnClickListener { view ->
        listItens.removeAt(listItens.size - 1)
        adapter?.notifyDataSetChanged()
        Snackbar.make(view, "Correo enviado cancelado", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }

    fun addListItem() {
        var examen = 0
        var acum =  0
        examen = editTextExamen.text.toString().toInt()
        acum =  editTextAcumulativo.text.toString().toInt()
        val nota: Int =  examen + acum
        listItens.add(nota.toString())
        adapter?.notifyDataSetChanged()

    }

    override fun onStart() {
        super.onStart()
        adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                listItens
        )

        lstCView.adapter = adapter
    }

    fun cambioPantalla(view: View) {
        val cambio = Intent(this, MainActivity::class.java)
        startActivity(cambio)
    }

    fun guardarnotas(){
        if (editTextAlumno.text.isEmpty()){
            Toast.makeText(this,"Ingrese un alumno", Toast.LENGTH_LONG).show()
        }
        if (editTextClase.text.isEmpty()){
            Toast.makeText(this,"Ingrese una clase", Toast.LENGTH_LONG).show()
        }
        if (editTextAcumulativo.text.isEmpty()){
            Toast.makeText(this,"Ingrese la nota del acumulativo", Toast.LENGTH_LONG).show()
        }
        if (editTextExamen.text.isEmpty()){
            Toast.makeText(this,"Ingrese la nota del examen", Toast.LENGTH_LONG).show()
        }

         if (editTextAlumno.text.isNotEmpty() && editTextClase.text.isNotEmpty() && editTextAcumulativo.text.isNotEmpty() && editTextExamen.text.isNotEmpty()
                && editTextExamen.text.toString().toDouble()> 0 && editTextExamen.text.toString().toDouble() < 51 && editTextAcumulativo.text.toString().toDouble()> 0 && editTextAcumulativo.text.toString().toDouble() < 51) {

            var dato = StringBuilder()
            numero+1
            dato.append(editTextAlumno.text.toString().trim()).append("|")
            dato.append(editTextClase.text.toString().trim()).append("|")
            dato.append(editTextAcumulativo.text.toString().trim()).append("|")
            dato.append(editTextExamen.text.toString())
            valores.put(numero,dato.toString())

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Enviar notas por correo")
            builder.setMessage("¿Desea enviar notas por correo?")
            builder.setPositiveButton("Enviar", { dialogInterface: DialogInterface, i: Int ->
                txtcorreo.visibility = View.VISIBLE
                enviarn.visibility = View.VISIBLE
            })
            builder.setNegativeButton("No enviar", { dialogInterface: DialogInterface, i: Int ->
                Toast.makeText(this, "Se matriculo con exito", Toast.LENGTH_LONG).show()
            })
            builder.show()
        } else {
            Toast.makeText(this,"Ingrese la nota del examen o acumulato mayor a 0 y menor que 51", Toast.LENGTH_LONG).show()
        }


    }
   /* private fun enviarcorreo(){

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Enviar por Correo")
        builder.setMessage("¿Desea enviar Matricula por correo?")
        builder.setPositiveButton("Enviar", { dialogInterface: DialogInterface, i: Int ->
            val intent = Intent(this, EnviarCorreoActivity::class.java)
            intent.putExtra("valores", valores)
            startActivity(intent)
        })
        builder.setNegativeButton("No enviar", { dialogInterface: DialogInterface, i: Int ->
            Toast.makeText(this,"La nota fue guardada con exito", Toast.LENGTH_LONG).show()
        })
        builder.show()
    }*/
}