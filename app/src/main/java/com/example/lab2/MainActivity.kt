package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickTest(view: View){
        val textShow = findViewById<TextView>(R.id.textShow)
        try {
            val a = findViewById<EditText>(R.id.editA).text.toString().toDouble()
            val b = findViewById<EditText>(R.id.editB).text.toString().toDouble()
            val c = findViewById<EditText>(R.id.editC).text.toString().toDouble()

            val des = (b * b - 4 * a * c)

            if (des > 0.0){
                if (a == 0.0){
                    val x = -c / b
                    textShow.text = "Дискриминант больше 0\nЛинейное уравнение: x=$x"
                }
                else{
                    val x1 = String.format("%.2f", ((-b + sqrt(des)) / (2 * a)))
                    val x2 = String.format("%.2f", ((-b - sqrt(des)) / (2 * a)))
                    textShow.text = "Дискриминант больше 0\nx1=$x1\nx2=$x2"
                }
            }

            else if (des == 0.0){
                if (a == 0.0 && b != 0.0){
                    val x = String.format("%.3f",(-b / (2 * a)))
                    textShow.text = "Дискриминант равен 0\nx1=x2=$x"
                }
                else {
                    textShow.text = "Нет корней"
                }
            }
            else{
                textShow.text = "Нет корней"
            }
        }

        catch (e: Exception){
            textShow.text = "Введите коэффициенты квадратного уравнения"
        }
    }
}