package com.practicasII.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.practicasII.calculator.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var firstValue: Double = 0.0
    var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnborrar.setOnClickListener{
            binding.etResultado.setText(binding.etResultado.text.dropLast(1))
        }

        binding.btnLimpiar.setOnClickListener{
            binding.etResultado.text.clear()
        }

        binding.btnIgual.setOnClickListener{
            when(operator){
                "Multiplication" ->{
                    binding.etResultado.setText("${firstValue * binding.etResultado.text.toString().toDouble()}")
                }
                "Division" ->{
                    binding.etResultado.setText("${firstValue / binding.etResultado.text.toString().toDouble()}")
                }
                "Addition" ->{
                    binding.etResultado.setText("${firstValue + binding.etResultado.text.toString().toDouble()}")
                }
                "Subtraction" ->{
                    binding.etResultado.setText("${firstValue - binding.etResultado.text.toString().toDouble()}")
                }
                else -> { }
            }
        }

        binding.btnPorcentaje.setOnClickListener{
            binding.etResultado.setText("${binding.etResultado.text.toString().toDouble() / 100}")
        }

    }

    fun botonPresionado(view: View){
        val boton = view as Button
        when(boton.id){
            binding.btnDecimal.id->{
                if(!binding.etResultado.text.contains('.') ){
                    binding.etResultado.text.append(".")
                }
            }

            binding.btnCero.id ->{binding.etResultado.text.append("0")}
            binding.btnUno.id ->{binding.etResultado.text.append("1")}
            binding.btnDos.id ->{binding.etResultado.text.append("2")}
            binding.btnTres.id ->{binding.etResultado.text.append("3")}
            binding.btnCuatro.id ->{binding.etResultado.text.append("4")}
            binding.btnCinco.id ->{binding.etResultado.text.append("5")}
            binding.btnSeis.id ->{binding.etResultado.text.append("6")}
            binding.btnSiete.id ->{binding.etResultado.text.append("7")}
            binding.btnOcho.id ->{binding.etResultado.text.append("8")}
            binding.btnNueve.id ->{binding.etResultado.text.append("9")}
            binding.btnDecimal.id ->{binding.etResultado.text.append(".")}
            binding.btnMultiplication.id ->{}
            binding.btnPorcentaje.id ->{}
            binding.btnDivision.id ->{}
            binding.btnAddition.id ->{}
            binding.btnSubtracion.id ->{}
            binding.btnIgual.id ->{}
            else ->{Toast.makeText(this,"error", Toast.LENGTH_SHORT).show()}
        }
    }

    fun operatorclick(view: View){
        val button = view as Button
        operator = when(button.id){
            binding.btnMultiplication.id -> {"Multiplication"}
            binding.btnDivision.id -> {"Division"}
            binding.btnAddition.id -> {"Addition"}
            binding.btnSubtracion.id -> {"Subtraction"}
            else ->{""}
        }

        firstValue = binding.etResultado.text.toString().toDouble()

        binding.etResultado.text.clear()
    }

}