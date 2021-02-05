package com.qbo.appcontrolesbasicoskea3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_lista.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val listapreferencias = ArrayList<String>()
    private val listapersonas = ArrayList<String>()
    private var estadocivil = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ArrayAdapter.createFromResource(this,
            R.array.estado_civil_array,
            android.R.layout.simple_spinner_item
        ).also {
            adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spestadocivil.adapter = adapter
        }

    }

    fun validarGenero(): Boolean{
        var respuesta = true
        if(rggenero.checkedRadioButtonId == -1){
            respuesta = false
        }
        return respuesta
    }

    fun validarNombreApellido(): Boolean{
        var respuesta = true
        if(etnombre.text.toString().trim().isEmpty()){
            etnombre.isFocusableInTouchMode = true
            etnombre.requestFocus()
            respuesta = false
        }else if(etapellido.text.toString().trim().isEmpty()){
            etapellido.isFocusableInTouchMode = true
            etapellido.requestFocus()
            respuesta = false
        }
        return respuesta
    }

    fun enviarMensaje(vista: View, mensaje: String){
        Snackbar.make(vista, mensaje, Snackbar.LENGTH_LONG).show()
    }
}