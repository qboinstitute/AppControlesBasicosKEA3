package com.qbo.appcontrolesbasicoskea3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista.*

class ListaActivity : AppCompatActivity() {

    var listapersonas = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)
        listapersonas = intent.getSerializableExtra("listapersonas") as ArrayList<String>
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listapersonas)
        lvpersonas.adapter = adapter
    }
}