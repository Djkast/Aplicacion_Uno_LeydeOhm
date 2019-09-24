package com.example.cgti.leyohmapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Acciones necesarias para el calculo de los tres valores
        //Resistencia, Corriente y voltaje
        val spinner: Spinner = findViewById(R.id.spAccion)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
                this,
                R.array.actions_array,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        /**
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }**/

        //Manejar el evento de clic del boton
        btnCalcular.setOnClickListener(){
            val spinner: Spinner = findViewById(R.id.spAccion)

            if (spinner.selectedItem.toString() == "Voltaje") {
                var varUno:Double = edtCorriente.text.toString().toDouble()
                var varDos:Double = edtResistencia.text.toString().toDouble()
                var res:Double = varUno * varDos
                txvResultado.text = "Voltaje = ${res.toString()} V"
            }
            else if (spinner.selectedItem.toString() == "Corriente")
            {
                var varUno:Double = edtVoltaje.text.toString().toDouble()
                var varDos:Double = edtResistencia.text.toString().toDouble()
                var res:Double = varUno / varDos
                txvResultado.text = "Corriente = ${res.toString()} A"
            }
            else
            {
                var varUno:Double = edtVoltaje.text.toString().toDouble()
                var varDos:Double = edtCorriente.text.toString().toDouble()
                var res:Double = varUno/varDos
                txvResultado.text = "Resistencia = ${res.toString()} Ohm"
            }

        }

    }
}
