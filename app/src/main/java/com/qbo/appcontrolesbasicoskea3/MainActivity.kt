package com.qbo.appcontrolesbasicoskea3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckBox
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_lista.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

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
        spestadocivil.onItemSelectedListener = this
        chkdeporte.setOnClickListener {
            agregarListaDePreferenciasSeleccionadas(it)
        }
        chkdibujo.setOnClickListener {
            agregarListaDePreferenciasSeleccionadas(it)
        }
        chkotros.setOnClickListener {
            agregarListaDePreferenciasSeleccionadas(it)
        }
    }
    fun validarFormulario(vista: View): Boolean{
        var respuesta = false
        if(!validarNombreApellido()){
            enviarMensaje(vista, getString(R.string.valerrornomape))
        }else if(!validarGenero()){
            enviarMensaje(vista, getString(R.string.valerrorgenero))
        }else if(!validarEstadoCivil()){
            enviarMensaje(vista, getString(R.string.valerrorestadocivil))
        }else if(!validarPreferencias()){
            enviarMensaje(vista, getString(R.string.valerrorpreferencias))
        }else{
            respuesta = true
        }
        return respuesta
    }
    fun obtnerPreferenciasSeleccionadas() : String{
        var preferencias = ""
        for (preferencia in listapreferencias){
            preferencias += "$preferencia - "
        }
        return preferencias
    }
    fun obtenerGeneroSeleccionado(): String{
        var genero = ""
        when(rggenero.checkedRadioButtonId){
            R.id.rbtnmasculino -> {
                genero = rbtnmasculino.text.toString()
            }
            R.id.rbtnfemenino -> {
                genero = rbtnfemenino.text.toString()
            }
        }
        return genero
    }

    private fun agregarListaDePreferenciasSeleccionadas(vista: View) {
        if(vista is CheckBox){
            val valorcheck: Boolean = vista.isChecked
            /*if(valorcheck)
                listapreferencias.add(vista.text.toString())
            else
                listapreferencias.remove(vista.text.toString())*/
            when(vista.id){
                R.id.chkdeporte -> {
                    if(valorcheck)
                        listapreferencias.add(vista.text.toString())
                    else
                        listapreferencias.remove(vista.text.toString())
                }
                R.id.chkdibujo -> {
                    if(valorcheck)
                        listapreferencias.add(vista.text.toString())
                    else
                        listapreferencias.remove(vista.text.toString())
                }
                R.id.chkotros -> {
                    if(valorcheck)
                        listapreferencias.add(vista.text.toString())
                    else
                        listapreferencias.remove(vista.text.toString())
                }
            }
        }
    }

    fun validarPreferencias():Boolean{
        var respuesta = false
        if(chkdeporte.isChecked || chkdibujo.isChecked || chkotros.isChecked){
            respuesta = true
        }
        return respuesta
    }

    fun validarEstadoCivil(): Boolean{
        var respuesta = true
        if(estadocivil == ""){
            respuesta = false
        }
        return respuesta
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

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        estadocivil = if(position > 0){
            parent!!.getItemAtPosition(position).toString()
        }else{
            ""
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}