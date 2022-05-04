package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.text.NumberFormat

class MainActivity : AppCompatActivity(), View.OnFocusChangeListener {

    private lateinit var txtAltura : EditText
    private lateinit var txtPeso : EditText
    private lateinit var txtResultado : TextView

    private val formatador = NumberFormat.getNumberInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtAltura = this.findViewById(R.id.txtAltura)
        txtAltura.onFocusChangeListener = this

        txtPeso = this.findViewById(R.id.txtPeso)
        txtPeso.onFocusChangeListener = this


    }

    private fun calcularIMC() {
        if (txtAltura.text.toString().isNotEmpty()
            && txtPeso.text.toString().isNotEmpty()) {

            var peso = txtPeso.text.toString().toDouble()
            var altura = txtAltura.text.toString().toDouble()

            var resultadoFinal = peso / (altura * altura)

            txtResultado = this.findViewById(R.id.txtResultado)
            txtResultado.setText(formatador.format(resultadoFinal))
        }
    }

    override fun onFocusChange(p0: View?, p1: Boolean) {
        this.calcularIMC()
    }
}