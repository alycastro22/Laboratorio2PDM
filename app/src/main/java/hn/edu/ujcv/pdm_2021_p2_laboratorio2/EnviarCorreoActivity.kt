package hn.edu.ujcv.pdm_2021_p2_laboratorio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_enviar_correo.*
import kotlinx.android.synthetic.main.activity_enviar_correo.lstView
import kotlinx.android.synthetic.main.activity_enviar_correo.txtcorreo
import kotlinx.android.synthetic.main.activity_realizar_matricula.*
import java.util.ArrayList

class EnviarCorreoActivity : AppCompatActivity() {
    var valores: HashMap<Int, String> = hashMapOf()
    var listItens = ArrayList<String>()
    var adapter: ArrayAdapter<String>?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_correo)
        mostrarenPantalla()
        findViewById<FloatingActionButton>(R.id.enviar).setOnClickListener { view ->
            addListItem()
            Snackbar.make(view, "Enviar Notas", Snackbar.LENGTH_LONG)
                .setAction("Deshacer", deshacerOnClickListener).show()
        }
    }
    fun cambioPantalla(view: View) {
        val cambio = Intent(this, MainActivity::class.java)
        startActivity(cambio)
    }
    var deshacerOnClickListener: View.OnClickListener = View.OnClickListener { view ->
        listItens.removeAt(listItens.size -1)
        adapter?.notifyDataSetChanged()
        Snackbar.make(view, "Correo cancelado", Snackbar.LENGTH_LONG)
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

   fun mostrarenPantalla(){
       var intent   = intent
       valores      = intent.getSerializableExtra("valores") as HashMap<Int, String>
        var alumno = " "
        var clases = " "
        var acumulativo = 0
       var examen = 0
       var nota = 0

       for (valor in valores){
           val lista= valor.toString().split("|").toTypedArray()
           alumno =  lista[0]
           clases =  lista[1].toString()
           acumulativo= lista[2].toInt()
           examen= lista[3].toInt()
           nota = acumulativo + examen

       }
        txtDatos.text = getString(R.string.Datos, alumno, clases, nota.toString())
    }
}